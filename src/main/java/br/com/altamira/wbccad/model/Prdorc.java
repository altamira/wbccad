package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the prdorc database table.
 * 
 */
@Entity
@Table(name="prdorc")
@NamedQuery(name="Prdorc.findAll", query="SELECT p FROM Prdorc p")
public class Prdorc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Produto")
	private String produto;

	@Column(name="Altura")
	private Double altura;

	@Column(name="ATUALIZADOEM")
	private Timestamp atualizadoem;

	private String codigointegracao;

	@Column(name="Comprimento")
	private Integer comprimento;

	@Column(name="Cor_padrao")
	private String cor_padrao;

	@Column(name="Descricao")
	private String descricao;

	@Column(name="Familia")
	private String familia;

	@Column(name="IMPORTADOEM")
	private Timestamp importadoem;

	@Column(name="IMPORTARESTRUTURA")
	private Integer importarestrutura;

	private Integer indice;

	@Column(name="ITEMFATURADO")
	private Boolean itemfaturado;

	@Column(name="Largura")
	private Integer largura;

	@Column(name="ORIGEM")
	private String origem;

	@Column(name="Peso")
	private Double peso;

	@Column(name="PRDCRTADC")
	private String prdcrtadc;

	@Column(name="PRDDSCORC")
	private String prddscorc;

	@Column(name="PRDORC_EXP_FLAG_ALT")
	private Boolean prdorcExpFlagAlt;

	@Column(name="PRDORC_EXP_FLAG_CMP")
	private Boolean prdorcExpFlagCmp;

	@Column(name="PRDORC_EXP_FLAG_LRG")
	private Boolean prdorcExpFlagLrg;

	@Column(name="PRDORC_FORNECEDOR")
	private String prdorcFornecedor;

	@Column(name="PRDORC_GRUPOCOR")
	private String prdorcGrupocor;

	@Column(name="PRDORC_GRUPOCORESADC")
	private String prdorcGrupocoresadc;

	@Column(name="PRDORC_PESO_ALT")
	private Double prdorcPesoAlt;

	@Column(name="PRDORC_PESO_CMP")
	private Double prdorcPesoCmp;

	@Column(name="PRDORC_PESO_FIX")
	private Double prdorcPesoFix;

	@Column(name="PRDORC_PESO_PRF")
	private Double prdorcPesoPrf;

	@Column(name="PRDORC_PRC_ALTURA")
	private Integer prdorcPrcAltura;

	@Column(name="PRDORC_PRC_COMPRIMENTO")
	private Integer prdorcPrcComprimento;

	@Column(name="PRDORC_PRC_FORMULA")
	private Integer prdorcPrcFormula;

	@Column(name="PRDORC_PRC_LARGURA")
	private Integer prdorcPrcLargura;

	@Column(name="PRDORC_PRIORIDADE")
	private Integer prdorcPrioridade;

	@Column(name="prdorc_semcentavos")
	private Boolean prdorcSemcentavos;

	@Column(name="PrdOrcAoExportarSubtrairDoComprimento")
	private Double prdOrcAoExportarSubtrairDoComprimento;

	@Column(name="PRDORCCHK")
	private Integer prdorcchk;

	@Column(name="PrdOrcImagem")
	private String prdOrcImagem;

	@Column(name="PRDORCVARIAVEIS")
	private String prdorcvariaveis;

	@Column(name="Preco")
	private Double preco;

	@Column(name="Situacao")
	private String situacao;

	@Column(name="TRAVAR_REPRESENTANTE")
	private Boolean travarRepresentante;

	@Column(name="Unidade")
	private String unidade;

	@Column(name="utilizar_medidas_originais")
	private Boolean utilizarMedidasOriginais;
	
	@Transient
	private int ref;

	@Transient
	@OneToMany
	private List<Prdest> prdest = new ArrayList<Prdest>();
	
	public Prdorc() {
	}

	public Double getAltura() {
		return this.altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Timestamp getAtualizadoem() {
		return this.atualizadoem;
	}

	public void setAtualizadoem(Timestamp atualizadoem) {
		this.atualizadoem = atualizadoem;
	}

	public String getcodigoIntegracao() {
		return this.codigointegracao;
	}

	public void setcodigoIntegracao(String codigointegracao) {
		this.codigointegracao = codigointegracao;
	}

	public Integer getComprimento() {
		return this.comprimento;
	}

	public void setComprimento(Integer comprimento) {
		this.comprimento = comprimento;
	}

	public String getCor_padrao() {
		return this.cor_padrao;
	}

	public void setCor_padrao(String cor_padrao) {
		this.cor_padrao = cor_padrao;
	}

	public String getDescricao() {
		return this.descricao.trim().toUpperCase();
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao.trim().toUpperCase();
	}

	public String getFamilia() {
		return this.familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public Timestamp getImportadoem() {
		return this.importadoem;
	}

	public void setImportadoem(Timestamp importadoem) {
		this.importadoem = importadoem;
	}

	public Integer getImportarestrutura() {
		return this.importarestrutura;
	}

	public void setImportarestrutura(Integer importarestrutura) {
		this.importarestrutura = importarestrutura;
	}

	public Integer getIndice() {
		return this.indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Boolean getItemfaturado() {
		return this.itemfaturado;
	}

	public void setItemfaturado(Boolean itemfaturado) {
		this.itemfaturado = itemfaturado;
	}

	public Integer getLargura() {
		return this.largura;
	}

	public void setLargura(Integer largura) {
		this.largura = largura;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Double getPeso() {
		return this.peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getPrdcrtadc() {
		return this.prdcrtadc;
	}

	public void setPrdcrtadc(String prdcrtadc) {
		this.prdcrtadc = prdcrtadc;
	}

	public String getPrddscorc() {
		return this.prddscorc;
	}

	public void setPrddscorc(String prddscorc) {
		this.prddscorc = prddscorc;
	}

	public Boolean getPrdorcExpFlagAlt() {
		return this.prdorcExpFlagAlt;
	}

	public void setPrdorcExpFlagAlt(Boolean prdorcExpFlagAlt) {
		this.prdorcExpFlagAlt = prdorcExpFlagAlt;
	}

	public Boolean getPrdorcExpFlagCmp() {
		return this.prdorcExpFlagCmp;
	}

	public void setPrdorcExpFlagCmp(Boolean prdorcExpFlagCmp) {
		this.prdorcExpFlagCmp = prdorcExpFlagCmp;
	}

	public Boolean getPrdorcExpFlagLrg() {
		return this.prdorcExpFlagLrg;
	}

	public void setPrdorcExpFlagLrg(Boolean prdorcExpFlagLrg) {
		this.prdorcExpFlagLrg = prdorcExpFlagLrg;
	}

	public String getPrdorcFornecedor() {
		return this.prdorcFornecedor;
	}

	public void setPrdorcFornecedor(String prdorcFornecedor) {
		this.prdorcFornecedor = prdorcFornecedor;
	}

	public String getPrdorcGrupocor() {
		return this.prdorcGrupocor;
	}

	public void setPrdorcGrupocor(String prdorcGrupocor) {
		this.prdorcGrupocor = prdorcGrupocor;
	}

	public String getPrdorcGrupocoresadc() {
		return this.prdorcGrupocoresadc;
	}

	public void setPrdorcGrupocoresadc(String prdorcGrupocoresadc) {
		this.prdorcGrupocoresadc = prdorcGrupocoresadc;
	}

	public Double getPrdorcPesoAlt() {
		return this.prdorcPesoAlt;
	}

	public void setPrdorcPesoAlt(Double prdorcPesoAlt) {
		this.prdorcPesoAlt = prdorcPesoAlt;
	}

	public Double getPrdorcPesoCmp() {
		return this.prdorcPesoCmp;
	}

	public void setPrdorcPesoCmp(Double prdorcPesoCmp) {
		this.prdorcPesoCmp = prdorcPesoCmp;
	}

	public Double getPrdorcPesoFix() {
		return this.prdorcPesoFix;
	}

	public void setPrdorcPesoFix(Double prdorcPesoFix) {
		this.prdorcPesoFix = prdorcPesoFix;
	}

	public Double getPrdorcPesoPrf() {
		return this.prdorcPesoPrf;
	}

	public void setPrdorcPesoPrf(Double prdorcPesoPrf) {
		this.prdorcPesoPrf = prdorcPesoPrf;
	}

	public Integer getPrdorcPrcAltura() {
		return this.prdorcPrcAltura;
	}

	public void setPrdorcPrcAltura(Integer prdorcPrcAltura) {
		this.prdorcPrcAltura = prdorcPrcAltura;
	}

	public Integer getPrdorcPrcComprimento() {
		return this.prdorcPrcComprimento;
	}

	public void setPrdorcPrcComprimento(Integer prdorcPrcComprimento) {
		this.prdorcPrcComprimento = prdorcPrcComprimento;
	}

	public Integer getPrdorcPrcFormula() {
		return this.prdorcPrcFormula;
	}

	public void setPrdorcPrcFormula(Integer prdorcPrcFormula) {
		this.prdorcPrcFormula = prdorcPrcFormula;
	}

	public Integer getPrdorcPrcLargura() {
		return this.prdorcPrcLargura;
	}

	public void setPrdorcPrcLargura(Integer prdorcPrcLargura) {
		this.prdorcPrcLargura = prdorcPrcLargura;
	}

	public Integer getPrdorcPrioridade() {
		return this.prdorcPrioridade;
	}

	public void setPrdorcPrioridade(Integer prdorcPrioridade) {
		this.prdorcPrioridade = prdorcPrioridade;
	}

	public Boolean getPrdorcSemcentavos() {
		return this.prdorcSemcentavos;
	}

	public void setPrdorcSemcentavos(Boolean prdorcSemcentavos) {
		this.prdorcSemcentavos = prdorcSemcentavos;
	}

	public Double getPrdOrcAoExportarSubtrairDoComprimento() {
		return this.prdOrcAoExportarSubtrairDoComprimento;
	}

	public void setPrdOrcAoExportarSubtrairDoComprimento(Double prdOrcAoExportarSubtrairDoComprimento) {
		this.prdOrcAoExportarSubtrairDoComprimento = prdOrcAoExportarSubtrairDoComprimento;
	}

	public Integer getPrdorcchk() {
		return this.prdorcchk;
	}

	public void setPrdorcchk(Integer prdorcchk) {
		this.prdorcchk = prdorcchk;
	}

	public String getPrdOrcImagem() {
		return this.prdOrcImagem;
	}

	public void setPrdOrcImagem(String prdOrcImagem) {
		this.prdOrcImagem = prdOrcImagem;
	}

	public String getPrdorcvariaveis() {
		return this.prdorcvariaveis;
	}

	public void setPrdorcvariaveis(String prdorcvariaveis) {
		this.prdorcvariaveis = prdorcvariaveis;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getProduto() {
		return this.produto.trim().toUpperCase();
	}

	public void setProduto(String produto) {
		this.produto = produto.trim().toUpperCase();
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Boolean getTravarRepresentante() {
		return this.travarRepresentante;
	}

	public void setTravarRepresentante(Boolean travarRepresentante) {
		this.travarRepresentante = travarRepresentante;
	}

	public String getUnidade() {
		return this.unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Boolean getUtilizarMedidasOriginais() {
		return this.utilizarMedidasOriginais;
	}

	public void setUtilizarMedidasOriginais(Boolean utilizarMedidasOriginais) {
		this.utilizarMedidasOriginais = utilizarMedidasOriginais;
	}

	public List<Prdest> getPrdest() {
		return prdest;
	}

	public void setPrdest(List<Prdest> prdest) {
		this.prdest = prdest;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", this.getProduto(), this.getDescricao());
	}
	
	public String toString(String margin) {
		StringBuffer buf = new StringBuffer();
		
		margin = " " + margin;

		buf.append(String.format("%sPRDORC: [Instance ID: #%s, Ref.Count: %d] %s %s\n", margin, this.hashCode(), this.getRef(), this.getProduto().trim(), this.getDescricao().trim()));
		
		for(Prdest prd : this.prdest) {
			buf.append(prd.toString(" " + margin));
		}
		return buf.toString();
	}

	public int getRef() {
		return this.ref;
	}

	public void setRef() {
		this.ref++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
		Prdorc other = (Prdorc) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
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