package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int salary;
	@OneToOne
	@JoinColumn(name="adrId")
	private Address address;
	
	@OneToMany(mappedBy = "employee")
	private List<Phone>phone;
	@ManyToMany
	@JoinTable(name="emp_dept",joinColumns = {@JoinColumn(name="empID")}, inverseJoinColumns= {@JoinColumn(name="deptid")})
	private List<Department>deptList;
	

	
	public List<Department> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Empolyee [id=" + id + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}
	



}
