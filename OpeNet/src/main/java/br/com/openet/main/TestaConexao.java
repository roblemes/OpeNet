package br.com.openet.main;

import javax.persistence.EntityManager;

import br.com.openet.util.JPAUtil;

public class TestaConexao {
	public static void main(String[] args) {
		EntityManager sessao = JPAUtil.getEntityManager();
		sessao.clear();
	}
}
