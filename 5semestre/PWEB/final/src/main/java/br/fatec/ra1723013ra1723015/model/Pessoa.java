package br.fatec.ra1723013ra1723015.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IDPessoa;
	private String nomePessoa;
	@org.hibernate.annotations.NaturalId
	private String CPFPessoa;
	private String enderecoPessoa;
	
	@ManyToOne
	@JoinColumn(name="cidade_IDCidade", referencedColumnName="IDCidade",nullable=false, insertable=false, updatable=false)
	private Cidade cidade;
	
	private Integer cidade_IDCidade;

	public Integer getIDPessoa() {
		return IDPessoa;
	}

	public void setIDPessoa(Integer iDPessoa) {
		IDPessoa = iDPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCPFPessoa() {
		return CPFPessoa;
	}

	public void setCPFPessoa(String cPFPessoa) {
		CPFPessoa = cPFPessoa;
	}

	public String getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(String enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Integer getCidade_IDCidade() {
		return cidade_IDCidade;
	}

	public void setCidade_IDCidade(Integer cidade_IDCidade) {
		this.cidade_IDCidade = cidade_IDCidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPFPessoa == null) ? 0 : CPFPessoa.hashCode());
		result = prime * result + ((IDPessoa == null) ? 0 : IDPessoa.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cidade_IDCidade == null) ? 0 : cidade_IDCidade.hashCode());
		result = prime * result + ((enderecoPessoa == null) ? 0 : enderecoPessoa.hashCode());
		result = prime * result + ((nomePessoa == null) ? 0 : nomePessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (CPFPessoa == null) {
			if (other.CPFPessoa != null)
				return false;
		} else if (!CPFPessoa.equals(other.CPFPessoa))
			return false;
		if (IDPessoa == null) {
			if (other.IDPessoa != null)
				return false;
		} else if (!IDPessoa.equals(other.IDPessoa))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cidade_IDCidade == null) {
			if (other.cidade_IDCidade != null)
				return false;
		} else if (!cidade_IDCidade.equals(other.cidade_IDCidade))
			return false;
		if (enderecoPessoa == null) {
			if (other.enderecoPessoa != null)
				return false;
		} else if (!enderecoPessoa.equals(other.enderecoPessoa))
			return false;
		if (nomePessoa == null) {
			if (other.nomePessoa != null)
				return false;
		} else if (!nomePessoa.equals(other.nomePessoa))
			return false;
		return true;
	}
	
	
	
	
}
