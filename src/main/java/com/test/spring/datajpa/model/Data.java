package com.test.spring.datajpa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{
    @JsonProperty("items") 
    public List<Announcement> getItems() { 
		 return this.items; } 
    public void setItems(List<Announcement> items) { 
		 this.items = items; } 
    List<Announcement> items;
    @JsonProperty("count") 
    public int getCount() { 
		 return this.count; } 
    public void setCount(int count) { 
		 this.count = count; } 
    int count;
}

