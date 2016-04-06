package br.com.altamira.data.wbccad.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.altamira.data.wbccad.exception.OrcItmHasDifferenceException;
import br.com.altamira.data.wbccad.exception.OrcItmHasDuplicateException;
import br.com.altamira.data.wbccad.exception.OrcItmNotFoundException;
import br.com.altamira.data.wbccad.exception.OrcMatHasDifferenceException;
import br.com.altamira.data.wbccad.exception.OrcMatHasDuplicateException;
import br.com.altamira.data.wbccad.exception.OrccabNotFoundException;
import br.com.altamira.data.wbccad.exception.PrdorcNotFoundException;
import br.com.altamira.data.wbccad.model.IntegracaoOrccab;
import br.com.altamira.data.wbccad.model.IntegracaoOrcitm;
import br.com.altamira.data.wbccad.model.IntegracaoOrcprd;
import br.com.altamira.data.wbccad.model.OrcDet;
import br.com.altamira.data.wbccad.model.OrcItm;
import br.com.altamira.data.wbccad.model.OrcMat;
import br.com.altamira.data.wbccad.model.Orccab;
import br.com.altamira.data.wbccad.model.Orclst;
import br.com.altamira.data.wbccad.model.Prdest;
import br.com.altamira.data.wbccad.model.Prdorc;
import br.com.altamira.data.wbccad.repository.IntegracaoOrccabRepository;
import br.com.altamira.data.wbccad.repository.IntegracaoOrcitmRepository;
import br.com.altamira.data.wbccad.repository.IntegracaoOrcprdRepository;
import br.com.altamira.data.wbccad.repository.OrcDetRepository;
import br.com.altamira.data.wbccad.repository.OrcMatRepository;
import br.com.altamira.data.wbccad.repository.OrccabRepository;
import br.com.altamira.data.wbccad.repository.OrcitmRepository;
import br.com.altamira.data.wbccad.repository.OrclstRepository;
import br.com.altamira.data.wbccad.repository.PrdestRepository;
import br.com.altamira.data.wbccad.repository.PrdorcRepository;

@Controller
public class OrccabController {

	@Autowired
	private OrccabRepository orccabRepository;

	@Autowired
	private OrcitmRepository orcitmRepository;

	@Autowired
	private OrcMatRepository orcMatRepository;

	@Autowired
	private PrdorcRepository prdorcRepository;

	@Autowired
	private PrdestRepository prdestRepository;

	@Autowired
	private OrcDetRepository orcDetRepository;	
	
	@Autowired
	private OrclstRepository orclstRepository;
	
	@Autowired
	private IntegracaoOrccabRepository integracaoOrccabRepository;
	
	@Autowired
	private IntegracaoOrcitmRepository integracaoOrcitmRepository;
	
	@Autowired
	private IntegracaoOrcprdRepository integracaoOrcprdRepository;
	
