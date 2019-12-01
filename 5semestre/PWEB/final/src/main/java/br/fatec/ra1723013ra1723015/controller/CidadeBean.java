package br.fatec.ra1723013ra1723015.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.fatec.ra1723013ra1723015.dao.CidadeDAO;
import br.fatec.ra1723013ra1723015.dao.CidadeDAOHibernate;
import br.fatec.ra1723013ra1723015.model.Cidade;

@ManagedBean(name = "cidadeBean")
@RequestScoped

public class CidadeBean {

	private List<SelectItem> cidadeItem;
	
	private Cidade cidade = new Cidade(); // propriedade do tipo Cidade

	private DataModel<Cidade> listaCidades;

	@SuppressWarnings("unchecked")
	public DataModel<Cidade> getListaCidades() {
		if (listaCidades == null) {
			CidadeDAO dao = new CidadeDAOHibernate();
			listaCidades = new ListDataModel<Cidade>(dao.listar());
		}
		return listaCidades;
	}

	public void setListaCidades(DataModel<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	private String confirmarSenha;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	// porta de entrada do formul�rio
	// preparar cadastro novo cidade
	public String novo() {
		this.cidade = new Cidade();
		return "publico/cidade"; // tenta exibir cidade.xhtml
	}

	public String listagem() {
		this.cidade = new Cidade();
		return "publico/listagemcidade"; // tenta exibir cidadealt.xhtml
	}

	public String salvar() {
		// facescontext adiciona as mensagens de erro que possam ser criadas
		FacesContext context = FacesContext.getCurrentInstance();
		/*String senha = this.cidade.getSenha();
		if (!senha.equals(this.confirmarSenha)) { // adicionando mensagem ao
													// context
			FacesMessage facesMessage = new FacesMessage("A senha n�o foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null; // null nao caira em nenhuma pagina, fica na mesma de
							// origem
		}*/

		// se deu certo
		CidadeRN cidadeRN = new CidadeRN();
		cidadeRN.salvar(this.cidade);
		return "cidadesucesso"; // tenta abrir pagina /public/cidadesucesso
									// nao colocou o publico mas
		// o contexto de salvar est� em /publico
	}

	public Cidade buscaIDCidade() {
		CidadeDAO dao = new CidadeDAOHibernate();
		Cidade Usu = dao.carregar(cidade.getIDCidade());
		return  Usu;
	//	return "publico/cidadealt"; // tenta exibir cidadealt.xhtml
	
	}


	public List<SelectItem> getCidades() {
		// Cria objeto de modelo Faces
		cidadeItem = new ArrayList<SelectItem>();
		// cria objeto DAO
		CidadeRN cRN = new CidadeRN();
		List<Cidade> cidade2 = cRN.listar();
		// Alimenta Modelo
		for (Cidade c : cidade2) {
			SelectItem selecao = new SelectItem(c.getIDCidade(), c.getNomeCidade());
			cidadeItem.add(selecao);
		}
		return cidadeItem;
	}
}
