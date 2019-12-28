package org.easy.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.easy.dao.AbstractJpaDao;
import org.easy.dao.SeriesDao;
import org.easy.domain.Series;
import org.springframework.stereotype.Repository;


@Repository
public class SeriesDaoImpl extends AbstractJpaDao<Series>   implements SeriesDao {	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public SeriesDaoImpl(){
		super();
		setClazz(Series.class);
	}
		
	@Override
	public List<Series> findByPkTBLStudyID(Long idstudy){
		
		try{
			return entityManager.createQuery("select sr from Series sr  where sr.study.idstudy = :idstudy", Series.class)
			.setParameter("idstudy", idstudy)			
			.getResultList();
		}catch(Exception e){			
			return null;		
		}
	}	

	@Override 
	public synchronized Series findBySeriesInstanceUID(String seriesinstanceuid){
		
		try{
			return entityManager.createQuery("select sr from Series sr  where sr.seriesinstanceuid = :seriesinstanceuid", Series.class)
			.setParameter("seriesinstanceuid", seriesinstanceuid)			
			.getSingleResult();
		}catch(Exception e){			
			return null;		
		}
	}
	
	@Override 
	public Series findBySeriesInstanceUID(String seriesinstanceuid, Integer seriesnumber){
		
		try{
			return entityManager.createQuery("select sr from Series sr  where sr.seriesnumber = :seriesnumber AND sr.seriesinstanceuid = :seriesinstanceuid", Series.class)
			.setParameter("seriesinstanceuid", seriesinstanceuid)
			.setParameter("seriesnumber", seriesnumber)
			.getSingleResult();
		}catch(Exception e){			
			return null;		
		}
	}
	
	@Override 
	public List<Series> findAllByPkTBLPatientID(Long idpatient){
		
		try{
			
			return entityManager.createQuery("select sr from Series sr LEFT OUTER JOIN sr.study st " +
					"LEFT OUTER JOIN sr.study.patient p " +
					"where p.idpatient = :idpatient", Series.class)
					.setParameter("idpatient", idpatient)	
					.getResultList();
			
		}catch(Exception e){
			return null;
		}
	}
	
	
}
