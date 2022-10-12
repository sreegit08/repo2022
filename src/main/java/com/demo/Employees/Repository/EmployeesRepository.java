package com.demo.Employees.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.Employees.Model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Long>{
	
	public  Employees findByName(String name);


	public boolean existsByName(String name); 
		
	

}