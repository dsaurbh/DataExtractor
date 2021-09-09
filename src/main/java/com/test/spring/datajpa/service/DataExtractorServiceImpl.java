package com.test.spring.datajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.test.spring.datajpa.model.Announcement;
import com.test.spring.datajpa.model.AnnouncementResponse;
import com.test.spring.datajpa.model.Symbol;
import com.test.spring.datajpa.model.SymbolResponse;

@Service
public class DataExtractorServiceImpl implements DataExtractorService {

	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		return restTemplate;
	}
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Announcement> getAnnouncements() {
		AnnouncementResponse announcementResponse = restTemplate.getForObject(
				"https://asx.api.markitdigital.com/asx-research/1.0/markets/announcements?priceSensitiveOnly=true",
				AnnouncementResponse.class);
		return announcementResponse.getData().getItems();
	}

	@Override
	public Symbol getSymbolData(Announcement announcement) {
		String symbolName= announcement.getCompanyInfo().get(0).getSymbol();
		if(null == symbolName){
			symbolName = announcement.getSymbol();
		}
		SymbolResponse symbolResponse = restTemplate
				.getForObject("https://asx.api.markitdigital.com/asx-research/1.0/companies/"
						+ symbolName + "/header", SymbolResponse.class);
		return symbolResponse.getData();
	}

}
