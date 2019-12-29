package org.easy.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.easy.domain.Series;

public class SeriesRepositoryImpl implements SeriesRepositoryQuery{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Series> ListarMaximoCom(int primeiro, int maximo) {
		TypedQuery<Series> tiped = em.createQuery("SELECT FROM Series serie order by datemodify", Series.class);
		return tiped.setFirstResult(primeiro).setMaxResults(maximo).getResultList();
	}

	@Override
	public Series BuscarPorSeriesinstanceuid(String seriesinstanceuid, Integer seriesnumber) {
		try {
			return this.em.createQuery("SELECT serie FROM Series serie WHERE serie.seriesnumber = :seriesnumber AND serie.seriesinstanceuid = :seriesinstanceuid", Series.class)
					.setParameter("seriesnumber", seriesnumber)
					.setParameter("seriesinstanceuid", seriesinstanceuid)
					.getSingleResult();
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
