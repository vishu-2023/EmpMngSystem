package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.entity.Employee;
import com.springboot.service.empservice;

@Controller
public class controller {
	@Autowired
	private empservice service;
	 @GetMapping("/")
	 public String home(Model m) {
		List<Employee> emp = service.showall();
		m.addAttribute("emp",emp);
		return "index";
		
		 
	 }
	
	
	
	
	@GetMapping("/addemp1")
     public String showempform() {
		return "add_emp";
    	 
     }
	@PostMapping("/register")
	public String empregister(@ModelAttribute Employee e) {
		System.out.println(e);
		service.addEmp(e);
		return "redirect:/";
		
	}
	@GetMapping("/edit/{Id}")
	public String edit(@PathVariable int Id,Model m) {
		Employee e=service.getempid(Id);
		m.addAttribute("emp",e);
		return "edit";
		
	}
	@PostMapping("/update")
	public String updateemp(@ModelAttribute Employee e) {
		service.addEmp(e);
		return ("redirect:/");
	}
	@GetMapping("/delete/{Id}")
	public String deleteemp(@PathVariable int Id,Model m) {
		service.deleteemp(Id);
		return ("redirect:/");
		
		
	}
}
