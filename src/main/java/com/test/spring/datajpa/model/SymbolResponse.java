package com.test.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SymbolResponse {
	@JsonProperty("data")
	public Symbol getData() {
		return this.data;
	}

	public void setData(Symbol data) {
		this.data = data;
	}

	Symbol data;
}
