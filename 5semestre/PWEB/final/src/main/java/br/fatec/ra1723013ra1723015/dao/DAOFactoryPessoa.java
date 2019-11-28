package br.fatec.ra1723013ra1723015.dao;

import br.fatec.ra1723013ra1723015.util.HibernateUtil;

public class DAOFactoryPessoa {

	
	public static PessoaDAO criaPessoaDAO() {
		PessoaDAOHibernate pessoaDAO = new PessoaDAOHibernate();
			      pessoaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
			return pessoaDAO;
		}
}
