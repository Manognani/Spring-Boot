package com.tejait.batch15.serviceimpl;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tejait.batch15.constants.SearchFilter;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import com.tejait.batch15.service.EmployeeService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor // Instead of @autowired give annotation @AllArgsConstructor through lombock
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee emp) {
		String fname=emp.getFname();  // sai
		String lname=emp.getLname();  // k
		emp.setFullname(fname.concat(" "+lname)); //saik
		return repository.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
		
		
	}

	@Override
	public Optional<Employee> getById(Integer id) {
	return  repository.findById(id);
	}

	@Override
	public List<Employee> getAllEmps() {
		//return repository.findAll();
		//return repository.getAll();
		return repository.getAllEmps();
	}

	@Override
	public boolean existsById(Integer id) {
		return repository.existsById(id);
	}

	@Override
	public Page<Employee> getpaginationData(int pageNum, int pageSize) {
	Pageable pagable=PageRequest.of(pageNum, pageSize);
		
		return repository.findAll(pagable);
	}

	@Override
	public List<Employee> sortingDta(String property, String orderType) {
		if(orderType.equalsIgnoreCase("desc")) {
			return repository.findAll(Sort.by(Direction.DESC,property));
		}
			return repository.findAll(Sort.by(Direction.ASC,property));
			
		
		
	}

	@Override
	public List<Employee> findByDept(String dept) {
		//return repository.findByDept(dept);
		return repository.findByDepartment(dept);
	}

	@Override
	public List<Employee> findByFnameAndLname(String fname, String lname) {
		//return repository.findByFnameAndLname(fname, lname);
		//return repository.findByFirstNameAndLastName(fname, lname);
		return repository.findByFirstNameAndLastNameData(fname, lname);
	}

	@Override
	public List<Employee> findByFnameOrLname(String fname, String lname) {
	return repository.findByFnameOrLname(fname, lname);
	
	}

	@Override
	public List<Employee> findBySalaryBetween(long salary, long salary1) {
		return repository.findBySalaryBetween(salary, salary1);
	}

	@Override
	public List<Employee> findByAgeLessThen(int age) {
		return repository.findByAgeLessThan(age);
		
	}

	@Override
	public List<Employee> findByAgeLessThenEqual(int age) {
		return repository.findByAgeLessThanEqual(age);
	}

	@Override
	public List<Employee> findBySalaryGreaterThen(long salary) {
		return repository.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> findByFnameLike(String fname) {
		
		return repository.findByFnameLike("%"+fname+"%");
		
	}

	@Override
	public List<Employee> findByLnameNotLike(String lname) {
		return repository.findByLnameNotLike(lname);
	}

	@Override
	public List<Employee> findByDeptStartWith(String dept) {
		return repository.findByDeptStartingWith(dept);
	}

	@Override
	public List<Employee> findBySalaryEndWith(long salary) {
		return repository.findByAgeGreaterThanEqual(salary);
	}

	@Override
	public List<Employee> findByFnameContaining(String fname) {
		return repository.findByFnameContaining(fname);
	}

	@Override
	public List<Employee> findByOrderByAgeDesc(int age) {
		return repository.findByOrderByAgeDesc(age);
	}

	@Override
	public List<Employee> findByAgeIsNull() {
		return repository.findByAgeIsNull();
	}

	@Override
	public List<Employee> findByFnameIsNotNull() {
		return repository.findByFnameIsNotNull();
		
	}
	
	@Override
	public List<Employee> findByDeptIn(Collection<String> dept) {
		return repository.findByDeptNotIn(dept);
	}

	@Override
	public List<Employee> findByDeptNotIn(Collection<String> dept) {
		return repository.findByDeptNotIn(dept);
	}

	@Override
	public List<Employee> findByFnameIgnoreCase(String fname) {
		return repository.findByFnameIgnoreCase(fname);
	}

	@Override
	public List<Employee> findDistinctByFnameAndLname(String fname, String lname) {
		return repository.findDistinctByFnameAndLname(fname, lname);
	}

	@Override
	public List<String> findDistinctByDept() {
		return repository.findDistinctByDept();
	}

	@Override
	public List<Employee> searchEmployee(String searchTerm) {
		return repository.searchEmployee(searchTerm);
	}

	@Override
	public List<Employee> findByEmpCodeStartingWith(String empCode) {
		return repository.findByEmpCodeStartingWith(empCode);
	}

	@Override
	public List<Employee> searchFilters(String filterType, String empCode) {
		List<Employee> list=null;
		switch(filterType) {
		
		case SearchFilter.EQUALS:
			list=repository.findByEmpCode(empCode);
			break;
		case SearchFilter.NOT_EQUALS:
			list=repository.findByEmpCodeNot(empCode);
			break;
		case SearchFilter.START_WITH:
			list=repository.findByEmpCodeStartingWith(empCode);
			break;
		case SearchFilter.END_WITH:
			list=repository.findByEmpCodeEndingWith(empCode);
			break;
		case SearchFilter.CONTAINS:
			list=repository.findByEmpCodeContaining(empCode);
			break;
		case SearchFilter.NOT_CONTAINS:
			list=repository.findByEmpCodeNotContaining(empCode);
			break;
		default:
		    throw new  IllegalArgumentException("Unexpected value:"+filterType);
			
	
		}
		return list;
		
		
	}

	
	

		
	
}
