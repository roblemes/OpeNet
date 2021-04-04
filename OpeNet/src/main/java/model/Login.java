package model;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("loginBean")
@SessionScoped
public class Login implements Serializable{
	private String usuario;
	private String senha;
	private String mensagem;

	public String VerificaLogin(){
		if (usuario.equals("admin")) {
			if (senha.equals("admin")) {mensagem = "Login realizado. Bem vindo " + usuario;
			return "login-realizado.xhtml?faces-redirect=true";}
			else{mensagem = "Erro. Senha inválida";}
		}else {mensagem = "Erro. O usuário "+usuario+" não faz parte do sistema";}
			return null;
		}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
