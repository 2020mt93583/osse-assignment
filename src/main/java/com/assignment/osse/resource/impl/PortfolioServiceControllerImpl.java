package com.assignment.osse.resource.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

public class PortfolioServiceControllerImpl {

	@RestController
	public class PortfolioserviceController {

		@Autowired
		private PortfolioRepository repo;
		
		@GetMapping("/portfolio/{name}")
		public Map<String, Double> showCash(@PathVariable String name) 
		{
			List<Portfolio> portfolio = new ArrayList<Portfolio>();
			Map<String, Double> stocks = new HashMap<>();
			portfolio = repo.findAllByPortFolioName(name);
			portfolio.forEach(p -> {
				Map<String, String> uriVariables = new HashMap<>();
				uriVariables.put("name", p.getMutualFundName());
				ResponseEntity<HashMap> responseEntity = new RestTemplate()
						.getForEntity("http://localhost:8002/mutualfund/{name}", HashMap.class, uriVariables);
				responseEntity.getBody().forEach((x, y) -> stocks.put((String) x, p.getAmountInvested() * (double) y));
			});
			return stocks;
		}
	}
}
