package com.api.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.model.District;
import com.api.model.State;
import com.api.model.User;
import com.api.repository.DistrictRepository;
import com.api.repository.StateRepository;
import com.api.repository.UserRepository;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@Controller
public class AdminController {
	
	
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private BCryptPasswordEncoder passwordEncode;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	DistrictRepository districtRepository;
	
	@GetMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping(value = "/addUser")
	public String loginProcess()
	{
		return "show-form";
		
	}
	
	@RequestMapping(value = "/addUserProcess",method = RequestMethod.POST)
	public String addUserProcess(Model model,User user,HttpSession session)
	{
		user.setPassword(passwordEncode.encode(user.getPassword()));
		userRepository.save(user);
		session.setAttribute("message", "Registration Success");
		
		
		return "redirect:/addUser";
		
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String mydisplay(User user)
	{
		return "redirect:dashboard";
		
	}
	
	@RequestMapping("/dashboard")
	public String myDashboard(Model model)
	{
		model.addAttribute("stateList",stateRepository.findAllState());
		System.out.println("-->");
		return "dashboard";
		
	}
	
	@ResponseBody
	@RequestMapping(value="loadDistrictBySate/{stateId}")
	public String loadDistrictBySate(@PathVariable("stateId") Integer stateId)
	{
		//districtRepository.f
		System.out.println("-->-->-->");
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		List<District> lstDst=districtRepository.findDistrictLstByStateId(stateId);
		
		lstDst.forEach((n) -> System.out.print(n.getName()));
		
		return gson.toJson(lstDst);
		//Optional<State> optionlSate=stateRepository.findById(stateId);
		
		//List<District> lstDst=districtRepository.findAllByState(optionlSate);
		
		
		//lstDst.forEach((n) -> System.out.print(n.getName()));
		//return gson.toJson(lstDst);
		
		
	       
		
	}
	
	
	@RequestMapping(value = "/location")
	public String location()
	{
		return "location";
		
	}
	
	
	
}