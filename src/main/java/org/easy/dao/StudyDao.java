package org.easy.dao;


import java.util.List;

import org.easy.domain.Study;


public interface StudyDao{

	void save(Study study);
	Study update(Study study);
	List<Study> findAll(int firstResult, int maxResults);
	Long count();
	Study findById(long idstudy);
	List<Study> findByPkTBLPatientID(Long idpatient);
	Study findByStudyInstanceUID(String studyinstanceuid);
}
