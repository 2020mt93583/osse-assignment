package com.assignment.osse.resource.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.osse.repo.PortfolioRepository;
import com.assignment.osse.service.dto.MutualFund;
import com.assignment.osse.service.dto.Portfolio;
import com.assignment.osse.service.dto.Stock;

public class PortfolioServiceControllerImpl {
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
		
		@GetMapping("/mutualfund/{name}")
		public Map<String, Double> getMutualFund(@PathVariable String name) {
			List<MutualFund> fund = new ArrayList<>();
			Map<String, Double> stocks = new HashMap<>();
			fund = repo.findAllByFundName(name);
			fund.forEach(f -> {
				Map<String, String> uriVariables = new HashMap<>();
				uriVariables.put("ticker", f.getStockTicker());
				ResponseEntity<Stock> responseEntity = new RestTemplate()
						.getForEntity("http://localhost:8002/stock/{ticker}", Stock.class, uriVariables);
				Stock s = responseEntity.getBody();
				stocks.put(f.getStockTicker(), f.getStockPercentage()/(s.getStockPrice()*100));
			});
			return stocks;
		}
}
