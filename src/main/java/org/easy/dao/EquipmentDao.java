package org.easy.dao;

import java.util.List;

import org.easy.domain.Dispositive;

public interface EquipmentDao {

	void save(Dispositive dispositive);
	Dispositive update(Dispositive dispositive);
	List<Dispositive> findAll(int firstResult, int maxResults);
	Long count();
	Dispositive findById(long iddispositive);
	Dispositive findByPkTBLSeriesID(Long idseries);
}
