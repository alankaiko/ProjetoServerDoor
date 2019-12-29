package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Dispositive;
import org.easy.repository.DispositiveRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DispositiveService {

	@Autowired
	private DispositiveRepository dao;

	public List<Dispositive> ListarTodos() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public Dispositive Criar(Dispositive dispositivo) {
		return this.dao.save(dispositivo);
	}

	public Dispositive BuscarPorId(Long id) {
		Optional<Dispositive> dispositivo = this.dao.findById(id);

		if (dispositivo.get() == null)
			throw new EmptyResultDataAccessException(1);
		
		return dispositivo.get();
	}

	public void Deletar(Long id) {
		this.dao.deleteById(id);
	}

	public void Deletar(Dispositive dispositivo) {
		this.dao.delete(dispositivo);
	}

	public Dispositive Atualizar(Long id, Dispositive dispositivo) {
		Dispositive salvo = this.BuscarPorId(id);
		BeanUtils.copyProperties(dispositivo, salvo, "id");
		return this.Criar(salvo);
	}
	
	public Long QuantidadeTotal() {
		return this.dao.count();
	}
	
	

}