	@JmsListener(destination = "/wbccad/orccab/v1/request")
	@SendTo("/wbccad/orccab/v1/response")
	public Orccab export(String numero) throws Exception {
		Orccab orccab = null;

		String numeroRevisao = numero;

		System.out.println(String.format("\n\n--> Solicitado orcamento %s.",
				numero));
		
		Orclst orclst = orclstRepository.findByOrclstNumero(numero);
		
		System.out.print("--> ");
		
		// Carrega estrutura do orcamento
		if (orclst != null) {

			numeroRevisao = orclst.getOrclstNumero().trim() + (orclst.getOrclstRevisao() == null ? "" : orclst.getOrclstRevisao().trim());
			
			orccab = orccabRepository.findByNumeroOrcamento(numeroRevisao);

			if (orccab != null) {
				
				orccab.setPrdOrc(new HashSet<Prdorc>());
				orccab.setOrcMat(new ArrayList<OrcMat>());
				orccab.setOrcItm(new ArrayList<OrcItm>());
				
				// Carrega previamente a lista de produtos deste orcamento
				// isso melhora muito o tempo de acesso, pois evita que seja feitas muitas requisições no banco de dados 
				// para buscar os dados do PrdOrc individualmente
				List<Prdorc> prdorcList = prdorcRepository.listarPrdorc(numeroRevisao);
				
				/*
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				System.out.println(" |                                     ARVORE DE PRODUTOS                                        |");
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				*/
				
				for (Prdorc prdorc : prdorcList) {
					
					System.out.print(".");
					//System.out.println(String.format("--> %s %s\n", prdorc.getProduto(), prdorc.getDescricao()));
					
					prdorc.setPrdest(Prdest(orccab, prdorc));

					orccab.getPrdOrc().add(prdorc);

				}
				
				/*
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				System.out.println(" |                              FIM DA ARVORE DE PRODUTOS                                        |");
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				*/
				
				orccab.setOrcMat(orcMatRepository.findAllByIdNumeroOrcamento(orccab
						.getNumeroOrcamento()));
				
				for (OrcMat mat : orccab.getOrcMat()) {
						
					Optional<Prdorc> exist = orccab.getPrdOrc()
							.stream()
							.filter(i -> i.getProduto().equals(mat.getOrcmatCodigoPai()))
							.findFirst();
					
					if (exist.isPresent()) {
						exist.get().setRef();
						mat.setPrdorc(exist.get());
					} else {
						throw new PrdorcNotFoundException(String.format("Produto não encontrado: %s %s", mat.getOrcmatCodigoPai().trim(), mat.getOrcmatDescricao().trim()));
					}
				}
				
				orccab.setOrcItm(orcitmRepository
						.findAllByNumeroOrcamentoOrderByOrcitmItemAscOrcitmGrupoAscOrcitmSubgrupoAsc(orccab
								.getNumeroOrcamento()));
				
				for (OrcItm itm : orccab.getOrcItm()) {
					
					IntegracaoOrcitm integracaoOrcitm = integracaoOrcitmRepository
							.findByOrcnumAndOrcitmAndGrpcodAndSubgrpcod(itm.getNumeroOrcamento(),
									Integer.parseInt(itm.getOrcitmItem()),
									itm.getOrcitmGrupo(),
									Integer.parseInt(itm.getOrcitmSubgrupo()));
					
					if (integracaoOrcitm != null) {
						itm.setOrctxt(integracaoOrcitm.getOrctxt());
					}

					itm.setOrcdet(orcDetRepository
							.findAllByNumeroOrcamentoAndOrcdetItemAndOrcdetGrupoAndOrcdetSubgrupo(
									itm.getNumeroOrcamento(), itm.getOrcitmItem(),
									itm.getOrcitmGrupo(), itm.getOrcitmSubgrupo()));
					
					for (OrcDet orcdet : itm.getOrcdet()) {

						Optional<Prdorc> exist = orccab.getPrdOrc()
								.stream()
								.filter(i -> i.getProduto().equals(orcdet.getOrcdetCodigoOri()))
								.findFirst();
						
						if (exist.isPresent()) {
							exist.get().setRef();
							orcdet.setPrdorc(exist.get());
						} else {
							throw new PrdorcNotFoundException(String.format("Produto não encontrado: %s %s", orcdet.getOrcdetCodigoOri().trim(), orcdet.getOrcdetAcessorio().trim()));
						}
					}
				}

			} else {
				System.out.println(String.format(" Orcamento não encontrado %s.", numeroRevisao));
				throw new OrccabNotFoundException(String.format("Orçamento não encontrado: %s", numeroRevisao));
			}
			
		} else {
			System.out.println(String.format(" Orcamento não encontrado %s.", numero));
			throw new OrccabNotFoundException(String.format("Orçamento não encontrado: %s", numero));
		}
		
		// Se orcamento foi fechado, compara com os dados exportados
		if (orclst.getOrclstStatus() >= 60 && orclst.getOrclstStatus() < 99) {
			IntegracaoOrccab iorccab = integracaoOrccabRepository.findByOrcnum(numero);
			
			if (iorccab == null) {
				throw new OrccabNotFoundException(String.format("Orçamento não encontrado na tabela INTEGRACAO_ORCCAB: %s, Situacao: %d", numeroRevisao, orclst.getOrclstStatus()));
			}
			
			Assert.assertEquals(orclst.getOrclstNumero(), iorccab.getOrcnum());
			
			if (orccab.getOrcItm().size() > 0) {
				List<IntegracaoOrcitm> integracaoOrcItm = integracaoOrcitmRepository.findByOrcnum(numero);
				
				if (integracaoOrcItm == null) {
					throw new OrcItmNotFoundException(String.format("Items do orçamento não encontrado na tabela INTEGRACAO_ORCITM: %s", numeroRevisao));
				}
				
				List<OrcItm> orcItm = integracaoOrcItm.stream()
						.filter(i -> i.getOrcitm() != 0)
						.map(i -> new OrcItm(i.getOrcnum().trim() + (orclst.getOrclstRevisao() == null ? "" : orclst.getOrclstRevisao().trim()), i.getGrpcod(), i.getSubgrpcod().toString(), i.getOrcitm().toString()))
				        .collect(Collectors.toList());
				
				if (OrcItm.hasDuplicate(orcItm))
					throw new OrcItmHasDuplicateException(String.format("A lista de Items da tabela de INTEGRACAO_ORCITM do Orcamento %s tem items duplicados.", numeroRevisao));
					
				if (OrcItm.hasDuplicate(orccab.getOrcItm()))
					throw new OrcItmHasDuplicateException(String.format("A lista de Items do Orcamento %s tem items duplicados.", numeroRevisao));

				if (orccab.getOrcItm().size() != orcItm.size())
					throw new OrcItmHasDifferenceException(String.format("O tamanho da lista de Items da tabela de INTEGRACAO_ORCITM é diferente do tamanho da lista de Items do Orcamento %s.", numeroRevisao));

				if (orccab.getOrcItm().containsAll(orcItm))
					throw new OrcItmHasDifferenceException(String.format("A lista de Items da tabela de INTEGRACAO_ORCITM é diferente da lista de Items do Orcamento %s.", numeroRevisao));
				
				if (orcItm.containsAll(orccab.getOrcItm()))
					throw new OrcItmHasDifferenceException(String.format("A lista de Items da tabela de INTEGRACAO_ORCITM é diferente da lista de Items do Orcamento %s.", numeroRevisao));
			}

			if (orccab.getOrcMat().size() > 0) {
				List<IntegracaoOrcprd> integracaoOrcprd = integracaoOrcprdRepository.findAllByOrcnum(numero);
				
				if (integracaoOrcprd == null) {
					throw new OrccabNotFoundException(String.format("Materiais do orçamento não encontrado na tabela INTEGRACAO_ORCITM: %s.", numeroRevisao));
				}
				
				/**
				 *  a lista de materiais não contem materia prima, insumos, tinta e tratamento galvanizado, 
				 *  estes só existem na tabela INTEGRACAO_ORCMAT
				 */
				List<OrcMat> orcMat = integracaoOrcprd.stream()
						.filter(i -> i.getOrcitm() != 0)
						.map(p -> new OrcMat(p.getPrdcod(), p.getPrddsc()))
				        .collect(Collectors.toList());
				
				if (OrcMat.hasDuplicate(orcMat))
					throw new OrcMatHasDuplicateException(String.format("A lista de Items da tabela de INTEGRACAO_ORCMAT do Orcamento %s tem materiais duplicados.", numeroRevisao));

				if (OrcMat.hasDuplicate(orccab.getOrcMat()))
					throw new OrcMatHasDuplicateException(String.format("A lista de Material do Orcamento %s tem materiais duplicados.", numeroRevisao));
				
				if (orccab.getOrcMat().size() != orcMat.size())
					throw new OrcMatHasDifferenceException(String.format("O tamanho da lista de Materiais da tabela de INTEGRACAO_ORCITM é diferente do tamanho da lista de Materiais do Orcamento %s.", numeroRevisao));
				
				if (orccab.getOrcMat().containsAll(orcMat))
					throw new OrcMatHasDifferenceException(String.format("A lista de Material da tabela de INTEGRACAO_ORCMAT é diferente da lista de Material do Orcamento %s.", numeroRevisao));
				
				if (orcMat.containsAll(orccab.getOrcMat()))
					throw new OrcMatHasDifferenceException(String.format("A lista de Material da tabela de INTEGRACAO_ORCMAT é diferente da lista de Material do Orcamento %s.", numeroRevisao));
			}
			
		}
		
		System.out.println(String.format(" Orcamento %s carregado.", numero));
		
		return orccab;
		
	}

