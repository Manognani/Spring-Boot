package com.tejait.batch15.service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.tejait.batch15.model.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee emp);
	public void deleteEmployee(Integer id);
	public Optional<Employee> getById(Integer id);
	public List<Employee> getAllEmps();
	public boolean existsById(Integer id);
	public Page<Employee> getpaginationData(int pageNum, int pageSize);
	public List<Employee> sortingDta(String property, String orderType);
	public List<Employee> findByDept(String dept);
	public List<Employee> findByFnameAndLname(String fname, String lname);
	public List<Employee> findByFnameOrLname(String fname, String lname);
	public List<Employee> findBySalaryBetween(long salary, long salary1);
	public List<Employee> findByAgeLessThen(int age);
	public List<Employee> findByAgeLessThenEqual(int age);
	public List<Employee> findBySalaryGreaterThen(long salary);
	public List<Employee> findByFnameLike(String fname);
	public List<Employee> findByLnameNotLike(String lname);
	public List<Employee> findByDeptStartWith(String dept);
	public List<Employee> findBySalaryEndWith(long salary);
	public List<Employee> findByFnameContaining(String fname);
	public List<Employee> findByOrderByAgeDesc(int age);
	public List<Employee> findByAgeIsNull();
	public List<Employee> findByFnameIsNotNull();
	public List<Employee> findByDeptIn(Collection<String> dept);
	public List<Employee> findByDeptNotIn(Collection<String> dept);
	public List<Employee> findByFnameIgnoreCase(String fname);
	public List<Employee> findDistinctByFnameAndLname(String fname, String lname);
	public List<String> findDistinctByDept();
	public List<Employee> searchEmployee(String searchTerm);
	public List<Employee> findByEmpCodeStartingWith(String empCode);
	public List<Employee> searchFilters(String filterType, String empCode);



}
