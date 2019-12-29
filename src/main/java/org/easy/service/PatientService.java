package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Patient;
import org.easy.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	@Autowired
	private PatientRepository dao;

	public List<Patient> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}
	
	public List<Patient> ListarResultMaximo(int primeiro, int maximo){
		return this.dao.ListarMaximoCom(primeiro, maximo);
	}

	public Patient Criar(Patient paciente) {
		return this.dao.save(paciente);
	}

	public Patient BuscarPorId(Long id) {
		Optional<Patient> paciente = this.dao.findById(id);

		if (paciente.get() == null)
			throw new EmptyResultDataAccessException(1);

		return paciente.get();
	}

	public void Deletar(Long id) {
		this.dao.deleteById(id);
	}
	
	public void Deletar(Patient paciente) {
		this.dao.delete(paciente);
	}

	public Patient Atualizar(Long id, Patient paciente) {
		Patient salvo = this.BuscarPorId(id);
		BeanUtils.copyProperties(paciente, salvo, "id");
		return this.Criar(salvo);
	}
	
	public Long QuantidadeTotal() {
		return this.dao.count();
	}
	
	public Patient BuscarPorPacienteId(String patientid) {
		return this.dao.findByPatientid(patientid);
	}
}
