package com.tejait.batch15.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Table(name="Student_B15")       // employee name 
@Entity
public class Student {
	@Id  // primary_key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String fname;
	private String lname;
	private String fullname;
	private String branch;
	private long fee;
	private int age;
	
	

}
