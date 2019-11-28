package br.fatec.ra1723013ra1723015.dao;

import java.util.List;

import br.fatec.ra1723013ra1723015.model.Pessoa;

public interface PessoaDAO {
	
	public void salvar(Pessoa pessoa);
	public void atualizar(Pessoa pessoa);	
	public void excluir(Pessoa pessoa);
	public Pessoa carregar(Integer codigo);
	//public Pessoa buscarPorPessoaOpcao(Integer codigo, String opcao);
	public List listar();

}
