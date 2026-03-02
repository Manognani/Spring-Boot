package com.tejait.batch15.serviceimpl;

import com.tejait.batch15.model.Employee;
import com.tejait.batch15.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // this class eligible for mock testing
 class EmployeeServiceimplTests {
    @Mock                           // create repository mock object
    EmployeeRepository repository;
    @InjectMocks                   // service bean injects into mock bean repository
    EmployeeServiceImpl service;


     @Test
    void givenId_whenFindById_getIdObject() {
        Employee givenEmp = Employee.builder()
                 .id(1)
                .fname("James")
                .lname("Bond")
               // .fullname("James Bond")
                .age(25)
                .salary(120000L)
                .empCode("JA55VA")
                .dept("JAVA")
                .build();
        //when
         BDDMockito.given(repository.save(givenEmp)).willReturn(givenEmp); //stubbing
            Employee savedEmp=service.saveEmployee(givenEmp);
         //then
         Assertions.assertThat(savedEmp).isNotNull();
         Assertions.assertThat(savedEmp.getId()).isPositive();
         Assertions.assertThat(savedEmp.getAge()).isGreaterThan(18);
         Assertions.assertThat(savedEmp.getDept()).isEqualTo("JAVA");
         Assertions.assertThat(savedEmp.getFullname()).isEqualTo("James Bond");
         Assertions.assertThat(savedEmp).hasFieldOrProperty("empCode");
         Assertions.assertThat(savedEmp).hasFieldOrPropertyWithValue("fullname", "James Bond");
         Assertions.assertThat(savedEmp).hasNoNullFieldsOrProperties();


    }
}
