package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Usuario;
import util.JPAUtil;

public class UsuarioDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("OpeNetPU");
	private EntityManager em = factory.createEntityManager();

	public Usuario getUsuario(String nomeUsuario, String senha) {

		try {

			/*
			 * MessageDigest md = MessageDigest.getInstance("SHA-256"); byte messageDigest[]
			 * = md.digest(u.getSenha().getBytes("UTF-8"));
			 * 
			 * StringBuilder sb = new StringBuilder();
			 * 
			 * for (byte b : messageDigest) { sb.append(String.format("%02X", 0xFF & b));
			 * 
			 * } String senhaHex = sb.toString();
			 */
			
			Usuario usuario = (Usuario) em
			.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	
	public void salvar(Usuario usuario){
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(usuario);
		transacao.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		String jpql = "select u from Usuario u order by userName";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Usuario> result = consulta.getResultList();
		return result;
	}
	
	public boolean inserirUsuario(Usuario usuario) {
		try {			
			em.persist(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUsuario(Usuario usuario) {
		try {
			em.remove(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
