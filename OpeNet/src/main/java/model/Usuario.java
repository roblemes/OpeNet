package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="userName", nullable=false, unique=true)
	private String nomeUsuario;
	
	@Column(name="password", nullable=false, unique=false)
	private String senha;
	//private String mensagem;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	/*
	public String VerificaLogin(){
		if (usuario.equals("admin")) {
			if (senha.equals("admin")) {mensagem = "Login realizado. Bem vindo " + usuario;
			return "login-realizado.xhtml?faces-redirect=true";}
			else{mensagem = "Erro. Senha inválida";}
		}else {mensagem = "Erro. O usuário "+usuario+" não faz parte do sistema";}
			return null;
		}
		*/

}
