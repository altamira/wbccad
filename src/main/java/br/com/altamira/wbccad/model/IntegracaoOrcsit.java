package br.com.altamira.wbccad.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the INTEGRACAO_ORCSIT database table.
 * 
 */
@Entity
@Table(name="INTEGRACAO_ORCSIT")
@NamedQuery(name="IntegracaoOrcsit.findAll", query="SELECT i FROM IntegracaoOrcsit i")
public class IntegracaoOrcsit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idIntegracao_OrcSit;

	@Column(name="ORCALTDTH")
	private Timestamp orcaltdth;

	@Column(name="ORCNUM")
	private String orcnum;

	@Column(name="SITCOD")
	private Integer sitcod;

	public IntegracaoOrcsit() {
	}

	public Integer getIdIntegracao_OrcSit() {
		return this.idIntegracao_OrcSit;
	}

	public void setIdIntegracao_OrcSit(Integer idIntegracao_OrcSit) {
		this.idIntegracao_OrcSit = idIntegracao_OrcSit;
	}

	public Timestamp getOrcaltdth() {
		return this.orcaltdth;
	}

	public void setOrcaltdth(Timestamp orcaltdth) {
		this.orcaltdth = orcaltdth;
	}

	public String getOrcnum() {
		return this.orcnum;
	}

	public void setOrcnum(String orcnum) {
		this.orcnum = orcnum;
	}

	public Integer getSitcod() {
		return this.sitcod;
	}

	public void setSitcod(Integer sitcod) {
		this.sitcod = sitcod;
	}

}