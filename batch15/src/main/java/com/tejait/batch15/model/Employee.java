package com.tejait.batch15.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Data
@Builder
@Table(name="employee_b15") // in SQL want custom name 
@Entity     // spring boot understand this is entity. in project we have 1000 classes, spring boot understand which one is entity.
public class Employee {	
@Id     //primary_key
@GeneratedValue(strategy = GenerationType.IDENTITY )//auto increment
private int id;
// @Column("name=first_name");    // in spring boot no need to write SQL queries but we need inform which operation we want to perform.in spring boot 
private String fname;              // create table but we need to inform what type of table we want through entity=model.
private String lname;             // pkgs are controller,service,serviceimpl,model,config,util. these pkgs  are start with parent pkg name.
private String fullname;          //pkgs start with com, parent pkg is "com.tejait.batch15."            
private Integer age;                             // controller -> service(Interface) -> serviceimpl(Class) -> repository
private long salary;                         // controller ----Url
private String empCode;                      // service ----- business logic  write logic store in repository                        
private String dept;                                             // Repository -----data base
// initialize data using getters and setters.

} 

