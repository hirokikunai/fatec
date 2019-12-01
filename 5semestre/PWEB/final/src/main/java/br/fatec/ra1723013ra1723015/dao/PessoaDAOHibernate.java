package br.fatec.ra1723013ra1723015.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.fatec.ra1723013ra1723015.model.Pessoa;
import br.fatec.ra1723013ra1723015.util.HibernateUtil;

public class PessoaDAOHibernate implements PessoaDAO {

	// obrigat�rio para classe hibernate
	// por meio da Session as operacoes do Hibernate chegam ao Banco de Dados

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Pessoa pessoa) {
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(pessoa);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel inserir a pessoa. Erro: " + e.getMessage());
		}
	}

	public void atualizar(Pessoa pessoa) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(pessoa);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar a pessoa. Erro: " + e.getMessage());
		}
	}

	public void excluir(Pessoa pessoa) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(pessoa);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir a pessoa. Erro: " + e.getMessage());
		}
	}

	// como se fosse o select, busca pela chave, se nao existir retorna null
	// se usar load ao inves de get ser� gerada uma excecao

	public Pessoa carregar(Integer codigo) {
		    Pessoa p = new Pessoa();
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria c = session.createCriteria(Pessoa.class);
			c.add(Restrictions.eq("id", codigo));
	        p = (Pessoa)c.uniqueResult();
			return p;
		}

	public List<Pessoa> listar() {
		// this.session.getSessionFactory().openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Pessoa";
		@SuppressWarnings("unchecked")
		List<Pessoa> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		} else {
			System.out.println("nao passou nada");
			return null;
		}
	}
	
}
