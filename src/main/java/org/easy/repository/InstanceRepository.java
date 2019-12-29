package org.easy.repository;

import java.util.List;

import org.easy.domain.Instance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstanceRepository extends JpaRepository<Instance, Long>{
	public List<Instance> findBySeriesIdseries(Long idseries);
	public Instance findBySopinstanceuid(String sopinstanceuid);
	public List<Instance> findAllByseriesStudyPatientIdpatient(Long idpatient);
}
