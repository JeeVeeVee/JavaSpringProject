package com.example.springboottutorial.controllers;

import com.example.springboottutorial.service.VoetbalService;
import com.example.springboottutorial.service.VoetbalServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		return "redirect:/about";
	}

	@Bean
	public VoetbalService voetbalService(){
		return new VoetbalServiceImpl();
	}
}