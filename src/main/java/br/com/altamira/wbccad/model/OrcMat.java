package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


/**
 * The persistent class for the OrcMat database table.
 * 
 */
@Entity
public class OrcMat implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrcMatPK id;

	@Column(name="COFINSFATOR")
	private BigDecimal cofinsfator;

	@Column(name="COMISSAO_FATOR")
	private BigDecimal comissaoFator;

	@Column(name="CUSTO_CALCULO")
	private BigDecimal custoCalculo;

	@Column(name="ENCARGOS_VALOR")
	private BigDecimal encargosValor;

	@Column(name="FRETE_CALCULO")
	private BigDecimal freteCalculo;

	@Column(name="FreteValor")
	private BigDecimal freteValor;

	@Column(name="IcmsBase")
	private BigDecimal icmsBase;

	@Column(name="IcmsFator")
	private BigDecimal icmsFator;

	@Column(name="IcmsRedutor")
	private BigDecimal icmsRedutor;

	@Column(name="IcmsValor")
	private BigDecimal icmsValor;

	@Column(name="INDICE_COMPRA")
	private BigDecimal indiceCompra;

	@Column(name="INDICE_FATURAMENTO")
	private BigDecimal indiceFaturamento;

	@Column(name="IPI_NAO_INCLUSO")
	private BigDecimal ipiNaoIncluso;

	@Column(name="IpiBase")
	private BigDecimal ipiBase;

	@Column(name="IpiFator")
	private BigDecimal ipiFator;

	@Column(name="IpiValor")
	private BigDecimal ipiValor;

	@Column(name="MontagemValor")
	private BigDecimal montagemValor;

	@Column(name="NATUREZA")
	private String natureza;

	@Column(name="orcmat_codigo")
	private String orcmatCodigo;

	@Column(name="orcmat_codigo_pai")
	private String orcmatCodigoPai;

	@Column(name="orcmat_cor")
	private String orcmatCor;

	@Column(name="orcmat_descricao")
	private String orcmatDescricao;

	@Column(name="ORCMAT_FORNECEDOR")
	private String orcmatFornecedor;

	@Column(name="ORCMAT_IDMDESCRICAO")
	private String orcmatIdmdescricao;

	@Column(name="ORCMAT_IDMUNIDADE")
	private String orcmatIdmunidade;

	@Column(name="orcmat_peso")
	private BigDecimal orcmatPeso;

	@Column(name="ORCMAT_PRC_ALTURA")
	private Integer orcmatPrcAltura;

	@Column(name="ORCMAT_PRC_COMPRIMENTO")
	private Integer orcmatPrcComprimento;

	@Column(name="ORCMAT_PRC_FORMULA")
	private Integer orcmatPrcFormula;

	@Column(name="ORCMAT_PRC_LARGURA")
	private Integer orcmatPrcLargura;

	@Column(name="ORCMAT_PRDUNIDADE")
	private String orcmatPrdunidade;

	@Column(name="orcmat_preco")
	private BigDecimal orcmatPreco;

	@Column(name="orcmat_preco_lista")
	private BigDecimal orcmatPrecoLista;

	@Column(name="orcmat_preco_lista_sem")
	private BigDecimal orcmatPrecoListaSem;

	@Column(name="ORCMAT_PRECO_TAB")
	private BigDecimal orcmatPrecoTab;

	@Column(name="orcmat_qtde")
	private double orcmatQtde;

	@Column(name="ORCMAT_SEMCENTAVOS")
	private Boolean orcmatSemcentavos;

	@Column(name="ORCMATALTURA")
	private double orcmataltura;

	private String orcmatbase;

	@Column(name="ORCMATCOMPRIMENTO")
	private double orcmatcomprimento;

	@Column(name="OrcMatCorPesquisa")
	private String orcMatCorPesquisa;

	@Column(name="ORCMATDESCONTO")
	private BigDecimal orcmatdesconto;

	@Column(name="OrcMatGrupo")
	private Integer orcMatGrupo;

	@Column(name="ORCMATLARGURA")
	private double orcmatlargura;

	private String orcmatlista;

	@Column(name="ORCMATSITUACAO")
	private String orcmatsituacao;

	@Column(name="OrcMatSubGrupo")
	private String orcMatSubGrupo;

	@Column(name="PISCOFINSFATOR")
	private BigDecimal piscofinsfator;

	@Column(name="PISCOFINSVALOR")
	private BigDecimal piscofinsvalor;

	@Column(name="PISFATOR")
	private BigDecimal pisfator;

	@Column(name="PRDORCCHK")
	private Integer prdorcchk;

	@Column(name="preco_fixo")
	private BigDecimal precoFixo;

	@Column(name="REPASSE_CALCULO")
	private BigDecimal repasseCalculo;

	@Column(name="ROYALTIES_CALCULO")
	private BigDecimal royaltiesCalculo;

	@OneToOne
	@Transient
	private Prdorc prdorc;
	
	@Transient
	private List<OrcDet> orcDet;
	
	public OrcMat() {
	}

	public OrcMat(String orcmatCodigo, String orcmatDescricao) {
		super();
		this.orcmatCodigo = orcmatCodigo;
		this.orcmatDescricao = orcmatDescricao;
	}

	public OrcMat(String orcmatCodigo, String orcmatDescricao,
			BigDecimal orcmatPeso, double orcmatQtde) {
		super();
		this.orcmatCodigo = orcmatCodigo;
		this.orcmatDescricao = orcmatDescricao;
		this.orcmatPeso = orcmatPeso;
		this.orcmatQtde = orcmatQtde;
	}

	public OrcMat(String orcmatCodigo, String orcmatDescricao,
			BigDecimal orcmatPeso, double orcmatQtde, List<OrcDet> orcDet) {
		super();
		this.orcmatCodigo = orcmatCodigo;
		this.orcmatDescricao = orcmatDescricao;
		this.orcmatPeso = orcmatPeso;
		this.orcDet = orcDet;
	}

	public OrcMat(String orcmatCodigo, 
			String orcmatDescricao, BigDecimal orcmatPeso,
			BigDecimal orcmatPreco, double orcmatQtde,
			String orcMatCorPesquisa, Integer orcMatGrupo, String orcMatSubGrupo) {
		super();
		this.orcmatCodigo = orcmatCodigo;
		this.orcmatDescricao = orcmatDescricao;
		this.orcmatPeso = orcmatPeso;
		this.orcmatPreco = orcmatPreco;
		this.orcmatQtde = orcmatQtde;
		this.orcMatCorPesquisa = orcMatCorPesquisa;
		this.orcMatGrupo = orcMatGrupo;
		this.orcMatSubGrupo = orcMatSubGrupo;
	}

	public OrcMatPK getId() {
		return this.id;
	}

	public void setId(OrcMatPK id) {
		this.id = id;
	}

	public BigDecimal getCofinsfator() {
		return this.cofinsfator;
	}

	public void setCofinsfator(BigDecimal cofinsfator) {
		this.cofinsfator = cofinsfator;
	}

	public BigDecimal getComissaoFator() {
		return this.comissaoFator;
	}

	public void setComissaoFator(BigDecimal comissaoFator) {
		this.comissaoFator = comissaoFator;
	}

	public BigDecimal getCustoCalculo() {
		return this.custoCalculo;
	}

	public void setCustoCalculo(BigDecimal custoCalculo) {
		this.custoCalculo = custoCalculo;
	}

	public BigDecimal getEncargosValor() {
		return this.encargosValor;
	}

	public void setEncargosValor(BigDecimal encargosValor) {
		this.encargosValor = encargosValor;
	}

	public BigDecimal getFreteCalculo() {
		return this.freteCalculo;
	}

	public void setFreteCalculo(BigDecimal freteCalculo) {
		this.freteCalculo = freteCalculo;
	}

	public BigDecimal getFreteValor() {
		return this.freteValor;
	}

	public void setFreteValor(BigDecimal freteValor) {
		this.freteValor = freteValor;
	}

	public BigDecimal getIcmsBase() {
		return this.icmsBase;
	}

	public void setIcmsBase(BigDecimal icmsBase) {
		this.icmsBase = icmsBase;
	}

	public BigDecimal getIcmsFator() {
		return this.icmsFator;
	}

	public void setIcmsFator(BigDecimal icmsFator) {
		this.icmsFator = icmsFator;
	}

	public BigDecimal getIcmsRedutor() {
		return this.icmsRedutor;
	}

	public void setIcmsRedutor(BigDecimal icmsRedutor) {
		this.icmsRedutor = icmsRedutor;
	}

	public BigDecimal getIcmsValor() {
		return this.icmsValor;
	}

	public void setIcmsValor(BigDecimal icmsValor) {
		this.icmsValor = icmsValor;
	}

	public BigDecimal getIndiceCompra() {
		return this.indiceCompra;
	}

	public void setIndiceCompra(BigDecimal indiceCompra) {
		this.indiceCompra = indiceCompra;
	}

	public BigDecimal getIndiceFaturamento() {
		return this.indiceFaturamento;
	}

	public void setIndiceFaturamento(BigDecimal indiceFaturamento) {
		this.indiceFaturamento = indiceFaturamento;
	}

	public BigDecimal getIpiNaoIncluso() {
		return this.ipiNaoIncluso;
	}

	public void setIpiNaoIncluso(BigDecimal ipiNaoIncluso) {
		this.ipiNaoIncluso = ipiNaoIncluso;
	}

	public BigDecimal getIpiBase() {
		return this.ipiBase;
	}

	public void setIpiBase(BigDecimal ipiBase) {
		this.ipiBase = ipiBase;
	}

	public BigDecimal getIpiFator() {
		return this.ipiFator;
	}

	public void setIpiFator(BigDecimal ipiFator) {
		this.ipiFator = ipiFator;
	}

	public BigDecimal getIpiValor() {
		return this.ipiValor;
	}

	public void setIpiValor(BigDecimal ipiValor) {
		this.ipiValor = ipiValor;
	}

	public BigDecimal getMontagemValor() {
		return this.montagemValor;
	}

	public void setMontagemValor(BigDecimal montagemValor) {
		this.montagemValor = montagemValor;
	}

	public String getNatureza() {
		return this.natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getOrcmatCodigo() {
		return this.orcmatCodigo.trim().toUpperCase();
	}

	public void setOrcmatCodigo(String orcmatCodigo) {
		this.orcmatCodigo = orcmatCodigo.trim().toUpperCase();
	}

	public String getOrcmatCodigoPai() {
		return this.orcmatCodigoPai.trim().toUpperCase();
	}

	public void setOrcmatCodigoPai(String orcmatCodigoPai) {
		this.orcmatCodigoPai = orcmatCodigoPai.trim().toUpperCase();
	}

	public String getOrcmatCor() {
		return this.orcmatCor.trim().toUpperCase();
	}

	public void setOrcmatCor(String orcmatCor) {
		this.orcmatCor = orcmatCor.trim().toUpperCase();
	}

	public String getOrcmatDescricao() {
		return this.orcmatDescricao.trim().toUpperCase();
	}

	public void setOrcmatDescricao(String orcmatDescricao) {
		this.orcmatDescricao = orcmatDescricao.trim().toUpperCase();
	}

	public String getOrcmatFornecedor() {
		return this.orcmatFornecedor;
	}

	public void setOrcmatFornecedor(String orcmatFornecedor) {
		this.orcmatFornecedor = orcmatFornecedor;
	}

	public String getOrcmatIdmdescricao() {
		return this.orcmatIdmdescricao;
	}

	public void setOrcmatIdmdescricao(String orcmatIdmdescricao) {
		this.orcmatIdmdescricao = orcmatIdmdescricao;
	}

	public String getOrcmatIdmunidade() {
		return this.orcmatIdmunidade;
	}

	public void setOrcmatIdmunidade(String orcmatIdmunidade) {
		this.orcmatIdmunidade = orcmatIdmunidade;
	}

	public BigDecimal getOrcmatPeso() {
		return this.orcmatPeso;
	}

	public void setOrcmatPeso(BigDecimal orcmatPeso) {
		this.orcmatPeso = orcmatPeso;
	}

	public Integer getOrcmatPrcAltura() {
		return this.orcmatPrcAltura;
	}

	public void setOrcmatPrcAltura(Integer orcmatPrcAltura) {
		this.orcmatPrcAltura = orcmatPrcAltura;
	}

	public Integer getOrcmatPrcComprimento() {
		return this.orcmatPrcComprimento;
	}

	public void setOrcmatPrcComprimento(Integer orcmatPrcComprimento) {
		this.orcmatPrcComprimento = orcmatPrcComprimento;
	}

	public Integer getOrcmatPrcFormula() {
		return this.orcmatPrcFormula;
	}

	public void setOrcmatPrcFormula(Integer orcmatPrcFormula) {
		this.orcmatPrcFormula = orcmatPrcFormula;
	}

	public Integer getOrcmatPrcLargura() {
		return this.orcmatPrcLargura;
	}

	public void setOrcmatPrcLargura(Integer orcmatPrcLargura) {
		this.orcmatPrcLargura = orcmatPrcLargura;
	}

	public String getOrcmatPrdunidade() {
		return this.orcmatPrdunidade;
	}

	public void setOrcmatPrdunidade(String orcmatPrdunidade) {
		this.orcmatPrdunidade = orcmatPrdunidade;
	}

	public BigDecimal getOrcmatPreco() {
		return this.orcmatPreco;
	}

	public void setOrcmatPreco(BigDecimal orcmatPreco) {
		this.orcmatPreco = orcmatPreco;
	}

	public BigDecimal getOrcmatPrecoLista() {
		return this.orcmatPrecoLista;
	}

	public void setOrcmatPrecoLista(BigDecimal orcmatPrecoLista) {
		this.orcmatPrecoLista = orcmatPrecoLista;
	}

	public BigDecimal getOrcmatPrecoListaSem() {
		return this.orcmatPrecoListaSem;
	}

	public void setOrcmatPrecoListaSem(BigDecimal orcmatPrecoListaSem) {
		this.orcmatPrecoListaSem = orcmatPrecoListaSem;
	}

	public BigDecimal getOrcmatPrecoTab() {
		return this.orcmatPrecoTab;
	}

	public void setOrcmatPrecoTab(BigDecimal orcmatPrecoTab) {
		this.orcmatPrecoTab = orcmatPrecoTab;
	}

	public double getOrcmatQtde() {
		return this.orcmatQtde;
	}

	public void setOrcmatQtde(double orcmatQtde) {
		this.orcmatQtde = orcmatQtde;
	}

	public Boolean getOrcmatSemcentavos() {
		return this.orcmatSemcentavos;
	}

	public void setOrcmatSemcentavos(Boolean orcmatSemcentavos) {
		this.orcmatSemcentavos = orcmatSemcentavos;
	}

	public double getOrcmataltura() {
		return this.orcmataltura;
	}

	public void setOrcmataltura(double orcmataltura) {
		this.orcmataltura = orcmataltura;
	}

	public String getOrcmatbase() {
		return this.orcmatbase;
	}

	public void setOrcmatbase(String orcmatbase) {
		this.orcmatbase = orcmatbase;
	}

	public double getOrcmatcomprimento() {
		return this.orcmatcomprimento;
	}

	public void setOrcmatcomprimento(double orcmatcomprimento) {
		this.orcmatcomprimento = orcmatcomprimento;
	}

	public String getOrcMatCorPesquisa() {
		return this.orcMatCorPesquisa;
	}

	public void setOrcMatCorPesquisa(String orcMatCorPesquisa) {
		this.orcMatCorPesquisa = orcMatCorPesquisa;
	}

	public BigDecimal getOrcmatdesconto() {
		return this.orcmatdesconto;
	}

	public void setOrcmatdesconto(BigDecimal orcmatdesconto) {
		this.orcmatdesconto = orcmatdesconto;
	}

	public Integer getOrcMatGrupo() {
		return this.orcMatGrupo;
	}

	public void setOrcMatGrupo(Integer orcMatGrupo) {
		this.orcMatGrupo = orcMatGrupo;
	}

	public double getOrcmatlargura() {
		return this.orcmatlargura;
	}

	public void setOrcmatlargura(double orcmatlargura) {
		this.orcmatlargura = orcmatlargura;
	}

	public String getOrcmatlista() {
		return this.orcmatlista;
	}

	public void setOrcmatlista(String orcmatlista) {
		this.orcmatlista = orcmatlista;
	}

	public String getOrcmatsituacao() {
		return this.orcmatsituacao;
	}

	public void setOrcmatsituacao(String orcmatsituacao) {
		this.orcmatsituacao = orcmatsituacao;
	}

	public String getOrcMatSubGrupo() {
		return this.orcMatSubGrupo;
	}

	public void setOrcMatSubGrupo(String orcMatSubGrupo) {
		this.orcMatSubGrupo = orcMatSubGrupo;
	}

	public BigDecimal getPiscofinsfator() {
		return this.piscofinsfator;
	}

	public void setPiscofinsfator(BigDecimal piscofinsfator) {
		this.piscofinsfator = piscofinsfator;
	}

	public BigDecimal getPiscofinsvalor() {
		return this.piscofinsvalor;
	}

	public void setPiscofinsvalor(BigDecimal piscofinsvalor) {
		this.piscofinsvalor = piscofinsvalor;
	}

	public BigDecimal getPisfator() {
		return this.pisfator;
	}

	public void setPisfator(BigDecimal pisfator) {
		this.pisfator = pisfator;
	}

	public Integer getPrdorcchk() {
		return this.prdorcchk;
	}

	public void setPrdorcchk(Integer prdorcchk) {
		this.prdorcchk = prdorcchk;
	}

	public BigDecimal getPrecoFixo() {
		return this.precoFixo;
	}

	public void setPrecoFixo(BigDecimal precoFixo) {
		this.precoFixo = precoFixo;
	}

	public BigDecimal getRepasseCalculo() {
		return this.repasseCalculo;
	}

	public void setRepasseCalculo(BigDecimal repasseCalculo) {
		this.repasseCalculo = repasseCalculo;
	}

	public BigDecimal getRoyaltiesCalculo() {
		return this.royaltiesCalculo;
	}

	public void setRoyaltiesCalculo(BigDecimal royaltiesCalculo) {
		this.royaltiesCalculo = royaltiesCalculo;
	}

	public Prdorc getPrdorc() {
		return prdorc;
	}

	public void setPrdorc(Prdorc prdorc) {
		this.prdorc = prdorc;
	}

	public List<OrcDet> getOrcDet() {
		return orcDet;
	}

	public void setOrcDet(List<OrcDet> orcDet) {
		this.orcDet = orcDet;
	}
	
	public String toString(String margin) {
		StringBuffer buf = new StringBuffer();

		margin = " " + margin;
		
		buf.append(String.format("%sORCMAT: %s %s, qtd: %2f\n", margin, this.getOrcmatCodigo(), this.getOrcmatDescricao(), this.getOrcmatQtde()));
		
		buf.append(this.prdorc.toString(margin));
		
		for(OrcDet det : this.orcDet == null ? new ArrayList<OrcDet>() : this.orcDet) {
			buf.append(det.toString(margin));
		}
		return buf.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orcmatCodigo == null) ? 0 : orcmatCodigo.hashCode());
		result = prime * result
				+ ((orcmatDescricao == null) ? 0 : orcmatDescricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrcMat other = (OrcMat) obj;
		if (orcmatCodigo == null) {
			if (other.orcmatCodigo != null)
				return false;
		} else if (!orcmatCodigo.equals(other.orcmatCodigo))
			return false;
		if (orcmatDescricao == null) {
			if (other.orcmatDescricao != null)
				return false;
		} else if (!orcmatDescricao.equals(other.orcmatDescricao))
			return false;
		if (orcmatCor == null) {
			if (other.orcmatCor != null)
				return false;
		} else if (!orcmatCor.equals(other.orcmatCor))
			return false;
		if (orcMatCorPesquisa == null) {
			if (other.orcMatCorPesquisa != null)
				return false;
		} else if (!orcMatCorPesquisa.equals(other.orcMatCorPesquisa))
			return false;
		if (orcmatQtde != other.orcmatQtde)
			return false;
		if (!orcmatPeso.equals(other.orcmatPeso)) 
			return false;
		if (!orcMatGrupo.equals(other.orcMatGrupo)) 
			return false;
		if (!orcMatSubGrupo.equals(other.orcMatSubGrupo)) 
			return false;
		
		return true;
	}
	
	public static <T> boolean hasDuplicate(Iterable<T> all) {
	    Set<T> set = new HashSet<T>();
	    // Set#add returns false if the set does not change, which
	    // indicates that a duplicate element has been added.
	    for (T each: all) if (!set.add(each)) return true;
	    return false;
	}

}