package org.easy.service;

import java.util.List;
import java.util.Optional;

import org.easy.domain.Instance;
import org.easy.repository.InstanceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class InstanceService {
	@Autowired
	private InstanceRepository dao;

	public List<Instance> Listar() {
		return this.dao.findAll(Sort.by(Sort.Direction.ASC, "datemodify"));
	}

	public Instance Criar(Instance instancia) {
		return this.dao.save(instancia);
	}

	public Instance BuscarPorId(Long id) {
		Optional<Instance> instancia = this.dao.findById(id);

		if (instancia.get() == null)
			throw new EmptyResultDataAccessException(1);

		return instancia.get();
	}

	public void Deletar(long id) {
		this.dao.deleteById(id);
	}
	
	public void Deletar(Instance instancia) {
		this.dao.delete(instancia);
	}

	public Instance Atualizar(Long id, Instance instancia) {
		Instance salvo = this.BuscarPorId(id);
		BeanUtils.copyProperties(instancia, salvo, "id");
		return this.Criar(salvo);
	}
	
	public Long QuantidadeTotal() {
		return this.dao.count();
	}
}
