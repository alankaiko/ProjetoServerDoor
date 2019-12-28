package org.easy.dao;


import java.util.List;

import org.easy.domain.Series;



public interface SeriesDao  {

	void save(Series series);
	Series update(Series series);
	List<Series> findAll(int firstResult, int maxResults);
	Long count();
	Series findById(long idseries);
	List<Series> findByPkTBLStudyID(Long idstudy);
	Series findBySeriesInstanceUID(String seriesinstanceuid);
	Series findBySeriesInstanceUID(String seriesinstanceuid, Integer seriesnumber);
	List<Series> findAllByPkTBLPatientID(Long idpatient);
}
