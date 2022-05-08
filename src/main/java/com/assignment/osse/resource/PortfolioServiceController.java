package com.assignment.osse.resource;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;

public interface PortfolioServiceController {
	public Map<String, Double> showCash(String name);
	public Map<String, Double> getMutualFund(@PathVariable String name);
}
