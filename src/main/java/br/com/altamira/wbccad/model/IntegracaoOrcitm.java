package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the INTEGRACAO_ORCITM database table.
 * 
 */
@Entity
@Table(name="INTEGRACAO_ORCITM")
public class IntegracaoOrcitm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idIntegracao_OrcItm;

	@Column(name="GRPCOD")
	private Integer grpcod;

	@Column(name="ORCICM")
	private BigDecimal orcicm;

	@Column(name="ORCIPI")
	private BigDecimal orcipi;

	@Column(name="ORCITM")
	private Integer orcitm;

	@Column(name="ORCNUM")
	private String orcnum;

	@Column(name="ORCPRDCOD")
	private String orcprdcod;

	@Column(name="ORCPRDQTD")
	private BigDecimal orcprdqtd;

	@Column(name="ORCTXT")
	private String orctxt;

	@Column(name="ORCVAL")
	private BigDecimal orcval;

	@Column(name="SUBGRPCOD")
	private Integer subgrpcod;

	@Transient
	private List<IntegracaoOrcprd> orcprd;
	
	public IntegracaoOrcitm() {
	}

	public Integer getIdIntegracao_OrcItm() {
		return this.idIntegracao_OrcItm;
	}

	public void setIdIntegracao_OrcItm(Integer idIntegracao_OrcItm) {
		this.idIntegracao_OrcItm = idIntegracao_OrcItm;
	}

	public Integer getGrpcod() {
		return this.grpcod;
	}

	public void setGrpcod(Integer grpcod) {
		this.grpcod = grpcod;
	}

	public BigDecimal getOrcicm() {
		return this.orcicm;
	}

	public void setOrcicm(BigDecimal orcicm) {
		this.orcicm = orcicm;
	}

	public BigDecimal getOrcipi() {
		return this.orcipi;
	}

	public void setOrcipi(BigDecimal orcipi) {
		this.orcipi = orcipi;
	}

	public Integer getOrcitm() {
		return this.orcitm;
	}

	public void setOrcitm(Integer orcitm) {
		this.orcitm = orcitm;
	}

	public String getOrcnum() {
		return this.orcnum.trim();
	}

	public void setOrcnum(String orcnum) {
		this.orcnum = orcnum.trim();
	}

	public String getOrcprdcod() {
		return this.orcprdcod;
	}

	public void setOrcprdcod(String orcprdcod) {
		this.orcprdcod = orcprdcod;
	}

	public BigDecimal getOrcprdqtd() {
		return this.orcprdqtd;
	}

	public void setOrcprdqtd(BigDecimal orcprdqtd) {
		this.orcprdqtd = orcprdqtd;
	}

	public String getOrctxt() {
		return this.orctxt.trim().toUpperCase();
	}

	public void setOrctxt(String orctxt) {
		this.orctxt = orctxt.trim().toUpperCase();
	}

	public BigDecimal getOrcval() {
		return this.orcval;
	}

	public void setOrcval(BigDecimal orcval) {
		this.orcval = orcval;
	}

	public Integer getSubgrpcod() {
		return this.subgrpcod;
	}

	public void setSubgrpcod(Integer subgrpcod) {
		this.subgrpcod = subgrpcod;
	}

	public List<IntegracaoOrcprd> getOrcprd() {
		return orcprd;
	}

	public void setOrcprd(List<IntegracaoOrcprd> orcprd) {
		this.orcprd = orcprd;
	}

}