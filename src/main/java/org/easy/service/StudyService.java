package org.easy.service;

import java.util.List;
import java.util.Optional;

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

	public List<Study> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}
	
	public List<Study> ListarResultMaximo(int primeiro, int maximo){
		return this.dao.ListarMaximoCom(primeiro, maximo);
	}

	public Study Criar(Study estudo) {
		return this.dao.save(estudo);
	}

	public Study BuscarPorId(Long id) {
		Optional<Study> estudo = this.dao.findById(id);

		if (estudo.get() == null)
			throw new EmptyResultDataAccessException(1);

		return estudo.get();
	}

	public void Deletar(Long id) {
		this.dao.deleteById(id);
	}
	
	public void Deletar(Study estudo) {
		this.dao.delete(estudo);
	}

	public Study Atualizar(Long id, Study estudo) {
		Study salvo = this.BuscarPorId(id);
		BeanUtils.copyProperties(estudo, salvo, "id");
		return this.Criar(salvo);
	}
	
	public Long QuantidadeTotal() {
		return this.dao.count();
	}
	
	public List<Study> BuscarPorIdPaciente(Long idpatient){
		return this.dao.findByPatientIdpatient(idpatient);
	}
	
	public Study BuscarPorStudyInstanceuid(String studyinstanceuid) {
		return this.dao.findByStudyinstanceuid(studyinstanceuid);
	}

}
