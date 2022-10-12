package com.demo.Employees.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Employees.Model.Employees;
import com.demo.Employees.Repository.EmployeesRepository;
import com.demo.Employees.Exception.ResourceNotFoundException;
@Service
public class EmployeeServiceClass {
	
	@Autowired
	private EmployeesRepository repo;
	
	//get
	public  List<Employees> getAllEmployees(){
		return  repo.findAll();
	}
	
	//get
	public  Employees getEmployeeById (Long id)
		throws ResourceNotFoundException{
		
		return  repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee id not found for this id"+id));
				
	}
	
	/*
	//get
		public  Employees getEmployeeByName(String name)
				//throws ResourceNotFoundException
		{
		
			return  repo.findByName(name);
					//.orElseThrow(()->new ResourceNotFoundException("Employee id not found for this id"+name));
			}
		*/
	
	//post
	public List<Employees> createEmployees(List<Employees> create){
		return repo.saveAll(create);
	}
	
	//post
	public Employees createEmployee(Employees createEmp){
		return repo.save(createEmp);
	}
	
	//delete
	public String deleteEmployee(String name) {
		
			return "deleted"+name;
		}
	
	
	//update or put
	public Employees updateEmployee(Employees empl) {
		Employees existingProduct=repo.findById(empl.getId()).orElse(null);
		
		existingProduct.setName(empl.getName());
		existingProduct.setSalary(empl.getSalary());
		return repo.save(existingProduct);
	}

	
}
	
	/*	if(repo.findByName(name)==null) {
	System.out.println("Employee not found with given name");
}
else 
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	

