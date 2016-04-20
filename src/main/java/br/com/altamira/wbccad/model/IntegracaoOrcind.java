package br.com.altamira.wbccad.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INTEGRACAO_ORCIND database table.
 * 
 */
@Entity
@Table(name="INTEGRACAO_ORCIND")
public class IntegracaoOrcind implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIntegracao_OrcInd;

	@Column(name="ORCNUM")
	private String orcnum;

	@Column(name="ORCVAL")
	private BigDecimal orcval;

	@Column(name="TIPINDCOD")
	private String tipindcod;

	public IntegracaoOrcind() {
	}

	public int getIdIntegracao_OrcInd() {
		return this.idIntegracao_OrcInd;
	}

	public void setIdIntegracao_OrcInd(int idIntegracao_OrcInd) {
		this.idIntegracao_OrcInd = idIntegracao_OrcInd;
	}

	public String getOrcnum() {
		return this.orcnum;
	}

	public void setOrcnum(String orcnum) {
		this.orcnum = orcnum;
	}

	public BigDecimal getOrcval() {
		return this.orcval;
	}

	public void setOrcval(BigDecimal orcval) {
		this.orcval = orcval;
	}

	public String getTipindcod() {
		return this.tipindcod;
	}

	public void setTipindcod(String tipindcod) {
		this.tipindcod = tipindcod;
	}

}