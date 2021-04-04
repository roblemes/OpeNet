package main;

import javax.persistence.EntityManager;

import util.JPAUtil;

public class TestaConexao {
	public static void main(String[] args) {
		EntityManager sessao = JPAUtil.getEntityManager();
		sessao.clear();
	}
}
