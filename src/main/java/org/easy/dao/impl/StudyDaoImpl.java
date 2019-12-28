package org.easy.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.easy.dao.AbstractJpaDao;
import org.easy.dao.StudyDao;
import org.easy.domain.Study;
import org.springframework.stereotype.Repository;

@Repository
public class StudyDaoImpl extends AbstractJpaDao<Study> implements StudyDao {
	
	@PersistenceContext
	private EntityManager entityManager;	
	
	public StudyDaoImpl(){
		super();
		setClazz(Study.class);
	}
		
	@Override
	public List<Study> findByPkTBLPatientID(Long idpatient){
		System.out.println("study dao imp");
		try{
			return entityManager.createQuery("select s from Study s  where s.patient.idpatient = :idpatient", Study.class)
			.setParameter("idpatient", idpatient)			
			.getResultList();
		}catch(Exception e){			
			return null;		
		}
	}
	
	@Override 
	public Study findByStudyInstanceUID(String studyinstanceuid){
		
		try{
			return entityManager.createQuery("select s from Study s  where s.studyinstanceuid = :studyinstanceuid", Study.class)
			.setParameter("studyinstanceuid", studyinstanceuid)			
			.getSingleResult();
		}catch(Exception e){			
			return null;		
		}
	}
	
	

}
