package com.poly.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import com.poly.util.JpaUtil;

public class AbstractDao <T>{
	
	public static final EntityManager entityManager = JpaUtil.getEntityManager();
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize()throws Throwable{
		entityManager.close();
		super.finalize();
	}
	public T findById(Class<T> clazz, Integer ID) {
		return entityManager.find(clazz, ID);
	}
	public List<T> findAll(Class <T> clazz, boolean existIsActive){
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("Select o From ").append(entityName).append(" o");
		if (existIsActive == true ) {
			sql.append(" Where isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList(); 
	}
	
	public List<T> findAll(Class <T> clazz, boolean existIsActive, int bageNumber, int bageSize){
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("Select o From ").append(entityName).append(" o");
		if (existIsActive == true ) {
			sql.append(" Where isActive = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		query.setFirstResult((bageNumber - 1)*bageSize);
		query.setMaxResults(bageSize);
		return query.getResultList(); 
	}
	
	//select o from user o where o.username = ?0 and o.password = ?1;
	public T findOne(Class<T> clazz, String sql, Object... params) {
	    TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
	    for (int i = 0; i < params.length; i++) {
	        query.setParameter(i+1, params[i]);
	    }
	    List<T> result = query.getResultList();
	    if (result.isEmpty()) {
	        return null;
	    }
	    return result.get(0);
	}

	
	public List<T> findMany(Class<T> clazz, String sql, Object... params) {
	    TypedQuery<T> query = entityManager.createQuery(sql, clazz);
	    for (int i = 0; i < params.length; i++) {
	        query.setParameter(i + 1, params[i]);
	    }
	    return query.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql, Object... params) {
		Query query = entityManager.createNativeQuery(sql.toString());
		for (int i = 0;i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("Create succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot Insert entity"+ entity.getClass().getSimpleName()+"to DB");
			throw new RuntimeException("Failed to insert entity to database", e);
		}
	}
	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("Update succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot update entity"+ entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}
	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("Delete succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("Cannot delete entity"+ entity.getClass().getSimpleName());
			throw new RuntimeException(e);
		}
	}
	public List<T> callStored(String nameStored, Map<String, Object> params){
			StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery(nameStored);
			params.forEach((key, value)-> query.setParameter(key, value));
			return (List<T>) query.getResultList();
	}
}
