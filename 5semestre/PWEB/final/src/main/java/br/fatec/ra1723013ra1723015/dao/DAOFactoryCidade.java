package br.fatec.ra1723013ra1723015.dao;

import br.fatec.ra1723013ra1723015.util.HibernateUtil;

public class DAOFactoryCidade {

	
	public static CidadeDAO criaCidadeDAO() {
	CidadeDAOHibernate cidadeDAO = new CidadeDAOHibernate();
		      cidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cidadeDAO;
	}

}
