package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the PRDEST database table.
 * 
 */
@Entity
@Table(name="PRDEST")
public class Prdest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrdestPK id;
	
	@Column(name="ALTURA")
	private String altura;

	@Column(name="ATUALIZADOEM")
	private Timestamp atualizadoem;

	@Column(name="COMPRIMENTO")
	private String comprimento;

	@Column(name="FANTASMA")
	private Boolean fantasma;

	@Column(name="FORMULAPRECO")
	private String formulapreco;

	@Column(name="IMPORTADOEM")
	private Timestamp importadoem;

	@Column(name="PRDEST_FORMULA_ALTURA")
	private String prdestFormulaAltura;

	@Column(name="PRDEST_FORMULA_COMPRIMENTO")
	private String prdestFormulaComprimento;

	@Column(name="PRDEST_FORMULA_MULTIPLICAR")
	private String prdestFormulaMultiplicar;

	@Column(name="PRDEST_FORMULA_PROFUNDIDADE")
	private String prdestFormulaProfundidade;

	@Column(name="PRDEST_PESO")
	private String prdestPeso;

	@Column(name="PRDEST_PESO_ALTURA")
	private String prdestPesoAltura;

	@Column(name="PRDEST_PESO_COMPRIMENTO")
	private String prdestPesoComprimento;

	@Column(name="PRDEST_PESO_FIXO")
	private String prdestPesoFixo;

	@Column(name="PRDEST_PESO_PROFUNDIDADE")
	private String prdestPesoProfundidade;

	@Column(name="PRDEST_QTDE")
	private String prdestQtde;

	@Column(name="PRDESTCONDICAO")
	private String prdestcondicao;

	@Column(name="PRDESTDEPARA")
	private String prdestdepara;

	@Column(name="PRDESTFORMULA")
	private String prdestformula;

	@Column(name="PRDESTSEQUENCIAL")
	private Integer prdestsequencial;


	@Column(name="PROFUNDIDADE")
	private String profundidade;

	// Prdorc codigo filho
	@Transient
	private Prdorc prdorc;
	
	public Prdest() {
	}

	public PrdestPK getId() {
		return id;
	}

	public void setId(PrdestPK id) {
		this.id = id;
	}

	public String getAltura() {
		return this.altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Timestamp getAtualizadoem() {
		return this.atualizadoem;
	}

	public void setAtualizadoem(Timestamp atualizadoem) {
		this.atualizadoem = atualizadoem;
	}

	public String getComprimento() {
		return this.comprimento;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public Boolean getFantasma() {
		return this.fantasma;
	}

	public void setFantasma(Boolean fantasma) {
		this.fantasma = fantasma;
	}

	public String getFormulapreco() {
		return this.formulapreco;
	}

	public void setFormulapreco(String formulapreco) {
		this.formulapreco = formulapreco;
	}

	public Timestamp getImportadoem() {
		return this.importadoem;
	}

	public void setImportadoem(Timestamp importadoem) {
		this.importadoem = importadoem;
	}

	public String getPrdestFormulaAltura() {
		return this.prdestFormulaAltura;
	}

	public void setPrdestFormulaAltura(String prdestFormulaAltura) {
		this.prdestFormulaAltura = prdestFormulaAltura;
	}

	public String getPrdestFormulaComprimento() {
		return this.prdestFormulaComprimento;
	}

	public void setPrdestFormulaComprimento(String prdestFormulaComprimento) {
		this.prdestFormulaComprimento = prdestFormulaComprimento;
	}

	public String getPrdestFormulaMultiplicar() {
		return this.prdestFormulaMultiplicar;
	}

	public void setPrdestFormulaMultiplicar(String prdestFormulaMultiplicar) {
		this.prdestFormulaMultiplicar = prdestFormulaMultiplicar;
	}

	public String getPrdestFormulaProfundidade() {
		return this.prdestFormulaProfundidade;
	}

	public void setPrdestFormulaProfundidade(String prdestFormulaProfundidade) {
		this.prdestFormulaProfundidade = prdestFormulaProfundidade;
	}

	public String getPrdestPeso() {
		return this.prdestPeso;
	}

	public void setPrdestPeso(String prdestPeso) {
		this.prdestPeso = prdestPeso;
	}

	public String getPrdestPesoAltura() {
		return this.prdestPesoAltura;
	}

	public void setPrdestPesoAltura(String prdestPesoAltura) {
		this.prdestPesoAltura = prdestPesoAltura;
	}

	public String getPrdestPesoComprimento() {
		return this.prdestPesoComprimento;
	}

	public void setPrdestPesoComprimento(String prdestPesoComprimento) {
		this.prdestPesoComprimento = prdestPesoComprimento;
	}

	public String getPrdestPesoFixo() {
		return this.prdestPesoFixo;
	}

	public void setPrdestPesoFixo(String prdestPesoFixo) {
		this.prdestPesoFixo = prdestPesoFixo;
	}

	public String getPrdestPesoProfundidade() {
		return this.prdestPesoProfundidade;
	}

	public void setPrdestPesoProfundidade(String prdestPesoProfundidade) {
		this.prdestPesoProfundidade = prdestPesoProfundidade;
	}

	public String getPrdestQtde() {
		return this.prdestQtde;
	}

	public void setPrdestQtde(String prdestQtde) {
		this.prdestQtde = prdestQtde;
	}

	public String getPrdestcondicao() {
		return this.prdestcondicao;
	}

	public void setPrdestcondicao(String prdestcondicao) {
		this.prdestcondicao = prdestcondicao;
	}

	public String getPrdestdepara() {
		return this.prdestdepara;
	}

	public void setPrdestdepara(String prdestdepara) {
		this.prdestdepara = prdestdepara;
	}

	public String getPrdestformula() {
		return this.prdestformula;
	}

	public void setPrdestformula(String prdestformula) {
		this.prdestformula = prdestformula;
	}

	public Integer getPrdestsequencial() {
		return this.prdestsequencial;
	}

	public void setPrdestsequencial(Integer prdestsequencial) {
		this.prdestsequencial = prdestsequencial;
	}

	public String getProfundidade() {
		return this.profundidade;
	}

	public void setProfundidade(String profundidade) {
		this.profundidade = profundidade;
	}

	public Prdorc getPrdorc() {
		return prdorc;
	}

	public void setPrdorc(Prdorc prdorc) {
		this.prdorc = prdorc;
	}
	
	public String toString(String margin) {
		return String.format("%sPRDEST: %s %s, qtd: %s\n%s", margin, this.getId().getPrdorccodigopai(), this.getId().getPrdorccodigofilho(), this.getPrdestQtde(), this.prdorc.toString(" " + margin));
	}

}