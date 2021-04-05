package beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import dao.UsuarioDAO;
import model.Usuario;

@SuppressWarnings("serial")
@Named("LoginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario != null) {
			return "login-realizado?faces-redirect=true";
			
		} else {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!"
							,"Erro no Login!"));
			return null;
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}