package com.tejait.batch15.model;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.processing.Pattern;

import com.tejait.batch15.constants.Role;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor   // argumented constructor
@NoArgsConstructor    // zero argumented constructor  these lombok to reduce the boilerplate code.
@ToString
//@RequiredArgsConstructor
@Data              // using this annotation to 
@Table(name="person_b15")
@Entity
public class Person {
	
@Id   // primary_key
@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
private	int pid;

@Column(name="person_name",nullable = false)
private String name;

@Column(name="mail_id",nullable = false,unique = true)
private String mail;
	
private int age;

//@Pattern(regexp)
private String pan;

@Transient              // give transient annotation this property not create in table.
private long balance;

@CreationTimestamp
private LocalDateTime createdAt;

@UpdateTimestamp
private LocalDateTime updatedAt;

@Enumerated(EnumType.STRING)
private Role role;


}
