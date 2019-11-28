package br.fatec.ra1723013ra1723015.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fatec.ra1723013ra1723015.dao.PessoaDAO;
import br.fatec.ra1723013ra1723015.dao.PessoaDAOHibernate;
import br.fatec.ra1723013ra1723015.model.Pessoa;

@ManagedBean(name = "pessoaBean")
@RequestScoped

public class PessoaBean {

	private Pessoa pessoa = new Pessoa(); // propriedade do tipo Pessoa

	private DataModel<Pessoa> listaPermissoes;

	@SuppressWarnings("unchecked")
	public DataModel<Pessoa> getlistaPermissoes() {
		if (listaPermissoes == null) {
			PessoaDAO dao = new PessoaDAOHibernate();
			listaPermissoes = new ListDataModel<Pessoa>(dao.listar());
		}
		return listaPermissoes;
	}

	public void setlistaPermissoes(DataModel<Pessoa> listaPermissoes) {
		this.listaPermissoes = listaPermissoes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

		// porta de entrada do formul�rio
	// preparar cadastro novo pessoa
	public String novo() {
	this.pessoa = new Pessoa();
	/**	this.pessoa.setInserir(true);
		this.pessoa.setAlterar(true);
		this.pessoa.setExcluir(true);
		this.pessoa.setVisualizar(true);**/
		
		
		return "publico/pessoa"; // tenta exibir pessoa.xhtml
	}

	public String listagem() {
		this.pessoa = new Pessoa();
		return "publico/listagempessoa"; // tenta exibir pessoaalt.xhtml
	}

	public String salvar() {
		// se deu certo
		PessoaRN pessoaRN = new PessoaRN();
		pessoaRN.salvar(this.pessoa);
		return "pessoasucesso"; // tenta abrir pagina /public/pessoasucesso
									// nao colocou o publico mas
		// o contexto de salvar est� em /publico
	}

	public Pessoa buscaPorLogin() {
		PessoaDAO dao = new PessoaDAOHibernate();
		Pessoa Permi = dao.carregar(pessoa.getIDPessoa());
		return  Permi;
	//	return "publico/pessoaalt"; // tenta exibir pessoaalt.xhtml
	
	}


}
