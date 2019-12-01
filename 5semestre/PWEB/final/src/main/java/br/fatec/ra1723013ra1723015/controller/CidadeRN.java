package br.fatec.ra1723013ra1723015.controller;

import java.util.List;

import br.fatec.ra1723013ra1723015.dao.DAOFactoryCidade;
import br.fatec.ra1723013ra1723015.dao.CidadeDAO;
import br.fatec.ra1723013ra1723015.model.Cidade;

// unica camada que podera ser comunicar com a camada de dados
// entretanto nao existe qqq referencia ao hibernate mostrando o alto 
// nivel de dedesacoplamento entre camada de acesso a dados e regra de negocio
// por enquanto so cidade so cidade tera  regra de negocio
public class CidadeRN {
	// padr�o formal criar essa propriedade e a instanciacao usando DAOFactory
	private CidadeDAO cidadeDAO;

	public CidadeRN() {
		this.cidadeDAO = DAOFactoryCidade.criaCidadeDAO();
	}

	// carrega uma instancia
	public Cidade carregar(Integer codigo) {
		return this.cidadeDAO.carregar(codigo);
	}

	// se nao existe salva, caso contrario atualiza
	public void salvar(Cidade cidade) {
		Integer codigo = cidade.getIDCidade();
		if (codigo == null || codigo == 0) {
			this.cidadeDAO.salvar(cidade);
		} else {
			this.cidadeDAO.atualizar(cidade);
		}
	}

	public void excluir(Cidade cidade) {
		this.cidadeDAO.excluir(cidade);
	}	

	@SuppressWarnings("unchecked")
	public List<Cidade> listar() {
		return this.cidadeDAO.listar();
	}
}
