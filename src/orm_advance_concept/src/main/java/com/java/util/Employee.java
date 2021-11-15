package com.java.util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_INFO")
public class Employee {

	@Id
	private int empId;
	private String empName;
	private String companyName;
	private String empEmail;
	private int empAge;

	public Employee(int empId, String empName, String companyName, String empEmail, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.companyName = companyName;
		this.empEmail = empEmail;
		this.empAge = empAge;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	@Override
	public String toString() {
		return "\n Employee information [empId=" + empId + ", empName=" + empName + ", companyName=" + companyName
				+ ", empEmail=" + empEmail + ", empAge=" + empAge + "]";
	}

}
