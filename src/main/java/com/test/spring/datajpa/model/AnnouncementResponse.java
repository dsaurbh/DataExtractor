package com.test.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnnouncementResponse {
	@JsonProperty("data")
	public Data getData() {
		return this.data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	Data data;
}
