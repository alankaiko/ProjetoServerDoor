package org.easy.repository.impl;

import java.util.List;

import org.easy.domain.Study;

public interface StudyRepositoryQuery {
	public List<Study> ListarMaximoCom(int primeiro, int maximo);
}
