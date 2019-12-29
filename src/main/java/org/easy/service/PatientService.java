package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Patient;
import org.easy.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	@Autowired
	private PatientRepository dao;
	private final Logger LOG = LoggerFactory.getLogger(PatientService.class);

	public List<Patient> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public List<Patient> ListarResultMaximo(int primeiro, int maximo) {
		try {
			return this.dao.ListarMaximoCom(primeiro, maximo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo ListarResultMaximo------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Patient Criar(Patient paciente) {
		try {
			return this.dao.save(paciente);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Criar------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Patient BuscarPorId(Long id) {
		Optional<Patient> paciente = this.dao.findById(id);

		if (paciente.get() == null)
			throw new EmptyResultDataAccessException(1);

		return paciente.get();
	}

	public void Deletar(Long id) {
		try {
			this.dao.deleteById(id);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public void Deletar(Patient paciente) {
		try {
			this.dao.delete(paciente);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public Patient Atualizar(Long id, Patient paciente) {
		try {
			Patient salvo = this.BuscarPorId(id);
			BeanUtils.copyProperties(paciente, salvo, "id");
			return this.Criar(salvo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Atualizar------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Long QuantidadeTotal() {
		try {
			return this.dao.count();
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo QuantidadeTotal------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Patient BuscarPorPacienteId(String patientid) {
		try {
			return this.dao.findByPatientid(patientid);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorPacienteId------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}
}
