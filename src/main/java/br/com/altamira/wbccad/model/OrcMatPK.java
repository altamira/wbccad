package br.com.altamira.wbccad.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OrcMat database table.
 * 
 */
@Embeddable
public class OrcMatPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="numeroOrcamento")
	private String numeroOrcamento;

	@Column(name="orcmat_counter")
	private int counter;

	public OrcMatPK() {
	}
	public String getNumeroOrcamento() {
		return this.numeroOrcamento;
	}
	public void setNumeroOrcamento(String numeroOrcamento) {
		this.numeroOrcamento = numeroOrcamento;
	}
	public int getCounter() {
		return this.counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrcMatPK)) {
			return false;
		}
		OrcMatPK castOther = (OrcMatPK)other;
		return 
			this.numeroOrcamento.equals(castOther.numeroOrcamento)
			&& (this.counter == castOther.counter);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.numeroOrcamento.hashCode();
		hash = hash * prime + this.counter;
		
		return hash;
	}
}