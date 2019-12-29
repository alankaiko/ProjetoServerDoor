package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Series;
import org.easy.repository.SeriesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {
	@Autowired
	private SeriesRepository dao;

	public List<Series> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public List<Series> ListarResultMaximo(int primeiro, int maximo){
		return this.dao.ListarMaximoCom(primeiro, maximo);
	}
	
	public Series Criar(Series serie) {
		return this.dao.save(serie);
	}

	public Series BuscarPorId(Long id) {
		Optional<Series> serie = this.dao.findById(id);

		if (serie.get() == null)
			throw new EmptyResultDataAccessException(1);

		return serie.get();
	}

	public void Deletar(Long id) {
		this.dao.deleteById(id);
	}
	
	public void Deletar(Series serie) {
		this.dao.delete(serie);
	}

	public Series Atualizar(Long id, Series serie) {
		Series salvo = this.BuscarPorId(id);
		BeanUtils.copyProperties(serie, salvo, "id");
		return this.Criar(salvo);
	}
	
	public Long QuantidadeTotal() {
		return this.dao.count();
	}
	
	public List<Series> BuscarPorIdEstudo(Long idstudy){
		return this.dao.findByStudyIdstudy(idstudy);
	}
	
	public Series BuscarPorSeriesinstanceuid(String seriesinstanceuid) {
		return this.dao.findBySeriesinstanceuid(seriesinstanceuid);
	}
	
	public Series BuscarPorSeriesInstanceENumber(String seriesinstanceuid, Integer numero) {
		return this.dao.BuscarPorSeriesinstanceuid(seriesinstanceuid, numero);
	}

	public List<Series> BuscarTodosEstudosPorPacietne(Long idpatient){
		return this.dao.findAllByStudyPatientIdpatient(idpatient);
	}

}














