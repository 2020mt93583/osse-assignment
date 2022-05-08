package com.assignment.osse.service.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class MutualFund {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "fund_name")
	private String fundName;
	@Column(name = "stock_ticker")
	private String stockTicker;
	@Column(name = "stock_percentage")
	private double stockPercentage;
	
	public MutualFund() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MutualFund(int id, String fundName, String stockTicker, double stockPercentage) {
		super();
		this.id = id;
		this.fundName = fundName;
		this.stockTicker = stockTicker;
		this.stockPercentage = stockPercentage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getStockTicker() {
		return stockTicker;
	}

	public void setStockTicker(String stockTicker) {
		this.stockTicker = stockTicker;
	}

	public double getStockPercentage() {
		return stockPercentage;
	}

	public void setStockPercentage(double stockPercentage) {
		this.stockPercentage = stockPercentage;
	}
	
}
