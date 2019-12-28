package org.easy.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.easy.dao.AbstractJpaDao;
import org.easy.dao.PatientDao;
import org.easy.domain.Patient;
import org.springframework.stereotype.Repository;


@Repository
public class PatientDaoImpl extends AbstractJpaDao<Patient> implements PatientDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public PatientDaoImpl(){
		super();
		setClazz(Patient.class);
	}
	
	/*@Transactional
	@Override
	public void save(Patient patient) {
		entityManager.persist(patient);		
		entityManager.flush();
	}

	@Override
	public List<Patient> findAll() {
		
		try{			
			TypedQuery<Patient> query = entityManager.createQuery("select p FROM Patient p", Patient.class);			 
			return query.getResultList();
			
		}catch(Exception e){
			return null;		
		}
	}

	@Override
	public Patient findByID(long pkTBLPatientID) {
		try{			
			return entityManager.find(Patient.class, pkTBLPatientID);
			
		}catch(Exception e){
			return null;
		}
	}*/
	
	@Override 
	public Patient findByPatientID(String patientid){
		try{
			return entityManager.createQuery("select p from Patient p where p.patientid LIKE :patientid", Patient.class)
			.setParameter("patientid", patientid)			
			.getSingleResult();
		}catch(Exception e){			
			return null;		
		}
	}

}
