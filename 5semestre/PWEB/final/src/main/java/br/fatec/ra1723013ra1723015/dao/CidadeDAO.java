package br.fatec.ra1723013ra1723015.dao;

import java.util.List;

import br.fatec.ra1723013ra1723015.model.Cidade;

public interface CidadeDAO {
	
	public void salvar(Cidade cidade);
	public void atualizar(Cidade cidade);	
	public void excluir(Cidade cidade);
	public Cidade carregar(Integer codigo);
	public Cidade buscarPorLogin(String login);
	public List listar();

}
