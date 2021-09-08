package com.test.spring.datajpa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company{
    @JsonProperty("symbolDisplay") 
    public String getSymbolDisplay() { 
		 return this.symbolDisplay; } 
    public void setSymbolDisplay(String symbolDisplay) { 
		 this.symbolDisplay = symbolDisplay; } 
    String symbolDisplay;
}

