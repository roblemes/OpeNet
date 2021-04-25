package br.com.openet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.openet.model.Curso;
import br.com.openet.util.JPAUtil;

public class CursoDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("OpeNetPU");
	private EntityManager em = factory.createEntityManager();

	public void salvar(Curso curso){
		EntityManager sessao = JPAUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(curso);
		transacao.commit();
		sessao.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> listar() {
		String jpql = "select c from Curso c order by nomeCurso";
		EntityManager sessao = JPAUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		List<Curso> result = consulta.getResultList();
		return result;
	}
	
	public boolean inserirCurso(Curso curso) {
		try {			
			em.persist(curso);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarCurso(Curso curso) {
		try {
			em.remove(curso);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
