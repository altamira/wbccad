package br.com.altamira.wbccad.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the INTEGRACAO_ORCINC database table.
 * 
 */
@Entity
@Table(name="INTEGRACAO_ORCINC")
public class IntegracaoOrcinc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORCNUM")
	private String orcnum;

	@Column(name="ACADSC")
	private String acadsc;

	@Column(name="CLICON")
	private String clicon;

	@Column(name="CLIEMA")
	private String cliema;

	@Column(name="CLIEND")
	private String cliend;

	@Column(name="CLIFAX")
	private String clifax;

	@Column(name="CLIFON")
	private String clifon;

	@Column(name="CLIMUN")
	private String climun;

	@Column(name="CLINOM")
	private String clinom;

	@Column(name="ESTCOD")
	private String estcod;

	@Column(name="ORCDAT")
	private Timestamp orcdat;

	@Column(name="REPCOD")
	private String repcod;

	@Column(name="TIPVNDCOD")
	private String tipvndcod;

	@Column(name="USRCOD")
	private String usrcod;

	public IntegracaoOrcinc() {
	}

	public String getOrcnum() {
		return this.orcnum;
	}

	public void setOrcnum(String orcnum) {
		this.orcnum = orcnum;
	}

	public String getAcadsc() {
		return this.acadsc;
	}

	public void setAcadsc(String acadsc) {
		this.acadsc = acadsc;
	}

	public String getClicon() {
		return this.clicon;
	}

	public void setClicon(String clicon) {
		this.clicon = clicon;
	}

	public String getCliema() {
		return this.cliema;
	}

	public void setCliema(String cliema) {
		this.cliema = cliema;
	}

	public String getCliend() {
		return this.cliend;
	}

	public void setCliend(String cliend) {
		this.cliend = cliend;
	}

	public String getClifax() {
		return this.clifax;
	}

	public void setClifax(String clifax) {
		this.clifax = clifax;
	}

	public String getClifon() {
		return this.clifon;
	}

	public void setClifon(String clifon) {
		this.clifon = clifon;
	}

	public String getClimun() {
		return this.climun;
	}

	public void setClimun(String climun) {
		this.climun = climun;
	}

	public String getClinom() {
		return this.clinom;
	}

	public void setClinom(String clinom) {
		this.clinom = clinom;
	}

	public String getEstcod() {
		return this.estcod;
	}

	public void setEstcod(String estcod) {
		this.estcod = estcod;
	}

	public Timestamp getOrcdat() {
		return this.orcdat;
	}

	public void setOrcdat(Timestamp orcdat) {
		this.orcdat = orcdat;
	}

	public String getRepcod() {
		return this.repcod;
	}

	public void setRepcod(String repcod) {
		this.repcod = repcod;
	}

	public String getTipvndcod() {
		return this.tipvndcod;
	}

	public void setTipvndcod(String tipvndcod) {
		this.tipvndcod = tipvndcod;
	}

	public String getUsrcod() {
		return this.usrcod;
	}

	public void setUsrcod(String usrcod) {
		this.usrcod = usrcod;
	}

}