package com.test.spring.datajpa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/")
public class GenericController {

	@GetMapping("/")
	public ModelAndView method() {
	    return new ModelAndView("redirect:" + "api/download");
	}
	

}