	private List<Prdest> Prdest(Orccab orccab, Prdorc produtopai) throws Exception {
		List<Prdest> list = null;
		Prdorc prdorc = null;

		Optional<Prdorc> existPai = orccab.getPrdOrc()
				.stream()
				.filter(i -> i.getProduto().trim().equals(produtopai.getProduto().trim()))
				.findFirst();
		
		if (existPai.isPresent()) {
			//System.out.println(String.format(" %s: Encontrou produto pai: %s\n%s", existPai.get().getProduto(), existPai.get().getDescricao(), existPai.get().toString(" ")));
			existPai.get().setRef();
			list = existPai.get().getPrdest();
		} else {
			list = prdestRepository.findAllByIdPrdorccodigopai(produtopai
					.getProduto());

			//System.out.println(String.format(" %s: Carregando estrutura do produto pai: %s, encontrado: %d\n", produtopai.getProduto(), produtopai.getDescricao(), list.size()));

			for (Prdest prdest : list) {
				
				Optional<Prdorc> exist = orccab.getPrdOrc()
						.stream()
						.filter(i -> i.getProduto().equals(prdest.getId()
								.getPrdorccodigofilho()))
						.findFirst();
				
				if (exist.isPresent()) {
					//System.out.println(String.format(" %s: Encontrou produto filho: %s\n", exist.get().getProduto(), exist.get().getDescricao()));
					exist.get().setRef();
					prdorc = exist.get();
				} else {
					System.out.print(".");

					prdorc = prdorcRepository.findByProduto(prdest.getId()
							.getPrdorccodigofilho());
					
					if (prdorc == null) {
						throw new PrdorcNotFoundException(String.format("Produto filho não encontrado: %s %s", prdest.getId()
								.getPrdorccodigopai(), prdest.getId()
								.getPrdorccodigofilho()));
					}
					
					//System.out.println(String.format(" %s: Carregando produto filho: %s %s\n", prdest.getId().getPrdorccodigopai(), prdorc.getProduto(), prdorc.getDescricao()));

					prdorc.setRef();

					orccab.setCount();
					
					prdorc.setPrdest(Prdest(orccab, prdorc));
					
					orccab.getPrdOrc().add(prdorc);

				}

				prdest.setPrdorc(prdorc);
			}
		}

		return list;
	}

}
