package org.easy.repository.impl;

import java.util.List;

import org.easy.domain.Patient;

public interface PatientRepositoryQuery {
	public List<Patient> ListarMaximoCom(int primeiro, int maximo);
}
