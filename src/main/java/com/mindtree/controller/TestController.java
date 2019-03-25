package com.mindtree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="test")
	public String test() {
		System.out.println("in test controller");
		return "hello";
	}

}
