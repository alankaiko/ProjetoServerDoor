package org.easy.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.easy.domain.Study;
import org.easy.repository.StudyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudyService {
	@Autowired
	private StudyRepository dao;
	private final Logger LOG = LoggerFactory.getLogger(StudyService.class);

	public List<Study> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public List<Study> ListarResultMaximo(int primeiro, int maximo) {
		try {
			return this.dao.ListarMaximoCom(primeiro, maximo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo ListarResultMaximo------------------ de StudyService");
			e.printStackTrace();
			return null;
		}	
	}

	public Study Criar(Study estudo) {
		try {
			return this.dao.save(estudo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Criar------------------ de StudyService");
			e.printStackTrace();
			return null;
		}		
	}

	public Study BuscarPorId(Long id) {
		Optional<Study> estudo = this.dao.findById(id);

		if (estudo.get() == null)
			throw new EmptyResultDataAccessException(1);

		return estudo.get();
	}

	public void Deletar(Long id) {
		try {
			this.dao.deleteById(id);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public void Deletar(Study estudo) {
		try {
			this.dao.delete(estudo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public Study Atualizar(Long id, Study estudo) {
		try {
			Study salvo = this.BuscarPorId(id);
			BeanUtils.copyProperties(estudo, salvo, "id");
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

	public List<Study> BuscarPorIdPaciente(Long idpatient) {
		try {
			return this.dao.findByPatientIdpatient(idpatient);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorIdPaciente------------------ de StudyService");
			e.printStackTrace();
			return null;
		}		
	}

	public Study BuscarPorStudyInstanceuid(String studyinstanceuid) {
		try {
			return this.dao.findByStudyinstanceuid(studyinstanceuid);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorStudyInstanceuid------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
		
	}

}
