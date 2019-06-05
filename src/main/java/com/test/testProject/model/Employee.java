/**
 * 
 */
package com.test.testProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author niranjana_naik
 *
 */
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_Id")
	private int empId;
	@Column(name = "emp_Name")
	private String empName;
	@Column(name = "emp_City")
	private String empCity;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empId, String empName, String empCity) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empCity = empCity;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	
}
