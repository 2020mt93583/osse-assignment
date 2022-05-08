package com.assignment.osse.service.dto;

public class Stock {



	private int id;
	private String ticker;
	private double stockPrice;
	
	public Stock() {
		
	}

	public Stock(int id, String ticker, double stockPrice) {
		super();
		this.id = id;
		this.ticker = ticker;
		this.stockPrice = stockPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
}
