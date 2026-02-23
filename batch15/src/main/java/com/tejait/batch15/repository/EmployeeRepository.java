package com.tejait.batch15.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tejait.batch15.model.Employee;
@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// extends with jpa -employee and ID =entity perimary_key data type mention here
	// @anotation is given to the component classes, then create beans(object) then store in spring container to store the objects.
	    //  @rest controller , @service, @repository, @component 
	// inject one bean to another 
public List<Employee> findByDept(String dept);     // find by dept from employee table.

public List<Employee> findByFnameAndLname(String fname,String lname); // find fullname from employee table
public List<Employee> findByFnameOrLname(String fname,String lname);  // 
public List<Employee> findBySalaryBetween(long salary,long salary1 );
public List<Employee> findByAgeLessThan(int age); 
public List<Employee> findByAgeLessThanEqual(int age);
public List<Employee> findBySalaryGreaterThan(long salary);
public List<Employee> findByAgeGreaterThanEqual(long salary);
public List<Employee> findByFnameLike(String fname);
public List<Employee> findByLnameNotLike(String lname);
public List<Employee> findByDeptStartingWith(String dept);
public List<Employee> findBySalaryEndingWith(long salary);
public List<Employee> findByFnameContaining(String fname); // containing 'a'
public List<Employee> findByOrderByAgeDesc(int age);    
public List<Employee> findByAgeIsNull();
public List<Employee> findByFnameIsNotNull();
public List<Employee> findByDeptIn(Collection<String> dept);
public List<Employee> findByDeptNotIn(Collection<String> dept);
public List<Employee> findByFnameIgnoreCase(String fname);
public List<Employee> findDistinctByFnameAndLname(String fname,String lname);

@Query("select e from Employee e") // jpa query with out syntax create our custom queries for our requirement
public List<Employee> getAll();

@Query(value="select * from employee_b15",nativeQuery = true) // sql query for get all employee data
public List<Employee> getAllEmps();

@Query("select e from Employee e where e.dept=?1")
public List<Employee> findByDepartment(String department); // here wriete method name and whatever we want parameters also but query must be match with entity properties.

@Query("select e from Employee e where e.fname=?1 and e.lname=?2 ")
public List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

@Query("select e from Employee e where e.fname=:firstNmae and e.lname=:lastName ") // write out custom query with params.
public List<Employee> findByFirstNameAndLastNameData( @Param("firstNmae") String fstNmae,@Param("lastName") String lastName);
// select distinct(dept) from employee_b15;
@Query("select distinct(e.dept) from Employee e ")
public List<String> findDistinctByDept();

@Query("select e from Employee e where concat(e.fname,e.lname,e.fullname,e.dept,e.empCode,e.salary,e.age) like %?1% ")
public List<Employee> searchEmployee(String serachTerm);


//****************************searchFilters*************************************
//--------------------------search filters start-----------------------------
public List<Employee> findByEmpCodeStartingWith(String empCode);
//----------------------------search filters end--------------------------------
public List<Employee> findByEmpCodeEndingWith(String empCode);
//----------------------------search filter containing-----------------------
public List<Employee> findByEmpCodeContaining(String empCode);

public List<Employee> findByEmpCodeNotContaining(String empCode);

public List<Employee> findByEmpCode(String empCode);

public List<Employee> findByEmpCodeNot(String empCode);












}
