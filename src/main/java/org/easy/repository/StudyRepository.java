package org.easy.repository;

import java.util.List;

import org.easy.domain.Study;
import org.easy.repository.impl.StudyRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<Study, Long>, StudyRepositoryQuery{
	public List<Study> findByPatientIdpatient(Long idpatient);
	public Study findByStudyinstanceuid(String studyinstanceuid);

}
