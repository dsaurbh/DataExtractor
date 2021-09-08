package com.test.spring.datajpa.service;

import java.util.List;

import com.test.spring.datajpa.model.Announcement;
import com.test.spring.datajpa.model.Symbol;

public interface DataExtractorService {

	public List<Announcement> getAnnouncements();

	public Symbol getSymbolData(Announcement announcement);

}
