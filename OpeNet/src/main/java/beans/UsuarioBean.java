package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import dao.UsuarioDAO;
import model.Usuario;

@SuppressWarnings("serial")
@Named("UsuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;
	private List<Usuario> usuarios;
	
	private UsuarioDAO usuarioDAO;

	@PostConstruct
	public void init() {
		usuarioDAO = new UsuarioDAO();
		
		usuario = new Usuario();
		usuarios = usuarioDAO.listar();
	}

	public void salvar() {
		usuarioDAO.salvar(usuario);
		
		usuario = new Usuario();
		usuarios = usuarioDAO.listar();
		
		/*
		 * if (usuario != null) { FacesContext.getCurrentInstance().addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Cadastro realizado"));
		 * } else { FacesContext.getCurrentInstance().addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Cadastro nao realizado"));
		 * }
		 */
	}
	
	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario != null) {
			return "login-realizado?faces-redirect=true";

		} else {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		}
	}

	
	public String telaCadastro() {
		return "cadastrar?faces-redirect=true";
	}
	
	public void listar() {
		usuarios = usuarioDAO.listar();
	}

	public String mensagem() {
		return "Login realizado. Bem vindo, " + this.usuario.getNomeUsuario() + "!";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}