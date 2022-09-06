package com.springboot.web.mycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	
	@RequestMapping("/testControllerWithRespBody")
	@ResponseBody
	public String testRest()
	{
		
		System.out.println("I am going to testControllerWithRespBody rest ");
		return "I am going to testControllerWithRespBody rest page";
	}
	
	@RequestMapping("/")
	public String home()
	{
		
		System.out.println("I am going to home page");
		return "home";
	}
	
	@GetMapping("/contact")
	public String contact()
	{
		
		System.out.println("I am going to contact page");
		return "contact";
	}


}
