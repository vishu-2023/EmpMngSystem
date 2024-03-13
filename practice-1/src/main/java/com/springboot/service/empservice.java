package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Employee;
import com.springboot.repository.emprepo;
@Service
public class empservice {
	@Autowired
	private emprepo repo;
	
	public void addEmp(Employee e) {
		repo.save(e);
	}
	public List<Employee> showall(){
		return repo.findAll();
		
	}
	public Employee getempid(int Id) {
		
		
		
		Optional<Employee> e=repo.findById(Id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	public void deleteemp(int Id) {
		repo.deleteById(Id);
	}
	

}
