package com.example.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Value("${helloworld.message}")
	private String message = "default";

	public void setMessage(String message) {
		this.message = message;
	}

	@RequestMapping("/test")
	public String test(Model model) {
		LOGGER.info("hello World");
		model.addAttribute("text", message);
		return "test";
	}

}

