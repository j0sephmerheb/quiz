package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericDAO<T,I> {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.refresh(entity);
	}
	
	public void delete(T entity) {
		em.refresh(entity);
		em.remove(entity);
	}
	
	
	public abstract String getQuery() ;
	public abstract String getQueryAll() ;
	public abstract void setParameters(Map<String,Object> parameters, T criteria);
	
	
	@SuppressWarnings("unchecked")
	public List<T> search(T criteria){
		Query searchQuery = em.createQuery(getQuery());
		Map<String, Object> parameters = new LinkedHashMap<String, Object>();		
		setParameters(parameters,criteria);
		for (Map.Entry<String,Object> entry : parameters.entrySet() ) {
			searchQuery.setParameter(entry.getKey(), entry.getValue());
		}		
		return searchQuery.getResultList();		
	}
	
	public List<T> searchAll(){
		return em.createQuery(getQueryAll()).getResultList();	
	}
	
	public T getById(I id) {
		return em.find(getEntityClass(), id);
	}
	
	public abstract Class<T> getEntityClass();
	
	
}
