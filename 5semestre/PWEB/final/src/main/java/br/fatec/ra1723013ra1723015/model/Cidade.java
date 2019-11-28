package br.fatec.ra1723013ra1723015.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "cidade")
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Integer IDCidade;
	// informacao que nao pode repetir, mas nao sao aconselhaveis serem chaves
	// primarias sao chaves naturais
	@org.hibernate.annotations.NaturalId
	private String nomeCidade;
	private String UFCidade;
	
	public Integer getIDCidade() {
		return IDCidade;
	}
	public void setIDCidade(Integer iDCidade) {
		IDCidade = iDCidade;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getUFCidade() {
		return UFCidade;
	}
	public void setUFCidade(String uFCidade) {
		UFCidade = uFCidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDCidade == null) ? 0 : IDCidade.hashCode());
		result = prime * result + ((UFCidade == null) ? 0 : UFCidade.hashCode());
		result = prime * result + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (IDCidade == null) {
			if (other.IDCidade != null)
				return false;
		} else if (!IDCidade.equals(other.IDCidade))
			return false;
		if (UFCidade == null) {
			if (other.UFCidade != null)
				return false;
		} else if (!UFCidade.equals(other.UFCidade))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	}
	

}
