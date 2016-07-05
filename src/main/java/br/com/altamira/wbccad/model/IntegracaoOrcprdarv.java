package br.com.altamira.wbccad.model;

import java.io.Serializable;
import java.sql.Timestamp;
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
 * The persistent class for the INTEGRACAO_ORCPRDARV database table.
 * 
 */
@Entity
@Table(name="INTEGRACAO_ORCPRDARV")
@NamedQuery(name="IntegracaoOrcprdarv.findAll", query="SELECT i FROM IntegracaoOrcprdarv i")
public class IntegracaoOrcprdarv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="[idIntegracao_OrcPrdArv]")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idIntegracao;

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

	@Column(name="orcprdarv_dth")
	private Timestamp orcprdarvDth;

	@Column(name="ORCPRDARV_NIVEL")
	private Integer orcprdarvNivel;

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
	
	public IntegracaoOrcprdarv() {
	}

	public Integer getIdIntegracao() {
		return this.idIntegracao;
	}

	public void setIdIntegracao(Integer idIntegracao) {
		this.idIntegracao = idIntegracao;
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

	public Timestamp getOrcprdarvDth() {
		return this.orcprdarvDth;
	}

	public void setOrcprdarvDth(Timestamp orcprdarvDth) {
		this.orcprdarvDth = orcprdarvDth;
	}

	public Integer getOrcprdarvNivel() {
		return this.orcprdarvNivel;
	}

	public void setOrcprdarvNivel(Integer orcprdarvNivel) {
		this.orcprdarvNivel = orcprdarvNivel;
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
		return this.prdcod;
	}

	public void setPrdcod(String prdcod) {
		this.prdcod = prdcod;
	}

	public String getPrddsc() {
		return this.prddsc;
	}

	public void setPrddsc(String prddsc) {
		this.prddsc = prddsc;
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