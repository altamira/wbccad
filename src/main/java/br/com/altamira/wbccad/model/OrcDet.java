package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


/**
 * The persistent class for the OrcDet database table.
 * 
 */
@Entity
public class OrcDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORCDET_COUNTER")
	private Integer orcdetCounter;

	/*private String controleCad;

	@Column(name="dep_alt")
	private Boolean depAlt;

	@Column(name="dep_compr")
	private Boolean depCompr;

	@Column(name="dep_prof")
	private Boolean depProf;

	@Column(name="DEPARTAMENTO")
	private String departamento;

	@Column(name="IDCJTO")
	private Integer idcjto;*/

	@Column(name="MATERIALEXTRA")
	private Integer materialextra;

	private String numeroOrcamento;

	@Column(name="orcdet_acessorio")
	private String orcdetAcessorio;

	/*@Column(name="ORCDET_AGRUPAMENTO")
	private String orcdetAgrupamento;

	private BigDecimal orcdet_Altura;

	@Column(name="orcdet_area")
	private Double orcdetArea;

	@Column(name="orcdet_chb")
	private String orcdetChb;*/

	@Column(name="orcdet_codigo")
	private String orcdetCodigo;

	@Column(name="ORCDET_CODIGO_ORI")
	private String orcdetCodigoOri;

	/*private BigDecimal orcdet_Comprimento;*/

	@Column(name="orcdet_cor")
	private String orcdetCor;

	/*@Column(name="ORCDET_CORESADC")
	private String orcdetCoresadc;

	@Column(name="orcdet_corte")
	private String orcdetCorte;

	@Column(name="ORCDET_EXP_FLAG_ALT")
	private Boolean orcdetExpFlagAlt;

	@Column(name="ORCDET_EXP_FLAG_CMP")
	private Boolean orcdetExpFlagCmp;

	@Column(name="ORCDET_EXP_FLAG_LRG")
	private Boolean orcdetExpFlagLrg;

	@Column(name="orcdet_fator_ref")
	private BigDecimal orcdetFatorRef;

	@Column(name="orcdet_flag_imprimir")
	private Boolean orcdetFlagImprimir;

	@Column(name="orcdet_flag_suprimir")
	private Boolean orcdetFlagSuprimir;*/

	@Column(name="orcdet_grupo")
	private Integer orcdetGrupo;

	@Column(name="orcdet_identificador")
	private String orcdetIdentificador;

	@Column(name="orcdet_item")
	private String orcdetItem;

	/*@Column(name="ORCDET_KCAL")
	private BigDecimal orcdetKcal;*/

	@Column(name="orcdet_nr_seq")
	private Integer orcdetNrSeq;

	@Column(name="orcdet_nr_seq_crt")
	private String orcdetNrSeqCrt;

	@Column(name="orcdet_obs")
	private String orcdetObs;

	/*@Column(name="orcdet_onde_incluir")
	private String orcdetOndeIncluir;*/

	@Column(name="orcdet_peso")
	private BigDecimal orcdetPeso;

	/*@Column(name="ORCDET_PRC_ALTURA")
	private Integer orcdetPrcAltura;

	@Column(name="ORCDET_PRC_COMPRIMENTO")
	private Integer orcdetPrcComprimento;

	@Column(name="ORCDET_PRC_FORMULA")
	private Integer orcdetPrcFormula;

	@Column(name="ORCDET_PRC_LARGURA")
	private Integer orcdetPrcLargura;

	@Column(name="orcdet_prd_ref")
	private Integer orcdetPrdRef;

	@Column(name="orcdet_preco_lista")
	private BigDecimal orcdetPrecoLista;

	private BigDecimal orcdet_Profundidade;*/

	@Column(name="orcdet_qtde")
	private Double orcdetQtde;

	@Column(name="orcdet_subgrupo")
	private String orcdetSubgrupo;

	/*@Column(name="ORCDETBASALT")
	private BigDecimal orcdetbasalt;

	private String orcdetbase;

	@Column(name="ORCDETBASPRF1")
	private BigDecimal orcdetbasprf1;

	@Column(name="ORCDETBASPRF2")
	private BigDecimal orcdetbasprf2;

	@Column(name="ORCDETBASPRFEST")
	private BigDecimal orcdetbasprfest;

	@Column(name="ORCDETBASQTD")
	private Integer orcdetbasqtd;

	@Column(name="ORCDETCMPMULTI")
	private Integer orcdetcmpmulti;

	private String orcdetcorpesquisa;

	@Column(name="OrcDetPrecoLista")
	private BigDecimal orcDetPrecoLista;

	@Column(name="OrcDetProdutoImagem")
	private String orcDetProdutoImagem;

	@Column(name="ORCDETPROPOSTAGRUPO")
	private Integer orcdetpropostagrupo;

	@Column(name="OrcDetTipoProduto")
	private String orcDetTipoProduto;

	@Column(name="ori_alt")
	private Integer oriAlt;

	@Column(name="ori_compr")
	private Integer oriCompr;

	@Column(name="ori_prof")
	private Integer oriProf;

	private Double quantidadeOriginal;

	@Column(name="SETOR")
	private String setor;

	@Column(name="UTILIZACAO")
	private String utilizacao;

	private String varusr;

	private String vizatras;

	private String vizfinal;

	private String vizinicial;*/

	@OneToOne
	@Transient
	private Prdorc prdorc = null;
	
	public OrcDet() {
	}

	public Integer getOrcdetCounter() {
		return this.orcdetCounter;
	}

	public void setOrcdetCounter(Integer orcdetCounter) {
		this.orcdetCounter = orcdetCounter;
	}

	/*public String getControleCad() {
		return this.controleCad;
	}

	public void setControleCad(String controleCad) {
		this.controleCad = controleCad;
	}

	public Boolean getDepAlt() {
		return this.depAlt;
	}

	public void setDepAlt(Boolean depAlt) {
		this.depAlt = depAlt;
	}

	public Boolean getDepCompr() {
		return this.depCompr;
	}

	public void setDepCompr(Boolean depCompr) {
		this.depCompr = depCompr;
	}

	public Boolean getDepProf() {
		return this.depProf;
	}

	public void setDepProf(Boolean depProf) {
		this.depProf = depProf;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Integer getIdcjto() {
		return this.idcjto;
	}

	public void setIdcjto(Integer idcjto) {
		this.idcjto = idcjto;
	}*/

	public Integer getMaterialextra() {
		return this.materialextra;
	}

	public void setMaterialextra(Integer materialextra) {
		this.materialextra = materialextra;
	}

	public String getNumeroOrcamento() {
		return this.numeroOrcamento;
	}

	public void setNumeroOrcamento(String numeroOrcamento) {
		this.numeroOrcamento = numeroOrcamento;
	}

	public String getOrcdetAcessorio() {
		return this.orcdetAcessorio.trim().toUpperCase();
	}

	public void setOrcdetAcessorio(String orcdetAcessorio) {
		this.orcdetAcessorio = orcdetAcessorio.trim().toUpperCase();
	}

	/*public String getOrcdetAgrupamento() {
		return this.orcdetAgrupamento;
	}

	public void setOrcdetAgrupamento(String orcdetAgrupamento) {
		this.orcdetAgrupamento = orcdetAgrupamento;
	}

	public BigDecimal getOrcdet_Altura() {
		return this.orcdet_Altura;
	}

	public void setOrcdet_Altura(BigDecimal orcdet_Altura) {
		this.orcdet_Altura = orcdet_Altura;
	}

	public Double getOrcdetArea() {
		return this.orcdetArea;
	}

	public void setOrcdetArea(Double orcdetArea) {
		this.orcdetArea = orcdetArea;
	}

	public String getOrcdetChb() {
		return this.orcdetChb;
	}

	public void setOrcdetChb(String orcdetChb) {
		this.orcdetChb = orcdetChb;
	}*/

	public String getOrcdetCodigo() {
		return this.orcdetCodigo.trim().toUpperCase();
	}

	public void setOrcdetCodigo(String orcdetCodigo) {
		this.orcdetCodigo = orcdetCodigo.trim().toUpperCase();
	}

	public String getOrcdetCodigoOri() {
		return this.orcdetCodigoOri.trim().toUpperCase();
	}

	public void setOrcdetCodigoOri(String orcdetCodigoOri) {
		this.orcdetCodigoOri = orcdetCodigoOri.trim().toUpperCase();
	}

	/*public BigDecimal getOrcdet_Comprimento() {
		return this.orcdet_Comprimento;
	}

	public void setOrcdet_Comprimento(BigDecimal orcdet_Comprimento) {
		this.orcdet_Comprimento = orcdet_Comprimento;
	}*/

	public String getOrcdetCor() {
		return this.orcdetCor;
	}

	public void setOrcdetCor(String orcdetCor) {
		this.orcdetCor = orcdetCor;
	}

	/*public String getOrcdetCoresadc() {
		return this.orcdetCoresadc;
	}

	public void setOrcdetCoresadc(String orcdetCoresadc) {
		this.orcdetCoresadc = orcdetCoresadc;
	}

	public String getOrcdetCorte() {
		return this.orcdetCorte;
	}

	public void setOrcdetCorte(String orcdetCorte) {
		this.orcdetCorte = orcdetCorte;
	}

	public Boolean getOrcdetExpFlagAlt() {
		return this.orcdetExpFlagAlt;
	}

	public void setOrcdetExpFlagAlt(Boolean orcdetExpFlagAlt) {
		this.orcdetExpFlagAlt = orcdetExpFlagAlt;
	}

	public Boolean getOrcdetExpFlagCmp() {
		return this.orcdetExpFlagCmp;
	}

	public void setOrcdetExpFlagCmp(Boolean orcdetExpFlagCmp) {
		this.orcdetExpFlagCmp = orcdetExpFlagCmp;
	}

	public Boolean getOrcdetExpFlagLrg() {
		return this.orcdetExpFlagLrg;
	}

	public void setOrcdetExpFlagLrg(Boolean orcdetExpFlagLrg) {
		this.orcdetExpFlagLrg = orcdetExpFlagLrg;
	}

	public BigDecimal getOrcdetFatorRef() {
		return this.orcdetFatorRef;
	}

	public void setOrcdetFatorRef(BigDecimal orcdetFatorRef) {
		this.orcdetFatorRef = orcdetFatorRef;
	}

	public Boolean getOrcdetFlagImprimir() {
		return this.orcdetFlagImprimir;
	}

	public void setOrcdetFlagImprimir(Boolean orcdetFlagImprimir) {
		this.orcdetFlagImprimir = orcdetFlagImprimir;
	}

	public Boolean getOrcdetFlagSuprimir() {
		return this.orcdetFlagSuprimir;
	}

	public void setOrcdetFlagSuprimir(Boolean orcdetFlagSuprimir) {
		this.orcdetFlagSuprimir = orcdetFlagSuprimir;
	}*/

	public Integer getOrcdetGrupo() {
		return this.orcdetGrupo;
	}

	public void setOrcdetGrupo(Integer orcdetGrupo) {
		this.orcdetGrupo = orcdetGrupo;
	}

	public String getOrcdetIdentificador() {
		return this.orcdetIdentificador;
	}

	public void setOrcdetIdentificador(String orcdetIdentificador) {
		this.orcdetIdentificador = orcdetIdentificador;
	}

	public String getOrcdetItem() {
		return this.orcdetItem.trim().toUpperCase();
	}

	public void setOrcdetItem(String orcdetItem) {
		this.orcdetItem = orcdetItem;
	}

	/*public BigDecimal getOrcdetKcal() {
		return this.orcdetKcal;
	}

	public void setOrcdetKcal(BigDecimal orcdetKcal) {
		this.orcdetKcal = orcdetKcal;
	}*/

	public Integer getOrcdetNrSeq() {
		return this.orcdetNrSeq;
	}

	public void setOrcdetNrSeq(Integer orcdetNrSeq) {
		this.orcdetNrSeq = orcdetNrSeq;
	}

	public String getOrcdetNrSeqCrt() {
		return this.orcdetNrSeqCrt;
	}

	public void setOrcdetNrSeqCrt(String orcdetNrSeqCrt) {
		this.orcdetNrSeqCrt = orcdetNrSeqCrt;
	}

	public String getOrcdetObs() {
		return this.orcdetObs;
	}

	public void setOrcdetObs(String orcdetObs) {
		this.orcdetObs = orcdetObs;
	}

	/*public String getOrcdetOndeIncluir() {
		return this.orcdetOndeIncluir;
	}

	public void setOrcdetOndeIncluir(String orcdetOndeIncluir) {
		this.orcdetOndeIncluir = orcdetOndeIncluir;
	}*/

	public BigDecimal getOrcdetPeso() {
		return this.orcdetPeso;
	}

	public void setOrcdetPeso(BigDecimal orcdetPeso) {
		this.orcdetPeso = orcdetPeso;
	}

	/*public Integer getOrcdetPrcAltura() {
		return this.orcdetPrcAltura;
	}

	public void setOrcdetPrcAltura(Integer orcdetPrcAltura) {
		this.orcdetPrcAltura = orcdetPrcAltura;
	}

	public Integer getOrcdetPrcComprimento() {
		return this.orcdetPrcComprimento;
	}

	public void setOrcdetPrcComprimento(Integer orcdetPrcComprimento) {
		this.orcdetPrcComprimento = orcdetPrcComprimento;
	}

	public Integer getOrcdetPrcFormula() {
		return this.orcdetPrcFormula;
	}

	public void setOrcdetPrcFormula(Integer orcdetPrcFormula) {
		this.orcdetPrcFormula = orcdetPrcFormula;
	}

	public Integer getOrcdetPrcLargura() {
		return this.orcdetPrcLargura;
	}

	public void setOrcdetPrcLargura(Integer orcdetPrcLargura) {
		this.orcdetPrcLargura = orcdetPrcLargura;
	}

	public Integer getOrcdetPrdRef() {
		return this.orcdetPrdRef;
	}

	public void setOrcdetPrdRef(Integer orcdetPrdRef) {
		this.orcdetPrdRef = orcdetPrdRef;
	}

	public BigDecimal getOrcdetPrecoLista() {
		return this.orcdetPrecoLista;
	}

	public void setOrcdetPrecoLista(BigDecimal orcdetPrecoLista) {
		this.orcdetPrecoLista = orcdetPrecoLista;
	}

	public BigDecimal getOrcdet_Profundidade() {
		return this.orcdet_Profundidade;
	}

	public void setOrcdet_Profundidade(BigDecimal orcdet_Profundidade) {
		this.orcdet_Profundidade = orcdet_Profundidade;
	}*/

	public Double getOrcdetQtde() {
		return this.orcdetQtde;
	}

	public void setOrcdetQtde(Double orcdetQtde) {
		this.orcdetQtde = orcdetQtde;
	}

	public String getOrcdetSubgrupo() {
		return this.orcdetSubgrupo;
	}

	public void setOrcdetSubgrupo(String orcdetSubgrupo) {
		this.orcdetSubgrupo = orcdetSubgrupo;
	}

	/*public BigDecimal getOrcdetbasalt() {
		return this.orcdetbasalt;
	}

	public void setOrcdetbasalt(BigDecimal orcdetbasalt) {
		this.orcdetbasalt = orcdetbasalt;
	}

	public String getOrcdetbase() {
		return this.orcdetbase;
	}

	public void setOrcdetbase(String orcdetbase) {
		this.orcdetbase = orcdetbase;
	}

	public BigDecimal getOrcdetbasprf1() {
		return this.orcdetbasprf1;
	}

	public void setOrcdetbasprf1(BigDecimal orcdetbasprf1) {
		this.orcdetbasprf1 = orcdetbasprf1;
	}

	public BigDecimal getOrcdetbasprf2() {
		return this.orcdetbasprf2;
	}

	public void setOrcdetbasprf2(BigDecimal orcdetbasprf2) {
		this.orcdetbasprf2 = orcdetbasprf2;
	}

	public BigDecimal getOrcdetbasprfest() {
		return this.orcdetbasprfest;
	}

	public void setOrcdetbasprfest(BigDecimal orcdetbasprfest) {
		this.orcdetbasprfest = orcdetbasprfest;
	}

	public Integer getOrcdetbasqtd() {
		return this.orcdetbasqtd;
	}

	public void setOrcdetbasqtd(Integer orcdetbasqtd) {
		this.orcdetbasqtd = orcdetbasqtd;
	}

	public Integer getOrcdetcmpmulti() {
		return this.orcdetcmpmulti;
	}

	public void setOrcdetcmpmulti(Integer orcdetcmpmulti) {
		this.orcdetcmpmulti = orcdetcmpmulti;
	}

	public String getOrcdetcorpesquisa() {
		return this.orcdetcorpesquisa;
	}

	public void setOrcdetcorpesquisa(String orcdetcorpesquisa) {
		this.orcdetcorpesquisa = orcdetcorpesquisa;
	}

	public BigDecimal getOrcDetPrecoLista() {
		return this.orcDetPrecoLista;
	}

	public void setOrcDetPrecoLista(BigDecimal orcDetPrecoLista) {
		this.orcDetPrecoLista = orcDetPrecoLista;
	}

	public String getOrcDetProdutoImagem() {
		return this.orcDetProdutoImagem;
	}

	public void setOrcDetProdutoImagem(String orcDetProdutoImagem) {
		this.orcDetProdutoImagem = orcDetProdutoImagem;
	}

	public Integer getOrcdetpropostagrupo() {
		return this.orcdetpropostagrupo;
	}

	public void setOrcdetpropostagrupo(Integer orcdetpropostagrupo) {
		this.orcdetpropostagrupo = orcdetpropostagrupo;
	}

	public String getOrcDetTipoProduto() {
		return this.orcDetTipoProduto;
	}

	public void setOrcDetTipoProduto(String orcDetTipoProduto) {
		this.orcDetTipoProduto = orcDetTipoProduto;
	}

	public Integer getOriAlt() {
		return this.oriAlt;
	}

	public void setOriAlt(Integer oriAlt) {
		this.oriAlt = oriAlt;
	}

	public Integer getOriCompr() {
		return this.oriCompr;
	}

	public void setOriCompr(Integer oriCompr) {
		this.oriCompr = oriCompr;
	}

	public Integer getOriProf() {
		return this.oriProf;
	}

	public void setOriProf(Integer oriProf) {
		this.oriProf = oriProf;
	}

	public Double getQuantidadeOriginal() {
		return this.quantidadeOriginal;
	}

	public void setQuantidadeOriginal(Double quantidadeOriginal) {
		this.quantidadeOriginal = quantidadeOriginal;
	}

	public String getSetor() {
		return this.setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getUtilizacao() {
		return this.utilizacao;
	}

	public void setUtilizacao(String utilizacao) {
		this.utilizacao = utilizacao;
	}

	public String getVarusr() {
		return this.varusr;
	}

	public void setVarusr(String varusr) {
		this.varusr = varusr;
	}

	public String getVizatras() {
		return this.vizatras;
	}

	public void setVizatras(String vizatras) {
		this.vizatras = vizatras;
	}

	public String getVizfinal() {
		return this.vizfinal;
	}

	public void setVizfinal(String vizfinal) {
		this.vizfinal = vizfinal;
	}

	public String getVizinicial() {
		return this.vizinicial;
	}

	public void setVizinicial(String vizinicial) {
		this.vizinicial = vizinicial;
	}*/

	public Prdorc getPrdorc() {
		return prdorc;
	}

	public void setPrdorc(Prdorc prdorc) {
		this.prdorc = prdorc;
	}

	public String toString(String margin) {
		StringBuffer buf = new StringBuffer();

		margin = " " + margin;
		
		buf.append(String.format("%sORCDET: %s %s %s\n", margin, this.getOrcdetCodigo(), this.getOrcdetCodigoOri(), this.getOrcdetAcessorio().toString()));
		
		buf.append(this.prdorc.toString(margin));
		
		return buf.toString();
	}
}