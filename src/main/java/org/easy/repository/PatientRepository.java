package org.easy.repository;

import org.easy.domain.Patient;
import org.easy.repository.impl.PatientRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, PatientRepositoryQuery{
	public Patient findByPatientid(String patientid);
}
