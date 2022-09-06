package com.springboot.web.mycontroller;

import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@RequestMapping("/testRestController")
	public String testRestController()
	{
		
		System.out.println("@RestController=@Controller+@ResponseBody");
		return "@RestController=@Controller+@ResponseBody";
	}

}
