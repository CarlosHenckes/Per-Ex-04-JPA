package br.com.fiap.dao;

import java.util.List;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;

import br.com.fiap.dao.interf.IDAO;

public class DAO<T> implements IDAO<T> {
	
	private final Class<T> classe;
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	public DAO(EntityManager em){
		this.classe = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.em = em;
	}

	@Override
	public void insert(T model) throws Exception {
		em.persist(model);
		em.close();
	}

	@Override
	public void update(T model) throws Exception {
		em.merge(model);
		em.close();
	}

	@Override
	public void remove(T model) throws Exception {
		em.remove(em.merge(model));
		em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() {
		return em.createQuery("from "+ classe.getSimpleName() +" c").getResultList();
	}

}
