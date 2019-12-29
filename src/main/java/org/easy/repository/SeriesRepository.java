package org.easy.repository;

import java.util.List;

import org.easy.domain.Series;
import org.easy.repository.impl.SeriesRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long>, SeriesRepositoryQuery{
	public List<Series> findByStudyIdstudy(Long idstudy);
	public Series findBySeriesinstanceuid(String seriesinstanceuid);
	public List<Series> findAllByStudyPatientIdpatient(Long idpatient);
}
