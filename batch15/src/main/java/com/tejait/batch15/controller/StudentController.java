package com.tejait.batch15.controller;

	
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tejait.batch15.model.Student;
import com.tejait.batch15.service.StudentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/Student")
public class StudentController {
	      // bean injection
	StudentService service;
	@PostMapping("savestu")
	public ResponseEntity<Student> saveStudent (@RequestBody Student  stu){
		
		Student savestu =service.saveStudent(stu);
		
		return new ResponseEntity<>(savestu, HttpStatus.CREATED);
		
	}
	@PostMapping("updatedstu")
	public	ResponseEntity<Student> updateStudent(@RequestBody Student stu){
			Student updatedStudent=service.saveStudent(stu);
			return new ResponseEntity<>(updatedStudent,HttpStatus.OK);    //update and create/save employee using same method--save method.
	}
			
	
	@DeleteMapping("deleteStuId/{id}")
	public ResponseEntity<String> deleteByStuId (@PathVariable Integer id){	
    service.deleteStudent(id);
	return new ResponseEntity<>("deleted Student Id:: "+id,HttpStatus.OK);
				
	}
	@GetMapping("getByEmpId/{id}")
	public ResponseEntity<Student> getByStuId(@PathVariable Integer id){
		  Optional<Student> stuObj=service.getById(id);
		return new ResponseEntity<>(stuObj.get(),HttpStatus.OK);
		
	}
	
	}
		
	


	


