package br.fatec.ra1723013ra1723015.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.fatec.ra1723013ra1723015.model.Cidade;
import br.fatec.ra1723013ra1723015.util.HibernateUtil;

public class CidadeDAOHibernate implements CidadeDAO {

	// obrigat�rio para classe hibernate
	// por meio da Session as operacoes do Hibernate chegam ao Banco de Dados

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Cidade cidade) {
		try {
			this.session.getSessionFactory().openSession();
			this.session.beginTransaction();
			this.session.save(cidade);
			this.session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel inserir o contato. Erro: " + e.getMessage());
		}
	}

	public void atualizar(Cidade cidade) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.update(cidade);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel alterar o contato. Erro: " + e.getMessage());
		}
	}

	public void excluir(Cidade cidade) {
		try {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			this.session.delete(cidade);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println("N�o foi poss�vel excluir o contato. Erro: " + e.getMessage());
		}
	}

	// como se fosse o select, busca pela chave, se nao existir retorna null
		// se usar load ao inves de get ser� gerada uma excecao

		public Cidade carregar(Integer codigo) {
			this.session.getSessionFactory().openSession();
			session.beginTransaction();
			return (Cidade) this.session.get(Cidade.class, codigo);
		}


		public List<Cidade> listar() {
      //  this.session.getSessionFactory().openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from Cidade";
		@SuppressWarnings("unchecked")
		List<Cidade> lista = session.createQuery(hql).list();
		if (lista != null) {
			return lista;
		}
		else {
			System.out.println("nao passou nada");
			return null;}
		}
		
	// usando hibernate query sql (parecida com sql)
	// busca outros campos

	public Cidade buscarPorLogin(String login) {
		this.session.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "select u from Cidade u where u.login=:login";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login); // parametro
		return (Cidade) consulta.uniqueResult(); // como sabe-se que login �
													// chave naturam, entao
													// chama-se uniqueresult
													// senao usava
													// consulta.list()
	}

}
