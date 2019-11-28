package br.fatec.ra1723013ra1723015.controller;

import java.util.List;

import br.fatec.ra1723013ra1723015.dao.DAOFactoryPessoa;
import br.fatec.ra1723013ra1723015.dao.PessoaDAO;
import br.fatec.ra1723013ra1723015.model.Pessoa;

// unica camada que podera ser comunicar com a camada de dados
// entretanto nao existe qqq referencia ao hibernate mostrando o alto 
// nivel de dedesacoplamento entre camada de acesso a dados e regra de negocio
// por enquanto so pessoa so pessoa tera  regra de negocio
public class PessoaRN {
	// padr�o formal criar essa propriedade e a instanciacao usando DAOFactory
	private PessoaDAO pessoaDAO;

	public PessoaRN() {
		this.pessoaDAO = DAOFactoryPessoa.criaPessoaDAO();
	}

	// carrega uma instancia
	public Pessoa carregar(Integer codigo, String opcao) {
		return this.pessoaDAO.carregar(codigo);
	}

	  // faz repasse metodo na classe DAO
	public Pessoa buscarPorCodigoOpcao(Integer codigo, String opcao) {
		return this.pessoaDAO.buscarPorPessoaOpcao(codigo,opcao);
	}

	// se nao existe salva, caso contrario atualiza
	public void salvar(Pessoa pessoa) {
		Integer id = pessoa.getIDPessoa();
		if (id == null || id == 0) {
			this.pessoaDAO.salvar(pessoa);
		} else {
			this.pessoaDAO.atualizar(pessoa);
		}
	}

	public void excluir(Pessoa pessoa) {
		this.pessoaDAO.excluir(pessoa);
	}	

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		return this.pessoaDAO.listar();
	}
}
