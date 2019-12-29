package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Dispositive;
import org.easy.repository.DispositiveRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DispositiveService {

	@Autowired
	private DispositiveRepository dao;
	private final Logger LOG = LoggerFactory.getLogger(DispositiveService.class);

	public List<Dispositive> ListarTodos() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public Dispositive Criar(Dispositive dispositivo) {
		try {
			return this.dao.save(dispositivo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Criar------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Dispositive BuscarPorId(Long id) {
		Optional<Dispositive> dispositivo = this.dao.findById(id);

		if (dispositivo.get() == null)
			throw new EmptyResultDataAccessException(1);

		return dispositivo.get();
	}

	public void Deletar(Long id) {
		try {
			this.dao.deleteById(id);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public void Deletar(Dispositive dispositivo) {
		try {
			this.dao.delete(dispositivo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public Dispositive Atualizar(Long id, Dispositive dispositivo) {
		try {
			Dispositive salvo = this.BuscarPorId(id);
			BeanUtils.copyProperties(dispositivo, salvo, "id");
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

	public Dispositive BuscarPorSerieEquipamento(Long idseries) {
		try {
			return this.dao.findBySeriesIdseries(idseries);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorSerieEquipamento------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

}
