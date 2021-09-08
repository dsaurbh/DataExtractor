package com.test.spring.datajpa.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Announcement {
	@JsonProperty("announcementTypes")
	public List<String> getAnnouncementTypes() {
		return this.announcementTypes;
	}

	public void setAnnouncementTypes(List<String> announcementTypes) {
		this.announcementTypes = announcementTypes;
	}

	List<String> announcementTypes;

	@JsonProperty("companies")
	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	List<Company> companies;

	@JsonProperty("companyInfo")
	public List<CompanyInfo> getCompanyInfo() {
		return this.companyInfo;
	}

	public void setCompanyInfo(List<CompanyInfo> companyInfo) {
		this.companyInfo = companyInfo;
	}

	List<CompanyInfo> companyInfo;

	@JsonProperty("date")
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	Date date;

	@JsonProperty("documentKey")
	public String getDocumentKey() {
		return this.documentKey;
	}

	public void setDocumentKey(String documentKey) {
		this.documentKey = documentKey;
	}

	String documentKey;

	@JsonProperty("fileSize")
	public String getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	String fileSize;

	@JsonProperty("headline")
	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	String headline;

	@JsonProperty("isPriceSensitive")
	public boolean getIsPriceSensitive() {
		return this.isPriceSensitive;
	}

	public void setIsPriceSensitive(boolean isPriceSensitive) {
		this.isPriceSensitive = isPriceSensitive;
	}

	boolean isPriceSensitive;

	@JsonProperty("symbol")
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	String symbol;

	@JsonProperty("symbolsSecondary")
	public List<String> getSymbolsSecondary() {
		return this.symbolsSecondary;
	}

	public void setSymbolsSecondary(List<String> symbolsSecondary) {
		this.symbolsSecondary = symbolsSecondary;
	}

	List<String> symbolsSecondary;

	@JsonProperty("url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Symbol getSymbolData() {
		return symbolData;
	}

	public void setSymbolData(Symbol symbolData) {
		this.symbolData = symbolData;
	}

	String url;
	private Symbol symbolData;

}
