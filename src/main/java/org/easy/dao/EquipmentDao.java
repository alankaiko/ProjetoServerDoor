package org.easy.dao;

import java.util.List;

import org.easy.domain.Dispositive;

public interface EquipmentDao {

	void save(Dispositive equipment);
	Dispositive update(Dispositive equipment);
	List<Dispositive> findAll(int firstResult, int maxResults);
	Long count();
	Dispositive findById(long pkTBLEquipmentID);
	Dispositive findByPkTBLSeriesID(Long pkTBLSeriesID);
}
