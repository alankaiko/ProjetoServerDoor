package org.easy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.easy.dao.AbstractJpaDao;
import org.easy.dao.InstanceDao;
import org.easy.domain.Instance;
import org.springframework.stereotype.Repository;

@Repository
public class InstanceDaoImpl extends AbstractJpaDao<Instance> implements InstanceDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public InstanceDaoImpl(){
		super();
		setClazz(Instance.class);
	}
		
	@Override
	public List<Instance> findByPkTBLSeriesID(Long idseries){
		
		try{
			return entityManager.createQuery("select i from Instance i  where i.series.idseries = :idseries", Instance.class)
			.setParameter("idseries", idseries)			
			.getResultList();
		}catch(Exception e){			
			return null;		
		}
	}
	
	@Override 
	public Instance findBySopInstanceUID(String sopinstanceuid){
		
		try{
			return entityManager.createQuery("select i from Instance i  where i.sopinstanceuid = :sopinstanceuid", Instance.class)
			.setParameter("sopinstanceuid", sopinstanceuid)
			.getSingleResult();
		}catch(Exception e){			
			return null;		
		}
	}
	
	@Override 
	public List<Instance> findAllByPkTBLPatientID(Long idpatient){
		System.out.println("instance vindo entao");
		try{
			
			return entityManager.createQuery("select i from Instance i LEFT OUTER JOIN i.series s " +
					"LEFT OUTER JOIN i.series.study st " +
					"LEFT OUTER JOIN i.series.study.patient p " +
					"where p.idpatient = :idpatient", Instance.class)
					.setParameter("idpatient", idpatient)	
					.getResultList();
			
		}catch(Exception e){
			return null;
		}
	}

}
