package com.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

	@RequestMapping("/")
	public String afficherPage1()
	{
		return "accueil";
	}
}
