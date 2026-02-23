package com.tejait.batch15.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Employee;
import com.tejait.batch15.model.Student;
import com.tejait.batch15.repository.StudentRepository;
import com.tejait.batch15.service.StudentService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
	

   StudentRepository repository;
   
   @Override
	public Student saveStudent(Student stu) {
		String fname=stu.getFname();
		String lname=stu.getLname();
		stu.setFullname(fname.concat(" "+lname));
		Student savestu=repository.save(stu); // save() method.
      return savestu ;
		
	}

	
	@Override
	public void deleteStudent(Integer id) {
		repository.deleteById(id);
		
	}
	@Override
	public Optional<Student> getById(Integer id) {
		
		return repository.findById(id);
	}
	

		
		
	
	
	

}
