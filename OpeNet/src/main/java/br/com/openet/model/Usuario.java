package br.com.openet.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="userName", nullable=false, unique=true)
	private String nomeUsuario;
	
	@Column(name="password", nullable=false, unique=false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="curso", nullable=false)
	private Curso curso = new Curso();
	
	@Column(name="periodo", unique=false)
	private String periodo;
	
	@Column(name="dtNasc", unique=false)
	private LocalDate dtNasc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = null;
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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
