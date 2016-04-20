package br.com.altamira.wbccad.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrdestPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PRDORCCODIGOPAI")
	private String prdorccodigopai;

	@Column(name="PRDORCCODIGOFILHO")
	private String prdorccodigofilho;

	public PrdestPK() {
	}

	public String getPrdorccodigopai() {
		return this.prdorccodigopai.trim().toUpperCase();
	}

	public void setPrdorccodigopai(String prdorccodigopai) {
		this.prdorccodigopai = prdorccodigopai.trim().toUpperCase();
	}

	public String getPrdorccodigofilho() {
		return this.prdorccodigofilho.trim().toUpperCase();
	}

	public void setPrdorccodigofilho(String prdorccodigofilho) {
		this.prdorccodigofilho = prdorccodigofilho.trim().toUpperCase();
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrdestPK)) {
			return false;
		}
		PrdestPK castOther = (PrdestPK)other;
		return 
			this.prdorccodigopai.equals(castOther.prdorccodigopai)
			&& (this.prdorccodigofilho == castOther.prdorccodigofilho);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prdorccodigopai.hashCode();
		hash = hash * prime + this.prdorccodigofilho.hashCode();
		
		return hash;
	}
}
