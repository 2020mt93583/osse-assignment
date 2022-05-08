package com.assignment.osse.service.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {
	
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "portfolio_name")
	private String portFolioName;
	@Column(name = "mutual_fund_name")
	private String mutualFundName;
	@Column(name = "amount_invested")
	private double amountInvested;
	
	public Portfolio(int id, String portFolioName, String mutualFundName, double amountInvested) {
		super();
		this.id = id;
		this.portFolioName = portFolioName;
		this.mutualFundName = mutualFundName;
		this.amountInvested = amountInvested;
	}

	public Portfolio() {
		
	}

	public String getPortFolioName() {
		return portFolioName;
	}

	public void setPortFolioName(String portFolioName) {
		this.portFolioName = portFolioName;
	}

	public String getMutualFundName() {
		return mutualFundName;
	}

	public void setMutualFundName(String mutualFundName) {
		this.mutualFundName = mutualFundName;
	}

	public double getAmountInvested() {
		return amountInvested;
	}

	public void setAmountInvested(double amountInvested) {
		this.amountInvested = amountInvested;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
