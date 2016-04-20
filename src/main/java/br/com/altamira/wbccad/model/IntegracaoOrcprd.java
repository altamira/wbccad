package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the INTEGRACAO_ORCPRD database table.
 * 
 */
@Entity
@Table(name="INTEGRACAO_ORCPRD")
@NamedQuery(name="IntegracaoOrcprd.findAll", query="SELECT i FROM IntegracaoOrcprd i")
public class IntegracaoOrcprd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idIntegracao_OrcPrd;

	@Column(name="CORCOD")
	private String corcod;

	@Column(name="GRPCOD")
	private Integer grpcod;

	@Column(name="ORCITM")
	private Integer orcitm;

	@Column(name="ORCNUM")
	private String orcnum;

	@Column(name="ORCPES")
	private Double orcpes;

	@Column(name="ORCQTD")
	private Double orcqtd;

	@Column(name="ORCTOT")
	private Double orctot;

	@Column(name="PRDCOD")
	private String prdcod;

	@Column(name="PRDDSC")
	private String prddsc;

	@Column(name="SUBGRPCOD")
	private Integer subgrpcod;

	@Transient
	private List<IntegracaoOrcprdarv> orcprdarv;
	
	public IntegracaoOrcprd() {
	}

	public Integer getIdIntegracao_OrcPrd() {
		return this.idIntegracao_OrcPrd;
	}

	public void setIdIntegracao_OrcPrd(Integer idIntegracao_OrcPrd) {
		this.idIntegracao_OrcPrd = idIntegracao_OrcPrd;
	}

	public String getCorcod() {
		return this.corcod;
	}

	public void setCorcod(String corcod) {
		this.corcod = corcod;
	}

	public Integer getGrpcod() {
		return this.grpcod;
	}

	public void setGrpcod(Integer grpcod) {
		this.grpcod = grpcod;
	}

	public Integer getOrcitm() {
		return this.orcitm;
	}

	public void setOrcitm(Integer orcitm) {
		this.orcitm = orcitm;
	}

	public String getOrcnum() {
		return this.orcnum;
	}

	public void setOrcnum(String orcnum) {
		this.orcnum = orcnum;
	}

	public Double getOrcpes() {
		return this.orcpes;
	}

	public void setOrcpes(Double orcpes) {
		this.orcpes = orcpes;
	}

	public Double getOrcqtd() {
		return this.orcqtd;
	}

	public void setOrcqtd(Double orcqtd) {
		this.orcqtd = orcqtd;
	}

	public Double getOrctot() {
		return this.orctot;
	}

	public void setOrctot(Double orctot) {
		this.orctot = orctot;
	}

	public String getPrdcod() {
		return this.prdcod.trim();
	}

	public void setPrdcod(String prdcod) {
		this.prdcod = prdcod.trim();
	}

	public String getPrddsc() {
		return this.prddsc.trim();
	}

	public void setPrddsc(String prddsc) {
		this.prddsc = prddsc.trim();
	}

	public Integer getSubgrpcod() {
		return this.subgrpcod;
	}

	public void setSubgrpcod(Integer subgrpcod) {
		this.subgrpcod = subgrpcod;
	}

	public List<IntegracaoOrcprdarv> getOrcprdarv() {
		return orcprdarv;
	}

	public void setOrcprdarv(List<IntegracaoOrcprdarv> orcprdarv) {
		this.orcprdarv = orcprdarv;
	}

}