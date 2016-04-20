package br.com.altamira.wbccad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import br.com.altamira.wbccad.model.IntegracaoOrccab;
import br.com.altamira.wbccad.model.IntegracaoOrcitm;
import br.com.altamira.wbccad.model.IntegracaoOrcprd;
import br.com.altamira.wbccad.model.IntegracaoOrcprdarv;
import br.com.altamira.wbccad.model.OrcItm;
import br.com.altamira.wbccad.model.OrcMat;
import br.com.altamira.wbccad.model.Orccab;
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
import br.com.altamira.wbccad.repository.PrdestRepository;
import br.com.altamira.wbccad.repository.PrdorcRepository;

@Controller
public class OrcMatController {

	@Autowired
	private IntegracaoOrccabRepository integracaoOrccabRepository;

	@Autowired
	private IntegracaoOrcitmRepository integracaoOrcitmRepository;

	@Autowired
	private IntegracaoOrcprdRepository integracaoOrcprdRepository;

	@Autowired
	private IntegracaoOrcprdarvRepository integracaoOrcprdarvRepository;

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

	@JmsListener(destination = "WBCCAD-INTEGRACAO-ORCCAB-VISUALIZAR")
	@SendTo("WBCCAD-INTEGRACAO-ORCCAB-IMPRIMIR")
	public IntegracaoOrccab integracaoOrccab(String orcamento) {
		IntegracaoOrccab orccab = integracaoOrccabRepository
				.findByOrcnum(orcamento);
		orccab.setOrcitm(integracaoOrcitm(orccab));
		return orccab;
	}

	public List<IntegracaoOrcitm> integracaoOrcitm(IntegracaoOrccab orccab) {
		List<IntegracaoOrcitm> itm = integracaoOrcitmRepository
				.findByOrcnum(orccab.getOrcnum());
		for (IntegracaoOrcitm i : itm) {
			i.setOrcprd(integracaoOrcprd(i));
		}
		return itm;
	}

	public List<IntegracaoOrcprd> integracaoOrcprd(IntegracaoOrcitm itm) {
		List<IntegracaoOrcprd> list = integracaoOrcprdRepository
				.findByOrcnumAndOrcitm(itm.getOrcnum(), itm.getOrcitm());
		/*
		 * for (IntegracaoOrcprd orcprd : list) {
		 * orcprd.setOrcprdarv(integracaoOrcprdarv(orcprd)); }
		 */
		return list;
	}

	public List<IntegracaoOrcprdarv> integracaoOrcprdarv(IntegracaoOrcprd orcprd) {
		List<IntegracaoOrcprdarv> list = integracaoOrcprdarvRepository
				.findByOrcnum(orcprd.getOrcnum());

		for (IntegracaoOrcprdarv orcprdarv : list) {
			orcprdarv.setOrcprdarv(integracaoOrcprdarvFilho(orcprdarv, 1));
		}

		return list;
	}

	public List<IntegracaoOrcprdarv> integracaoOrcprdarvFilho(
			IntegracaoOrcprdarv orcprdarvpai, Integer nivel) {
		List<IntegracaoOrcprdarv> list = integracaoOrcprdarvRepository
				.findByOrcnum(orcprdarvpai.getOrcnum());
		for (IntegracaoOrcprdarv orcprdarv : list) {
			orcprdarv.setOrcprdarv(integracaoOrcprdarvFilho(orcprdarv,
					nivel + 1));
		}
		return list;
	}

	@JmsListener(destination = "WBCCAD-INTEGRACAO-ORCCAB-IMPRIMIR")
	public void printIntegracao(IntegracaoOrccab orccab) {
		System.out
				.println(String.format("\n Processing %s", orccab.getOrcnum()));
		for (IntegracaoOrcitm itm : orccab.getOrcitm()) {
			System.out.println(String.format(" + [%s] [%s] [%s] %s",
					itm.getOrcitm(), itm.getGrpcod(), itm.getSubgrpcod(),
					itm.getOrctxt()));
			for (IntegracaoOrcprd orcprd : itm.getOrcprd()) {
				System.out.println(String.format(
						"   + %s %s [%s] [%.0f pc] [%.5f kg]",
						orcprd.getPrdcod(), orcprd.getPrddsc(),
						orcprd.getCorcod(), orcprd.getOrcqtd(),
						orcprd.getOrcpes()));
			}
		}

	}

