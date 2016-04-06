package br.com.altamira.data.wbccad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * The persistent class for the OrcItm database table.
 * 
 */
@Entity
public class OrcItm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idOrcItm;

	private String numeroOrcamento;

	@Column(name="orcitm_altura")
	private BigDecimal orcitmAltura;

	@Column(name="orcitm_comprimento")
	private BigDecimal orcitmComprimento;

	@Column(name="OrcItm_Desc_Destacado")
	private Boolean orcItm_Desc_Destacado;

	@Column(name="OrcItm_Desconto_Grupo")
	private BigDecimal orcItm_Desconto_Grupo;

	@Column(name="OrcItm_Diferenca")
	private BigDecimal orcItm_Diferenca;

	@Column(name="orcitm_dtc")
	private String orcitmDtc;

	@Column(name="OrcItm_Encargos")
	private BigDecimal orcItm_Encargos;

	@Column(name="OrcItm_Frete")
	private BigDecimal orcItm_Frete;

	@Column(name="orcitm_grupo")
	private Integer orcitmGrupo;

	@Column(name="OrcItm_IPI")
	private BigDecimal orcItm_IPI;

	@Column(name="orcitm_item")
	private String orcitmItem;

	@Column(name="orcitm_largura")
	private BigDecimal orcitmLargura;

	@Column(name="OrcItm_Preco_Lista")
	private BigDecimal orcItm_Preco_Lista;

	@Column(name="OrcItm_Preco_Lista_Sem")
	private BigDecimal orcItm_Preco_Lista_Sem;

	@Column(name="orcitm_qtde")
	private Double orcitmQtde;

	@Column(name="ORCITM_REFERENCIA")
	private String orcitmReferencia;

	@Column(name="orcitm_subgrupo")
	private String orcitmSubgrupo;

	@Column(name="orcitm_suprimir_itens")
	private Boolean orcitmSuprimirItens;

	@Column(name="ORCITM_TOTAL")
	private Integer orcitmTotal;

	@Column(name="OrcItm_ValGrupoComDesc")
	private BigDecimal orcItm_ValGrupoComDesc;

	@Column(name="orcitm_valor_total")
	private BigDecimal orcitmValorTotal;

	@Column(name="proposta_descricao")
	private String propostaDescricao;

	@Column(name="proposta_grupo")
	private Integer propostaGrupo;

	@Column(name="proposta_imagem")
	private String propostaImagem;

	@Column(name="proposta_ordem")
	private Integer propostaOrdem;

	@Column(name="proposta_texto_base")
	private String propostaTextoBase;

	@Column(name="proposta_texto_item")
	private String propostaTextoItem;

	@Transient
	private String orctxt;
	
	@Transient
	private List<OrcMat> orcMat;
	
	@Transient
	private List<OrcDet> orcdet;
	
	public OrcItm() {
	}

	public OrcItm(String numeroOrcamento, Integer orcitmGrupo,
			String orcitmSubgrupo, String orcitmItem) {
		super();
		this.numeroOrcamento = numeroOrcamento;
		this.orcitmGrupo = orcitmGrupo;
		this.orcitmSubgrupo = orcitmSubgrupo;
		this.orcitmItem = orcitmItem;
	}

	public Integer getIdOrcItm() {
		return this.idOrcItm;
	}

	public void setIdOrcItm(Integer idOrcItm) {
		this.idOrcItm = idOrcItm;
	}

	public String getNumeroOrcamento() {
		return this.numeroOrcamento;
	}

	public void setNumeroOrcamento(String numeroOrcamento) {
		this.numeroOrcamento = numeroOrcamento;
	}

	public BigDecimal getOrcitmAltura() {
		return this.orcitmAltura;
	}

	public void setOrcitmAltura(BigDecimal orcitmAltura) {
		this.orcitmAltura = orcitmAltura;
	}

	public BigDecimal getOrcitmComprimento() {
		return this.orcitmComprimento;
	}

	public void setOrcitmComprimento(BigDecimal orcitmComprimento) {
		this.orcitmComprimento = orcitmComprimento;
	}

	public Boolean getOrcItm_Desc_Destacado() {
		return this.orcItm_Desc_Destacado;
	}

	public void setOrcItm_Desc_Destacado(Boolean orcItm_Desc_Destacado) {
		this.orcItm_Desc_Destacado = orcItm_Desc_Destacado;
	}

	public BigDecimal getOrcItm_Desconto_Grupo() {
		return this.orcItm_Desconto_Grupo;
	}

	public void setOrcItm_Desconto_Grupo(BigDecimal orcItm_Desconto_Grupo) {
		this.orcItm_Desconto_Grupo = orcItm_Desconto_Grupo;
	}

	public BigDecimal getOrcItm_Diferenca() {
		return this.orcItm_Diferenca;
	}

	public void setOrcItm_Diferenca(BigDecimal orcItm_Diferenca) {
		this.orcItm_Diferenca = orcItm_Diferenca;
	}

	public String getOrcitmDtc() {
		return this.orcitmDtc;
	}

	public void setOrcitmDtc(String orcitmDtc) {
		this.orcitmDtc = orcitmDtc;
	}

	public BigDecimal getOrcItm_Encargos() {
		return this.orcItm_Encargos;
	}

	public void setOrcItm_Encargos(BigDecimal orcItm_Encargos) {
		this.orcItm_Encargos = orcItm_Encargos;
	}

	public BigDecimal getOrcItm_Frete() {
		return this.orcItm_Frete;
	}

	public void setOrcItm_Frete(BigDecimal orcItm_Frete) {
		this.orcItm_Frete = orcItm_Frete;
	}

	public Integer getOrcitmGrupo() {
		return this.orcitmGrupo;
	}

	public void setOrcitmGrupo(Integer orcitmGrupo) {
		this.orcitmGrupo = orcitmGrupo;
	}

	public BigDecimal getOrcItm_IPI() {
		return this.orcItm_IPI;
	}

	public void setOrcItm_IPI(BigDecimal orcItm_IPI) {
		this.orcItm_IPI = orcItm_IPI;
	}

	public String getOrcitmItem() {
		return this.orcitmItem;
	}

	public void setOrcitmItem(String orcitmItem) {
		this.orcitmItem = orcitmItem;
	}

	public BigDecimal getOrcitmLargura() {
		return this.orcitmLargura;
	}

	public void setOrcitmLargura(BigDecimal orcitmLargura) {
		this.orcitmLargura = orcitmLargura;
	}

	public BigDecimal getOrcItm_Preco_Lista() {
		return this.orcItm_Preco_Lista;
	}

	public void setOrcItm_Preco_Lista(BigDecimal orcItm_Preco_Lista) {
		this.orcItm_Preco_Lista = orcItm_Preco_Lista;
	}

	public BigDecimal getOrcItm_Preco_Lista_Sem() {
		return this.orcItm_Preco_Lista_Sem;
	}

	public void setOrcItm_Preco_Lista_Sem(BigDecimal orcItm_Preco_Lista_Sem) {
		this.orcItm_Preco_Lista_Sem = orcItm_Preco_Lista_Sem;
	}

	public Double getOrcitmQtde() {
		return this.orcitmQtde;
	}

	public void setOrcitmQtde(Double orcitmQtde) {
		this.orcitmQtde = orcitmQtde;
	}

	public String getOrcitmReferencia() {
		return this.orcitmReferencia;
	}

	public void setOrcitmReferencia(String orcitmReferencia) {
		this.orcitmReferencia = orcitmReferencia;
	}

	public String getOrcitmSubgrupo() {
		return this.orcitmSubgrupo;
	}

	public void setOrcitmSubgrupo(String orcitmSubgrupo) {
		this.orcitmSubgrupo = orcitmSubgrupo;
	}

	public Boolean getOrcitmSuprimirItens() {
		return this.orcitmSuprimirItens;
	}

	public void setOrcitmSuprimirItens(Boolean orcitmSuprimirItens) {
		this.orcitmSuprimirItens = orcitmSuprimirItens;
	}

	public Integer getOrcitmTotal() {
		return this.orcitmTotal;
	}

	public void setOrcitmTotal(Integer orcitmTotal) {
		this.orcitmTotal = orcitmTotal;
	}

	public BigDecimal getOrcItm_ValGrupoComDesc() {
		return this.orcItm_ValGrupoComDesc;
	}

	public void setOrcItm_ValGrupoComDesc(BigDecimal orcItm_ValGrupoComDesc) {
		this.orcItm_ValGrupoComDesc = orcItm_ValGrupoComDesc;
	}

	public BigDecimal getOrcitmValorTotal() {
		return this.orcitmValorTotal;
	}

	public void setOrcitmValorTotal(BigDecimal orcitmValorTotal) {
		this.orcitmValorTotal = orcitmValorTotal;
	}

	public String getPropostaDescricao() {
		return this.propostaDescricao;
	}

	public void setPropostaDescricao(String propostaDescricao) {
		this.propostaDescricao = propostaDescricao;
	}

	public Integer getPropostaGrupo() {
		return this.propostaGrupo;
	}

	public void setPropostaGrupo(Integer propostaGrupo) {
		this.propostaGrupo = propostaGrupo;
	}

	public String getPropostaImagem() {
		return this.propostaImagem;
	}

	public void setPropostaImagem(String propostaImagem) {
		this.propostaImagem = propostaImagem;
	}

	public Integer getPropostaOrdem() {
		return this.propostaOrdem;
	}

	public void setPropostaOrdem(Integer propostaOrdem) {
		this.propostaOrdem = propostaOrdem;
	}

	public String getPropostaTextoBase() {
		return this.propostaTextoBase;
	}

	public void setPropostaTextoBase(String propostaTextoBase) {
		this.propostaTextoBase = propostaTextoBase;
	}

	public String getPropostaTextoItem() {
		return this.propostaTextoItem;
	}

	public void setPropostaTextoItem(String propostaTextoItem) {
		this.propostaTextoItem = propostaTextoItem;
	}

	public String getOrctxt() {
		return orctxt;
	}

	public void setOrctxt(String orctxt) {
		this.orctxt = orctxt;
	}

	public List<OrcMat> getOrcMat() {
		return orcMat;
	}

	public void setOrcMat(List<OrcMat> orcMat) {
		this.orcMat = orcMat;
	}

	public List<OrcDet> getOrcdet() {
		return orcdet;
	}

	public void setOrcdet(List<OrcDet> orcdet) {
		this.orcdet = orcdet;
	}
	
	public String toString(String margin) {
		StringBuffer buf = new StringBuffer();
		
		margin = " " + margin;
		
		buf.append(String.format("%sORCITM: %s %s\n", margin, this.getOrcitmItem(), this.getOrctxt() == null ? "" : this.getOrctxt().trim()));
		
		for(OrcDet det : this.orcdet) {
			buf.append(det.toString(margin));
		}
		return buf.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroOrcamento == null) ? 0 : numeroOrcamento.trim().hashCode());
		result = prime * result
				+ ((orcitmGrupo == null) ? 0 : orcitmGrupo.hashCode());
		result = prime * result;
		if (orcitmItem != null) {
			try {
				result += new Integer(orcitmItem.trim()).toString().hashCode();
			} catch(NumberFormatException e) {
				result += orcitmItem.trim().hashCode();
			}
		}
		result = prime * result;
		if (orcitmSubgrupo != null) {
			try {
				result += new Integer(orcitmSubgrupo.trim()).toString().hashCode();
			} catch(NumberFormatException e) {
				result += orcitmSubgrupo.trim().hashCode();
			}
		}
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
		OrcItm other = (OrcItm) obj;
		if (numeroOrcamento == null) {
			if (other.numeroOrcamento != null)
				return false;
		} else if (!numeroOrcamento.trim().equals(other.numeroOrcamento.trim()))
			return false;
		if (orcitmGrupo == null) {
			if (other.orcitmGrupo != null)
				return false;
		} else if (!orcitmGrupo.equals(other.orcitmGrupo))
			return false;
		if (orcitmItem == null) {
			if (other.orcitmItem != null)
				return false;
		} else {
			if (!orcitmItem.trim().equals(other.orcitmItem.trim())) {
				/**
				 *  se diferente tenta converter e comparar inteiros
				 *  porque na tabela INTEGRACAO_ORCITM este campo vem como inteiro
				 *  Ex: '01' <> '1'
				 */
				try {
					int n1 = Integer.parseInt(orcitmItem);
					int n2 = Integer.parseInt(other.orcitmItem);
					if (n1 != n2)
						return false;
				} catch(NumberFormatException e) {
					return false;
				}
			}
		}
		if (orcitmSubgrupo == null) {
			if (other.orcitmSubgrupo != null)
				return false;
		} else {
			if (!orcitmSubgrupo.trim().equals(other.orcitmSubgrupo.trim())) {

				/**
				 *  se diferente tenta converter e comparar inteiros
				 *  porque na tabela INTEGRACAO_ORCITM este campo vem como inteiro
				 *  Ex: '01' <> '1'
				 */
				try {
					int n1 = Integer.parseInt(orcitmSubgrupo);
					int n2 = Integer.parseInt(other.orcitmSubgrupo);
					if (n1 != n2)
						return false;
				} catch(NumberFormatException e) {
					return false;
				}
			}
		}
			
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