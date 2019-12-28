package org.easy.dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.easy.dao.AbstractJpaDao;
import org.easy.dao.EquipmentDao;
import org.easy.domain.Dispositive;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentDaoImpl extends AbstractJpaDao<Dispositive> implements EquipmentDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public EquipmentDaoImpl(){
		super();
		setClazz(Dispositive.class);
	}
	
	/*@Transactional
	@Override
	public void save(Equipment equipment) {
		entityManager.persist(equipment);
		entityManager.flush();
	}

	@Override
	public List<Equipment> findAll() {
		try{			
			TypedQuery<Equipment> query = entityManager.createQuery("select e FROM Equipment e", Equipment.class);			 
			return query.getResultList();
			
		}catch(Exception e){			
			return null;		
		}
	}

	@Override
	public Equipment findByID(long pkTBLEquipmentID) {
		try{			
			return entityManager.find(Equipment.class, pkTBLEquipmentID);
			
		}catch(Exception e){			
			return null;
		}
	}*/
	
	@Override 
	public Dispositive findByPkTBLSeriesID(Long idseries){
		
		try{
			return entityManager.createQuery("select e from Equipment e  where e.series.idseries LIKE :idseries", Dispositive.class)
			.setParameter("idseries", idseries)			
			.getSingleResult();
		}catch(Exception e){			
			return null;		
		}
	}

}