	@JmsListener(destination = "WBCCAD-ORCAMENTO-VISUALIZAR")
	@SendTo("WBCCAD-ORCAMENTO-IMPRIMIR")
	public Orccab orccab(String orcamento) {
		System.out.println(String.format("\n--> Receive message %s...",
				orcamento));

		Orccab orccab = orccabRepository.findByNumeroOrcamento(orcamento);
		if (orccab != null) {
			System.out.println(String.format("\n--> Start processing %s %s",
					orccab.getNumeroOrcamento(),
					orccab.getOrccab_cliente_Nome()));
			orccab.setOrcMat(orcMatRepository.findAllByIdNumeroOrcamento(orccab
					.getNumeroOrcamento()));
			for (OrcMat mat : orccab.getOrcMat()) {
				System.out.println(String.format(
						"----> Processing ORCMAT %s %s",
						mat.getOrcmatCodigoPai(), mat.getOrcmatDescricao()));
				Prdorc prdorc = prdorcRepository.findByProduto(mat
						.getOrcmatCodigoPai());
				prdorc.setPrdest(Prdest(prdorc));
				mat.setPrdorc(prdorc);
			}
			orccab.setOrcItm(orcitmRepository
					.findAllByNumeroOrcamentoOrderByOrcitmItemAscOrcitmGrupoAscOrcitmSubgrupoAsc(orccab
							.getNumeroOrcamento()));
			for (OrcItm itm : orccab.getOrcItm()) {
				System.out.println(String.format(
						"----> Processing ORCITM [%s] [%s] [%s]",
						itm.getOrcitmItem(), itm.getOrcitmGrupo(),
						itm.getOrcitmSubgrupo()));
				IntegracaoOrcitm integracaoOrcitm = integracaoOrcitmRepository
						.findByOrcnumAndOrcitmAndGrpcodAndSubgrpcod(orcamento,
								Integer.parseInt(itm.getOrcitmItem()),
								itm.getOrcitmGrupo(),
								Integer.parseInt(itm.getOrcitmSubgrupo()));
				if (integracaoOrcitm != null) {
					itm.setOrctxt(integracaoOrcitm.getOrctxt());
				}
				/*itm.setOrcdet(orcDetRepository
						.findAllByNumeroOrcamentoAndOrcdetItemAndOrcdetGrupoAndOrcdetSubgrupo(
								itm.getNumeroOrcamento(), itm.getOrcitmItem(),
								itm.getOrcitmGrupo(), itm.getOrcitmSubgrupo()));
				for (OrcDet orcdet : itm.getOrcdet()) {
					// System.out.println(String.format("------> Processing ORCDET %s",
					// orcdet.getOrcdetCodigoOri()));
					Prdorc prdorc = prdorcRepository.findByProduto(orcdet
							.getOrcdetCodigoOri());
					prdorc.setPrdest(Prdest(prdorc));
					orcdet.setPrdorc(prdorc);
				}*/
			}
		}
		return orccab;
	}

	@JmsListener(destination = "WBCCAD-PRODUTO-EXPORTAR")
	// @SendTo("wbccad-prdorc-dump")
	@SendTo("MATERIAL-IMPORTAR")
	public Prdorc prdorc(String codigo) {
		System.out.println(String.format("\n EXPORTANDO ESTRUTURA DO PRODUTO [%s] PARA FILA MATERIAL-IMPORTAR", codigo));

		Prdorc prdorc = prdorcRepository.findByProduto(codigo);
		if (prdorc != null) {
			prdorc.setPrdest(Prdest(prdorc));
		}
		return prdorc;
	}

