package com.tejait.batch15.controller;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;

import lombok.AllArgsConstructor;
//@CrossOrigin
@RestController        // url directly hit this controller 
@RequestMapping("/employee")   // url directly  hit this particular 
@AllArgsConstructor // Instead of @autowired give annotation @AllArgsConstructor through lombock
public class EmployeeController {
	
	
    EmployeeService service;  // using Autowired for bean injection but it shows sonar error create constructor for employee service then give annotation that constructor. 
    
     @PostMapping("saveEmp")  // hit this particular method
	
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee saveEmp=service.saveEmployee(emp);
		return new ResponseEntity<>(saveEmp,HttpStatus.CREATED);
	}
		
		@PutMapping("updatedEmp")
	public	ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
			Employee updatedEmployee=service.saveEmployee(emp);
			return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
		}
		
		@DeleteMapping("deleteEmp/{id}")
	public ResponseEntity<String> deleteByEmpId (@PathVariable Integer id){	
		service.deleteEmployee(id);
		return new ResponseEntity<>("deleted Employee Id:: "+id,HttpStatus.OK);
		
		}
		@GetMapping("getByEmpId/{id}")
		public ResponseEntity<Employee> getByEmpId(@PathVariable Integer id){
			  Optional<Employee> empObj=service.getById(id);
			return new ResponseEntity<>(empObj.get(),HttpStatus.OK);
			
		}
		@GetMapping("getAll")
		public ResponseEntity<List<Employee>> getAllEmps(){
			List<Employee> list=service.getAllEmps();
			return new ResponseEntity<>(list,HttpStatus.OK);
}
		@GetMapping("existsById/{id}")
		public ResponseEntity<Boolean> existsById(@PathVariable Integer id) throws Exception{
			boolean result=service.existsById(id);
			if(!result) {
				//throw new IdNotFoundException("given Id not Available");
				//throw new MobileAlreadyExists("Mobile Already Exists");
				throw new Exception("something went wrong, unknown Error occured");
				
			}
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
	    @GetMapping("pagnation")	
        public ResponseEntity<Page<Employee>> paginationData(@RequestParam int pageNum,@RequestParam int pageSize){
	             Page<Employee> page=service.getpaginationData(pageNum,pageSize);
	             return new ResponseEntity<>(page,HttpStatus.OK);
	             
}
	    @GetMapping("dataSorting")
	     public ResponseEntity<List<Employee>> sortingData(@RequestParam String property ,@RequestParam String orderType){
		   List<Employee> list=service.sortingDta(property,orderType);
		        return new ResponseEntity<>(list,HttpStatus.OK);
	}
	    // select*from employee where dept=java .
		@GetMapping("FindByDept/{dept}")
	    public ResponseEntity<List<Employee>> findByDept(@PathVariable String dept){
	    	       List<Employee> list=service.findByDept(dept);
	    	return new ResponseEntity<>(list,HttpStatus.OK);
	    }
		//
		@GetMapping("findByFnameAndLname")
		public ResponseEntity<List<Employee>> findByFnameAndLname(@RequestParam String fname,String lname){
			       List<Employee> list =service.findByFnameAndLname(fname,lname);
			       return new ResponseEntity<>(list,HttpStatus.OK);
			                     
		}
		@GetMapping("findByFnameOrLname")
		public ResponseEntity<List<Employee>> findByFnameOrLname(@RequestParam String fname,String lname){
			        List<Employee> list=service.findByFnameOrLname(fname,lname);
			        return new ResponseEntity<>(list,HttpStatus.OK);
		}
		
		@GetMapping("findBySalaryBetween")
		public ResponseEntity<List<Employee>> findBySalaryBetween(@RequestParam long salary,long salary1){
			        List<Employee> list=service.findBySalaryBetween(salary,salary1);
			        return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findByAgeLessThen/{age}")
		public ResponseEntity<List<Employee>> findByAgeLessThen(@PathVariable int age){
			         List<Employee> list=service.findByAgeLessThen(age);
			         return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findByAgeLessThenEqual/{age}")
		 public ResponseEntity<List<Employee>> findByAgeLessThenEqual(@PathVariable int age){
			      List<Employee> list=service.findByAgeLessThenEqual(age);
			      return new ResponseEntity<>(list,HttpStatus.OK);
		 }
		@GetMapping("findBySalaryGreaterThen/{salary}")
		public ResponseEntity<List<Employee>> findBySalaryGreaterThen(@PathVariable long salary){
			      List<Employee> list=service.findBySalaryGreaterThen(salary);
			      return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findBySalaryGreaterThenEqual/{salary}")
		public ResponseEntity<List<Employee>> findbygsal(@PathVariable long salary){
			    List<Employee> list=service.findBySalaryGreaterThen(salary);
			    return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findByFnameLike/{fname}")
		public ResponseEntity<List<Employee>> findByFnameLike(@PathVariable String fname){
			     List<Employee> list=service.findByFnameLike(fname);
			     return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findByLnameNotLike/{lname}")
		public ResponseEntity<List<Employee>> findByLnameNotLike(@PathVariable String lname){
			      List<Employee> list=service.findByLnameNotLike(lname);
			      return new ResponseEntity<>(list,HttpStatus.OK);
			    		  
		}
		@GetMapping("findByDeptStartWith/{dept}")
		public ResponseEntity<List<Employee>> findByDeptStartingWith(@PathVariable String dept){
			      List<Employee> list=service.findByDeptStartWith(dept);
			      return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findBySalaryEndWith/{salary}")
		public ResponseEntity<List<Employee>> findBySalaryEndingWith(@PathVariable long salary){
			         List<Employee>  list=service.findBySalaryEndWith(salary); 
			         return new ResponseEntity<>(list,HttpStatus.OK);
			
		}
		@GetMapping("findByFnameContaining/{fname}")
		public ResponseEntity<List<Employee>> findByFnameContaining(@PathVariable String fname){
			        List<Employee> list=service.findByFnameContaining(fname);
			        return new ResponseEntity<>(list,HttpStatus.OK);
			        
		}
		@GetMapping("findByOrderByAgeDesc/{age}")
		public ResponseEntity<List<Employee>> findByOrderByAgeDesc(@PathVariable int age ){
			      List<Employee> list=service.findByOrderByAgeDesc(age);
			      return new ResponseEntity<>(list,HttpStatus.OK);
			
		}
		@GetMapping("findByAgeIsNull")
		public ResponseEntity<List<Employee>> findByAgeIsNull(){
		    List<Employee> list=service.findByAgeIsNull();
		 return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findByFnameIsNotNull")
		public ResponseEntity<List<Employee>> findByFnameIsNotNull(){
			 List<Employee> list=service.findByFnameIsNotNull();
			 return new ResponseEntity<>(list,HttpStatus.OK);
			
		}
		@GetMapping("findByDeptIn")// get data of dept in dept java records and c records. key=dept value=java this input give in postman
		public ResponseEntity<List<Employee>> findByDeptIn(@RequestParam Collection<String> dept){
			    List<Employee> list=service.findByDeptIn(dept);
			    return new ResponseEntity<>(list,HttpStatus.OK);
			
		}
		@GetMapping("findByDeptNotIn") // NotIn what are input given in postman like java apart from this remaining all records data display.
		public ResponseEntity<List<Employee>> findByDeptNotIn(@RequestParam Collection<String> dept){
			     List<Employee> list=service.findByDeptNotIn(dept);
			     return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findByFnameIgnoreCase/{fname}") // ignore the name upper or lower case what ever  want we can give get fname record ignore the case
		public ResponseEntity<List<Employee>> findByFnameIgnoreCase(@PathVariable String fname){
			List<Employee> list=service.findByFnameIgnoreCase(fname);
		     return new ResponseEntity<>(list,HttpStatus.OK);
			
		}
		@GetMapping("findDistinctByFnameAndLname")
		public ResponseEntity<List<Employee>> findDistinctByFnameAndLname(@RequestParam String fname,String lname){
			List<Employee> list=service.findDistinctByFnameAndLname(fname,lname);
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("findDistinctByDept")
		  public ResponseEntity<List<String>> findDistinctByDept(){
			    List<String> list=service.findDistinctByDept();
			    return new ResponseEntity<>(list,HttpStatus.OK);
		  }
		@GetMapping("search/{searchTerm}")    // search operation give input based on input get data from employee table.
		public ResponseEntity<List<Employee>> search(@PathVariable String searchTerm){
		  List<Employee> list=service.searchEmployee(searchTerm);
		  return new ResponseEntity<>(list,HttpStatus.OK);
		}
		@GetMapping("searchFilters")
		public ResponseEntity<List<Employee>> searchFilters(@RequestParam String filterType,@RequestParam String empCode){
			List<Employee> list=service.searchFilters(filterType,empCode);
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		
}
	 
		
	












