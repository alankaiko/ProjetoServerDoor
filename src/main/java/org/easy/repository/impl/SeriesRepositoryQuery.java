package org.easy.repository.impl;

import java.util.List;

import org.easy.domain.Series;

public interface SeriesRepositoryQuery {
	public List<Series> ListarMaximoCom(int primeiro, int maximo);
	public Series BuscarPorSeriesinstanceuid(String seriesinstanceuid, Integer seriesnumber);
}
