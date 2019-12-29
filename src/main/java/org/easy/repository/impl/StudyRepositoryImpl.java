package org.easy.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.easy.domain.Study;

public class StudyRepositoryImpl implements StudyRepositoryQuery{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Study> ListarMaximoCom(int primeiro, int maximo) {
		TypedQuery<Study> tiped = em.createQuery("SELECT FROM Study study order by datemodify", Study.class);
		return tiped.setFirstResult(primeiro).setMaxResults(maximo).getResultList();
	}

}
