package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Employee;
@Repository
public interface emprepo extends JpaRepository<Employee,Integer>{

}
