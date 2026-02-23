package com.tejait.batch15.service;


import java.util.Optional;

import org.springframework.stereotype.Service;


import com.tejait.batch15.model.Student;
@Service
public interface StudentService {

public	Student saveStudent(Student stu);

public void deleteStudent(Integer id);

public Optional<Student> getById(Integer id);





}
