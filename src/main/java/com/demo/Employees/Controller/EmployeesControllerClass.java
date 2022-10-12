package com.demo.Employees.Controller;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.Employees.Exception.ResourceNotFoundException;
import com.demo.Employees.Model.Employees;
import com.demo.Employees.Repository.EmployeesRepository;
import com.demo.Employees.Service.EmployeeServiceClass;

@RestController
@RequestMapping("/api")
public class EmployeesControllerClass {
	
	@Autowired
	EmployeeServiceClass service;
	
	@PostMapping("/Employees")
	public ResponseEntity<Employees> createEmp(@RequestBody Employees emp) {
		Employees employee=service.createEmployee(emp);
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}	
		
	@PostMapping("/EmployeesList")
	public List<Employees> createEmployeeList(@RequestBody List<Employees> employees) {
			
			return service.createEmployees(employees);
	  
	}
	
	 @GetMapping()
	    //@ResponseBody
		public ResponseEntity<List<Employees>> getAllEmp(){
		List<Employees> employee=service.getAllEmployees();
		 
			return ResponseEntity.status(HttpStatus.OK).body(employee);
		
		}
	/*	
	 @RequestMapping(value="/Employees/{name}",method=RequestMethod.GET)
   // @ResponseBody
	public ResponseEntity<Employees> getEmpByName (@RequestParam(value="name",required=false) String name)
			throws ResourceNotFoundException{
    	
		//Employees employee=service.getEmployeeByName(name);
    	return ResponseEntity.status(HttpStatus.OK).body(employee);
	
	}
	*/
    

    @GetMapping("/Employees/{id}")
   
	public ResponseEntity<Employees> getEmpById(@PathVariable Long id) 
    throws ResourceNotFoundException{
    	Employees em=service.getEmployeeById(id);
    	System.out.println(em.getId());
	return ResponseEntity.status(HttpStatus.OK).body(em);
	}
    
    @DeleteMapping("/Employees/{name}")
    public String deleteEmp(@PathVariable String name) {
    return service.deleteEmployee(name);
	
    }
    
    @PutMapping("/UpdateEmployees")
    public Employees updateEmp(@RequestBody Employees update) {
    	return service.updateEmployee(update);
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	/*
	 * 
	 * 
    @RequestMapping(value="/Employees/{id}",method=RequestMethod.GET)
    //@ResponseBody
	public ResponseEntity<Employees> getEmpById(@RequestParam(value="id",required=false) Long id) 
    throws ResourceNotFoundException{
    	Employees em=service.getEmployeeById(id);
	return ResponseEntity.status(HttpStatus.OK).body(em);
	}
	
	
	  try {
			Employees em=service.getEmployeeById(id);
			
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
	 
	@GetMapping()
	public List<Employees> getAllEmps(@RequestParam Map<String, String> params){
		 if (params.size() == 0) { //Default case, no params
			 return service.getAllEmployees();
		    }
		 if (params.containsKey("id")) {
		      try {
		    	  
		    	  return service.getEmployeeById(Long.parseLong(params.get("id")));
		      } catch (NumberFormatException e) {
		        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provided request parameter was not a valid number.");
		      }
		      //return repository.findByQuery("AEvent_find_by_minRegistrations", value);
		    }
		 if (params.containsKey("name")) {
		      try {
		    	  
		    	  return service.getEmployeeByName(params.get("name"));
		      } catch (NumberFormatException e) {
		        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provided request parameter was not a valid number.");
		      }
		      //return repository.findByQuery("AEvent_find_by_minRegistrations", value);
		    }
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid query parameters.");
		  }
	

	/*@GetMapping("/Employees/employee?id=?")
	@ResponseBody
	public Employees getEmpById(@RequestParam Long id){
		return service.getEmployeeById(id);
	
	}
	
     @GetMapping("/Employees/{name}")
     @ResponseBody
	public Employees getEmpByName(@RequestParam String name){
		return service.getEmployeeByName(name);
	
	}*/
	
	

}
