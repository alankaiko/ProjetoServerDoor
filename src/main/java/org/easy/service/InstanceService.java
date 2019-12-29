package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Instance;
import org.easy.repository.InstanceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InstanceService {
	@Autowired
	private InstanceRepository dao;
	private final Logger LOG = LoggerFactory.getLogger(InstanceService.class);

	public List<Instance> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public Instance Criar(Instance instancia) {
		try {
			return this.dao.save(instancia);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Criar------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Instance BuscarPorId(Long id) {
		Optional<Instance> instancia = this.dao.findById(id);

		if (instancia.get() == null)
			throw new EmptyResultDataAccessException(1);

		return instancia.get();
	}

	public void Deletar(long id) {
		try {
			this.dao.deleteById(id);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public void Deletar(Instance instancia) {
		try {
			this.dao.delete(instancia);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public Instance Atualizar(Long id, Instance instancia) {
		try {
			Instance salvo = this.BuscarPorId(id);
			BeanUtils.copyProperties(instancia, salvo, "id");
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
			LOG.error("Erro ao executar o metodo ------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public List<Instance> BuscarPorIdSerieDaInstancia(Long idseries) {
		try {
			return this.dao.findBySeriesIdseries(idseries);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorIdSerieDaInstancia------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Instance BuscarPorInstanciaUid(String sopinstanceuid) {
		try {
			return this.dao.findBySopinstanceuid(sopinstanceuid);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorInstanciaUid------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public List<Instance> BuscarPacientesPeloEstudoSerie(Long idpatient) {
		try {
			return this.dao.findAllByseriesStudyPatientIdpatient(idpatient);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPacientesPeloEstudoSerie------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

}
