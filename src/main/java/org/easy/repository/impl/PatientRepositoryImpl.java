package org.easy.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.easy.domain.Patient;

public class PatientRepositoryImpl implements PatientRepositoryQuery{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Patient> ListarMaximoCom(int primeiro, int maximo) {
		try {
			TypedQuery<Patient> tiped = em.createQuery("FROM Patient patient order by datemodify", Patient.class);
			return tiped.setFirstResult(primeiro).setMaxResults(maximo).getResultList();
		} catch (Exception e) {
			System.out.println("deu erro aqui");
			e.printStackTrace();
			return null;
		}
		
	}

}
