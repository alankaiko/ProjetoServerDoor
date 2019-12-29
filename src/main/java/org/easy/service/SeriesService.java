package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Series;
import org.easy.repository.SeriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {
	@Autowired
	private SeriesRepository dao;
	private final Logger LOG = LoggerFactory.getLogger(SeriesService.class);

	public List<Series> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public List<Series> ListarResultMaximo(int primeiro, int maximo) {
		try {
			return this.dao.ListarMaximoCom(primeiro, maximo);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo ListarResultMaximo------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Series Criar(Series serie) {
		try {
			return this.dao.save(serie);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Criar------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Series BuscarPorId(Long id) {
		Optional<Series> serie = this.dao.findById(id);

		if (serie.get() == null)
			throw new EmptyResultDataAccessException(1);

		return serie.get();
	}

	public void Deletar(Long id) {
		try {
			this.dao.deleteById(id);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public void Deletar(Series serie) {
		try {
			this.dao.delete(serie);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo Deletar------------------ de StudyService");
			e.printStackTrace();
		}
	}

	public Series Atualizar(Long id, Series serie) {
		try {
			Series salvo = this.BuscarPorId(id);
			BeanUtils.copyProperties(serie, salvo, "id");
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

	public List<Series> BuscarPorIdEstudo(Long idstudy) {
		try {
			return this.dao.findByStudyIdstudy(idstudy);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo ------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Series BuscarPorSeriesinstanceuid(String seriesinstanceuid) {
		try {
			return this.dao.findBySeriesinstanceuid(seriesinstanceuid);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorSeriesinstanceuid------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public Series BuscarPorSeriesInstanceENumber(String seriesinstanceuid, Integer numero) {
		try {
			return this.dao.BuscarPorSeriesinstanceuid(seriesinstanceuid, numero);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarPorSeriesInstanceENumber------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

	public List<Series> BuscarTodosEstudosPorPacietne(Long idpatient) {
		try {
			return this.dao.findAllByStudyPatientIdpatient(idpatient);
		} catch (Exception e) {
			LOG.error("Erro ao executar o metodo BuscarTodosEstudosPorPacietne------------------ de StudyService");
			e.printStackTrace();
			return null;
		}
	}

}