	private List<Prdest> Prdest(Prdorc produtopai) {
		List<Prdest> list = new ArrayList<Prdest>();

		list = prdestRepository.findAllByIdPrdorccodigopai(produtopai
				.getProduto());

		for (Prdest prdest : list) {
			Prdorc produtofilho = prdorcRepository.findByProduto(prdest.getId()
					.getPrdorccodigofilho());
			produtofilho.setPrdest(Prdest(produtofilho));
			prdest.setPrdorc(produtofilho);
		}
		return list;
	}

	@JmsListener(destination = "WBCCAD-ORCAMENTO-IMPRIMIR")
	public void receiveList(Orccab orccab) {

		System.out
				.println("------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%s %s", orccab.getNumeroOrcamento(),
				orccab.getOrccab_cliente_Nome()));
		System.out
				.println("------------------------------------------------------------------------------------------------");
		System.out.println(" Lista de Materiais");
		System.out
				.println("------------------------------------------------------------------------------------------------");
		for (OrcMat mat : orccab.getOrcMat()) {
			System.out.println(String.format(
					" + %s %s [%s] [%s] [%.2f pc] [%.3f kg]",
					mat.getOrcmatCodigo(), mat.getOrcmatDescricao(),
					mat.getOrcmatCor(), mat.getOrcMatCorPesquisa(),
					mat.getOrcmatQtde(), mat.getOrcmatPeso()));
			printPrdorc(mat.getPrdorc());
		}

		int c = 0;
		System.out
				.println("------------------------------------------------------------------------------------------------");
		System.out.println(" Itens do orcamento");
		System.out
				.println("------------------------------------------------------------------------------------------------");
		for (OrcItm itm : orccab.getOrcItm()) {
			System.out.println(String.format(" [%d] [%s] [%s] [%s] %s", ++c,
					itm.getOrcitmItem(), itm.getOrcitmGrupo(),
					itm.getOrcitmSubgrupo(), itm.getOrctxt()));
			printOrcDet(itm, "  +");
		}

	}

	@JmsListener(destination = "WBCCAD-PRODUTO-IMPRIMIR-ESTRUTURA")
	public void prdorcPrint(String codigo) {
		System.out.println(String.format("\n PRODUTO: %s\n", codigo));

		Prdorc prdorc = prdorcRepository.findByProduto(codigo);
		if (prdorc != null) {
			prdorc.setPrdest(Prdest(prdorc));
		}

		printPrdorc(prdorc);
	}

	private void printPrdorc(Prdorc produtopai) {

		if (produtopai == null) {
			System.out.println(String.format("Produto nao encontrado"));
			return;
		}

		System.out.println(String.format("%s %s %s [%s]\n", "  +",
				produtopai.getProduto(), produtopai.getDescricao(),
				produtopai.getCor_padrao()));
		for (Prdest prdest : produtopai.getPrdest()) {
			printPrdest(prdest, "  +" + "--");
		}
	}

	private void printPrdest(Prdest prdest, String tab) {
		System.out.println(String.format("%s %s %s [%s] [%s pc] {%s}\n", tab,
				prdest.getPrdorc().getProduto(), prdest.getPrdorc()
						.getDescricao(), prdest.getPrdorc().getCor_padrao(),
				prdest.getPrdestQtde(), prdest.getPrdestPeso()));
		for (Prdest p : prdest.getPrdorc().getPrdest()) {
			printPrdest(p, tab + "--");
		}
	}

	private void printOrcDet(OrcItm itm, String tab) {
		/*for (OrcDet orcdet : itm.getOrcdet()) {
			System.out.println(String.format(
					"%s %s %s [%s] [%.2f pc] [%.3f kg]\n", tab,
					orcdet.getOrcdetCodigo(),
					orcdet.getPrdorc().getDescricao(), orcdet.getOrcdetCor(),
					orcdet.getOrcdetQtde(), orcdet.getOrcdetPeso()));
			printPrdorc(orcdet.getPrdorc());
		}*/
	}

}
