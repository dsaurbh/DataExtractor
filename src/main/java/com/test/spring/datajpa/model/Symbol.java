package com.test.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Symbol {
	@JsonProperty("dateListed")
	public String getDateListed() {
		return this.dateListed;
	}

	public void setDateListed(String dateListed) {
		this.dateListed = dateListed;
	}

	String dateListed;

	@JsonProperty("displayName")
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	String displayName;

	@JsonProperty("priceAsk")
	public double getPriceAsk() {
		return this.priceAsk;
	}

	public void setPriceAsk(double priceAsk) {
		this.priceAsk = priceAsk;
	}

	double priceAsk;

	@JsonProperty("priceBid")
	public double getPriceBid() {
		return this.priceBid;
	}

	public void setPriceBid(double priceBid) {
		this.priceBid = priceBid;
	}

	double priceBid;

	@JsonProperty("priceChange")
	public double getPriceChange() {
		return this.priceChange;
	}

	public void setPriceChange(double priceChange) {
		this.priceChange = priceChange;
	}

	double priceChange;

	@JsonProperty("priceChangePercent")
	public double getPriceChangePercent() {
		return this.priceChangePercent;
	}

	public void setPriceChangePercent(double priceChangePercent) {
		this.priceChangePercent = priceChangePercent;
	}

	double priceChangePercent;

	@JsonProperty("priceLast")
	public double getPriceLast() {
		return this.priceLast;
	}

	public void setPriceLast(double priceLast) {
		this.priceLast = priceLast;
	}

	double priceLast;

	@JsonProperty("sector")
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	String sector;

	@JsonProperty("industryGroup")
	public String getIndustryGroup() {
		return this.industryGroup;
	}

	public void setIndustryGroup(String industryGroup) {
		this.industryGroup = industryGroup;
	}

	String industryGroup;

	@JsonProperty("securityType")
	public String getSecurityType() {
		return this.securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	String securityType;

	@JsonProperty("symbol")
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	String symbol;

	@JsonProperty("volume")
	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	String volume;

	@JsonProperty("xid")
	public String getXid() {
		return this.xid;
	}

	public void setXid(String xid) {
		this.xid = xid;
	}

	String xid;

	@JsonProperty("marketCap")
	public String getMarketCap() {
		return this.marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	String marketCap;

	@JsonProperty("statusCode")
	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	String statusCode;

}
