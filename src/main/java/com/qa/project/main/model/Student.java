package com.qa.project.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
//	private static Integer ID_COUNTER = 0;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int roll;
	private String name;
	private String address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, int roll, String name, String address) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.address = address;
	}
//	public int getID_COUNTER() {
//		return ID_COUNTER;
//	}
//	//public void setID_COUNTER(int iD_COUNTER) {
//		ID_COUNTER = iD_COUNTER;
//	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}
