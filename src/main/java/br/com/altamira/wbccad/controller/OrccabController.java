package br.com.altamira.wbccad.controller;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.altamira.wbccad.exception.OrcItmHasDifferenceException;
import br.com.altamira.wbccad.exception.OrcItmHasDuplicateException;
import br.com.altamira.wbccad.exception.OrcItmNotFoundException;
import br.com.altamira.wbccad.exception.OrcMatHasDifferenceException;
import br.com.altamira.wbccad.exception.OrcMatHasDuplicateException;
import br.com.altamira.wbccad.exception.OrccabNotFoundException;
import br.com.altamira.wbccad.exception.PrdorcNotFoundException;
import br.com.altamira.wbccad.model.IntegracaoOrccab;
import br.com.altamira.wbccad.model.IntegracaoOrcitm;
import br.com.altamira.wbccad.model.IntegracaoOrcprd;
import br.com.altamira.wbccad.model.IntegracaoOrcprdarv;
import br.com.altamira.wbccad.model.OrcDet;
import br.com.altamira.wbccad.model.OrcItm;
import br.com.altamira.wbccad.model.OrcMat;
import br.com.altamira.wbccad.model.Orccab;
import br.com.altamira.wbccad.model.Orclst;
import br.com.altamira.wbccad.model.Prdest;
import br.com.altamira.wbccad.model.Prdorc;
import br.com.altamira.wbccad.repository.IntegracaoOrccabRepository;
import br.com.altamira.wbccad.repository.IntegracaoOrcitmRepository;
import br.com.altamira.wbccad.repository.IntegracaoOrcprdRepository;
import br.com.altamira.wbccad.repository.IntegracaoOrcprdarvRepository;
import br.com.altamira.wbccad.repository.OrcDetRepository;
import br.com.altamira.wbccad.repository.OrcMatRepository;
import br.com.altamira.wbccad.repository.OrccabRepository;
import br.com.altamira.wbccad.repository.OrcitmRepository;
import br.com.altamira.wbccad.repository.OrclstRepository;
import br.com.altamira.wbccad.repository.PrdestRepository;
import br.com.altamira.wbccad.repository.PrdorcRepository;

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
	
	@Autowired
	private IntegracaoOrcprdarvRepository integracaoOrcprdarvRepository;
	
	@JmsListener(destination = "/wbccad/orccab/v1/request")
	@SendTo("/wbccad/orccab/v1/response")
	public Orccab export(String numero) throws Exception {
		Orccab orccab = null;

		numero = numero.trim().toUpperCase();
		String numeroRevisao = numero;

		System.out.println(String.format("\n\n--> Solicitado orcamento %s.",
				numero));
		
		// ORCLST tem a ultima revisao do orcamento
		Orclst orclst = orclstRepository.findByOrclstNumero(numero);
		
		System.out.print("--> ");
		
		// Carrega estrutura do orcamento
		if (orclst != null) {

			numeroRevisao = orclst.getOrclstNumero() + orclst.getOrclstRevisao();
			
			orccab = orccabRepository.findByNumeroOrcamento(numeroRevisao);

			if (orccab != null) {
				
				orccab.setOrclst(orclst);

				/*
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				System.out.println(" |                                     ARVORE DE PRODUTOS                                        |");
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				*/
				
				// Carrega previamente a lista de produtos deste orcamento
				// isso melhora muito o tempo de acesso, pois evita que seja feitas muitas requisições no banco de dados 
				// para buscar os dados do PrdOrc individualmente
				List<Prdorc> prdorc = prdorcRepository.findAllPrdorcByOrccabNumeroOrcamento(numeroRevisao);
				
				if (prdorc.size() == 0) { 

					// Pode estar sem produtos quando esta em elaboração ou foi cancelado antes de ser iniado o projeto do orçamento
					if (orclst.getOrclstStatus() >= 40 && orclst.getOrclstStatus() < 99) {
						throw new PrdorcNotFoundException(String.format("%s: Orçamento incompleto, Situação %d. Nenhum produto encontrado no orçamento.", numeroRevisao, orclst.getOrclstStatus()));
					}
					
					// Se não encontrou nenhum produto pode ser por que não existe nenhum registro na tabela ORCDET que faz join com a tabela PRDORC
					/*if (orcDetRepository.countByNumeroOrcamento(numeroRevisao) == 0) 
						throw new OrcDetNotFoundException(String.format("%s: Nenhum registro encontrado na tabela ORCDET. A situação do orçamento é %d.", numeroRevisao, orclst.getOrclstStatus()));*/
					
					// Realmente nao existe o produto na tabela PRDORC
					//throw new PrdorcNotFoundException(String.format("%s: Nenhum registro encontrado na tabela PRDORC. A situação do orçamento é %d.", numeroRevisao, orclst.getOrclstStatus()));
				}
				
				orccab.setPrdOrc(new HashSet<Prdorc>());
				
				// Carrega Arvore dos Produtos (Bill of Material) deste Orcamento
				for (Prdorc prd : prdorc) {
					
					System.out.print(".");
					//System.out.println(String.format("--> %s %s\n", prdorc.getProduto(), prdorc.getDescricao()));
					
					prd.setPrdest(Prdest(orccab, prd)); // --> recursivo

					orccab.getPrdOrc().add(prd);

				}
				
				/*
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				System.out.println(" |                              FIM DA ARVORE DE PRODUTOS                                        |");
				System.out.println(" +-----------------------------------------------------------------------------------------------+");
				*/
				
				// Carrega lista geral de Materiais do Orcamento (independente do Item)
				orccab.setOrcMat(orcMatRepository.findAllByNumeroOrcamento(orccab.getNumeroOrcamento()));
				
				for (OrcMat orcmat : orccab.getOrcMat()) {
						
					Optional<Prdorc> exist = orccab.getPrdOrc()
							.stream()
							.filter(i -> i.getProduto().equals(orcmat.getOrcmatCodigoPai()))
							.findFirst();
					
					if (exist.isPresent()) {
						exist.get().setRef();
						orcmat.setPrdorc(exist.get());
					} else {
						throw new PrdorcNotFoundException(String.format("%s: OrcMat, Produto não encontrado: %s %s", orccab.getNumeroOrcamento(), orcmat.getOrcmatCodigoPai(), orcmat.getOrcmatDescricao()));
					}
				}
				
				// Carrega lista de Items
				orccab.setOrcItm(orcitmRepository.findAllByNumeroOrcamento(orccab.getNumeroOrcamento()));
				
				for (OrcItm itm : orccab.getOrcItm()) {

					// pega a descricao do item caso tenha sido exportada para as tabelas de integracao
					if (orclst.getOrclstStatus() >= 60) {
						IntegracaoOrcitm integracaoOrcitm = integracaoOrcitmRepository
								.findByOrcnumAndOrcitmAndGrpcodAndSubgrpcod(itm.getNumeroOrcamento(),
										Integer.parseInt(itm.getOrcitmItem()),
										itm.getOrcitmGrupo(),
										Integer.parseInt(itm.getOrcitmSubgrupo()));
						
						if (integracaoOrcitm != null) {
							itm.setOrctxt(integracaoOrcitm.getOrctxt());
						}
					}
					
					// Carrega os detalhes do item de um unica vez (independente do material)
					itm.setOrcdet(orcDetRepository.findAllByNumeroOrcamentoAndOrcdetItem(orccab.getNumeroOrcamento(), itm.getOrcitmItem()));
					
					for (OrcDet orcdet : itm.getOrcdet()) {

						Optional<Prdorc> exist = orccab.getPrdOrc()
								.stream()
								.filter(i -> i.getProduto().equals(orcdet.getOrcdetCodigoOri()))
								.findFirst();
						
						if (exist.isPresent()) {
							exist.get().setRef();
							orcdet.setPrdorc(exist.get());
						} else {
							throw new PrdorcNotFoundException(String.format("%s: OrcDet, Produto não encontrado: %s %s", orccab.getNumeroOrcamento(), orcdet.getOrcdetCodigoOri(), orcdet.getOrcdetAcessorio()));
						}
					}

					// Carrega os materiais deste item
					itm.setOrcMat(orcMatRepository.findAllByNumeroOrcamentoAndOrcdetItem(orccab.getNumeroOrcamento(), itm.getOrcitmItem()));
					
					for (OrcMat orcmat : itm.getOrcMat()) {
						
						Optional<Prdorc> exist = orccab.getPrdOrc()
								.stream()
								.filter(i -> i.getProduto().equals(orcmat.getOrcmatCodigoPai()))
								.findFirst();
						
						if (exist.isPresent()) {
							exist.get().setRef();
							orcmat.setPrdorc(exist.get());
						} else {
							throw new PrdorcNotFoundException(String.format("%s: OrcMat, Produto não encontrado: %s %s", orccab.getNumeroOrcamento(), orcmat.getOrcmatCodigoPai(), orcmat.getOrcmatDescricao()));
						}

						orcmat.setOrcDet(
								itm.getOrcdet()
									.stream()
									.filter(i -> i.getOrcdetCodigo().equals(orcmat.getOrcmatCodigo()))
									.collect(Collectors.toList())
								);
						 
					}
					
				}

			} else {
				System.out.println(String.format("%s:, Situação: %d, Orcamento não encontrado na tabela ORCCAB.", numeroRevisao, orclst.getOrclstStatus()));
				throw new OrccabNotFoundException(String.format("%s:, Situação: %d, Orçamento não encontrado na tabela ORCCAB.", numeroRevisao, orclst.getOrclstStatus()));
			}
			
		} else {
			System.out.println(String.format("%s: Orcamento não encontrado na tabela ORCLST.", numero));
			throw new OrccabNotFoundException(String.format("%s: Orçamento não encontrado na tabela ORCLST.", numero));
		}
		
		// Verifica integridade das tabelas internas
		
		// Se orcamento foi fechado, compara com os dados exportados
		if (orclst.getOrclstStatus() >= 60 && orclst.getOrclstStatus() < 99) {
			IntegracaoOrccab iorccab = integracaoOrccabRepository.findByOrcnum(numero);
			
			if (iorccab == null) {
				throw new OrccabNotFoundException(String.format("%s: Orçamento não encontrado na tabela INTEGRACAO_ORCCAB, Situacao: %d", numeroRevisao, orclst.getOrclstStatus()));
			}
			
			if (orccab.getOrcItm().size() > 0) {
				List<IntegracaoOrcitm> integracaoOrcItm = integracaoOrcitmRepository.findByOrcnum(numero);
				
				if (integracaoOrcItm == null) {
					throw new OrcItmNotFoundException(String.format("%s: Items do orçamento não encontrado na tabela INTEGRACAO_ORCITM.", numeroRevisao));
				}
				
				List<OrcItm> orcItm = integracaoOrcItm
						.stream()
						.filter(i -> i.getOrcitm() != 0)
						.map(i -> new OrcItm(i.getOrcnum() + (orclst.getOrclstRevisao() == null ? "" : orclst.getOrclstRevisao()), i.getGrpcod(), i.getSubgrpcod().toString(), i.getOrcitm().toString()))
				        .collect(Collectors.toList());
				
				if (OrcItm.hasDuplicate(orcItm))
					throw new OrcItmHasDuplicateException(String.format("%s: A lista de Items da tabela de INTEGRACAO_ORCITM tem items duplicados.", numeroRevisao));
					
				if (OrcItm.hasDuplicate(orccab.getOrcItm()))
					throw new OrcItmHasDuplicateException(String.format("%s: A lista de Items do Orcamento tem duplicados.", numeroRevisao));

				if (orccab.getOrcItm().size() != orcItm.size())
					throw new OrcItmHasDifferenceException(String.format("%s: O tamanho da lista de Items da tabela de INTEGRACAO_ORCITM é diferente do tamanho da lista de Items do Orcamento.", numeroRevisao));

				if (!orccab.getOrcItm().containsAll(orcItm))
					throw new OrcItmHasDifferenceException(String.format("%s: A lista de Items da tabela de INTEGRACAO_ORCITM é diferente da lista de Items do Orcamento.", numeroRevisao));
				
				if (!orcItm.containsAll(orccab.getOrcItm()))
					throw new OrcItmHasDifferenceException(String.format("%s: A lista de Items do Orcamento é diferente da lista de Items da tabela INTEGRACAO_ORCITM.", numeroRevisao));
			}

			if (orccab.getOrcMat().size() > 0) {
				List<IntegracaoOrcprd> integracaoOrcprd = integracaoOrcprdRepository.findAllByOrcnum(numero);
				
				if (integracaoOrcprd == null) {
					throw new OrccabNotFoundException(String.format("%s: Materiais do orçamento não encontrado na tabela INTEGRACAO_ORCITM.", numeroRevisao));
				}
				
				/**
				 *  a lista de materiais não contem materia prima, insumos, tinta e tratamento galvanizado, 
				 *  estes só existem na tabela INTEGRACAO_ORCMAT
				 */
				List<OrcMat> orcMat = integracaoOrcprd.stream()
						.filter(i -> i.getOrcitm() != 0)
						//.map(p -> new OrcMat(p.getPrdcod(), p.getPrddsc()))
						.map(p -> new OrcMat(p.getPrdcod(), p.getPrddsc(), new BigDecimal(p.getOrcpes()), new BigDecimal(p.getOrctot() / p.getOrcqtd()), p.getOrcqtd(), p.getCorcod(), p.getGrpcod(), p.getSubgrpcod().toString()))
				        .collect(Collectors.toList());
				
				if (OrcMat.hasDuplicate(orcMat))
					throw new OrcMatHasDuplicateException(String.format("%s: A lista de Materias da tabela de INTEGRACAO_ORCPRD tem materiais duplicados.", numeroRevisao));

				if (OrcMat.hasDuplicate(orccab.getOrcMat()))
					throw new OrcMatHasDuplicateException(String.format("%s: A lista de Material do Orcamento tem materiais duplicados.", numeroRevisao));
				
				if (orccab.getOrcMat().size() != orcMat.size())
					throw new OrcMatHasDifferenceException(String.format("%s: O tamanho da lista de Materiais da tabela de INTEGRACAO_ORCPRD é diferente do tamanho da lista de Materiais do Orcamento.", numeroRevisao));
				
				if (!orccab.getOrcMat().containsAll(orcMat))
					throw new OrcMatHasDifferenceException(String.format("%s: A lista de Material da tabela de INTEGRACAO_ORCPRD é diferente da lista de Material do Orcamento.", numeroRevisao));
				
				if (!orcMat.containsAll(orccab.getOrcMat()))
					throw new OrcMatHasDifferenceException(String.format("%s: A lista de Material do Orcamento e diferente da lista de Material da tabela de INTEGRACAO_ORCPRD.", numeroRevisao));
			}
			
			if (orccab.getPrdOrc().size() > 0) {
				List<IntegracaoOrcprdarv> integracaoOrcprdarv = integracaoOrcprdarvRepository.findAllByOrcnumOrderByIdIntegracaoAsc(numero);
				
				if (integracaoOrcprdarv == null) {
					throw new OrccabNotFoundException(String.format("%s: Arvore de produtos do orçamento não encontrado na tabela INTEGRACAO_ORCPRDARV.", numeroRevisao));
				}
				
				Iterator<IntegracaoOrcprdarv> it = integracaoOrcprdarv.iterator();
				
				ComparePrdarv(numeroRevisao, 1, it, orccab.getPrdOrc().iterator());
				
			}
			
		}
		
		System.out.println(String.format("%s: Orcamento carregado.", numero));
		
		return orccab;
		
	}

	private void ComparePrdarv(String orcnum, int nivel, Iterator<IntegracaoOrcprdarv> itIntegracaoOrcprdarv, Iterator<Prdorc> itPrdOrc) throws PrdorcNotFoundException {
		while (itPrdOrc.hasNext() && itPrdOrc.hasNext()) {
			IntegracaoOrcprdarv integracaoOrcprdarv = itIntegracaoOrcprdarv.next();
			Prdorc prdorc = itPrdOrc.next();

			if (integracaoOrcprdarv.getOrcprdarvNivel() > nivel) {
				//ComparePrdarv(orcnum, nivel + 1, itIntegracaoOrcprdarv, prdorc.getPrdest().iterator());
			} else {
				Prdorc integracaoprdorc = new Prdorc(integracaoOrcprdarv.getPrdcod(), integracaoOrcprdarv.getPrddsc());
				
				if (!prdorc.equals(integracaoprdorc)) 
					throw new PrdorcNotFoundException(String.format("%s: INTEGRACAO_ORCPRDARV, arvore de produtos é diferente.", orcnum));
			}
		}
	}
	
	private List<Prdest> Prdest(Orccab orccab, Prdorc produtopai) throws Exception {
		List<Prdest> list = null;
		Prdorc prdorc = null;

		Optional<Prdorc> existPai = orccab.getPrdOrc()
				.stream()
				.filter(i -> i.getProduto().equals(produtopai.getProduto()))
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
						throw new PrdorcNotFoundException(String.format("%s: Produto filho não encontrado: Codigo PAI: %s, Codigo FILHO: %s", 
								orccab.getNumeroOrcamento(), 
								prdest.getId().getPrdorccodigopai(), 
								prdest.getId().getPrdorccodigofilho()));
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
