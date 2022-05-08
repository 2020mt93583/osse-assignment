package com.assignment.osse.repo;

import java.util.List;

public interface PortfolioRepository {
	public List<Portfolio> findAllByPortFolioName(String portfolioName);
}
