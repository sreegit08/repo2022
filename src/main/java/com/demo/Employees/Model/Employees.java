package com.demo.Employees.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
//import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeTable")
//@NamedNativeQuery(name="Employees.findById",query="select * from Employees where id=?",resultClass=Employees.class )
//NamedNativeQuery(name="Employees.findByName",query="select * from Employees where name=?",resultClass=Employees.class)
public class Employees {
	private long id;
	private String name;
	private double salary;
	
	
	public Employees() {
		
	}
public Employees(String name,double salary) {
	this.name=name;
	this.salary=salary;
}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public long getId() {
	return id;
}

public void setId(long id) {
	this.id=id;
}


@Column(name="Employee_Name",nullable=false)
public String getName() {
	return name;
}

public void setName(String name) {
	this.name=name;
}

@Column(name="Employee_Salary",nullable=false)
public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary=salary;
}


}





























































