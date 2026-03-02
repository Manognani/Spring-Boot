package com.tejait.batch15.repository;

import com.tejait.batch15.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

import java.util.Optional;

@DataJpaTest
@EntityScan(basePackageClasses = Employee.class)
class EmployeeRepositoryTests {

    @Autowired
     EmployeeRepository repository;

    @Test
      void givenEmp_whenSaveEmp_thenReturnSaveEmp() {

        Employee givenEmp = Employee.builder()
                // .id(1)
                .fname("James")
                .lname("Bond")
                .fullname("James Bond")
                .age(25)
                .salary(120000L)
                .empCode("JA55VA")
                .dept("JAVA")
                .build();
        Employee saveEmp = repository.save(givenEmp);
        Assertions.assertThat(saveEmp).isNotNull();
        Assertions.assertThat(saveEmp.getId()).isPositive();
        Assertions.assertThat(saveEmp.getAge()).isGreaterThan(18);
        Assertions.assertThat(saveEmp.getDept()).isEqualTo("JAVA");
        Assertions.assertThat(saveEmp.getFullname()).isEqualTo("James Bond");
        Assertions.assertThat(saveEmp).hasFieldOrProperty("empCode");
        Assertions.assertThat(saveEmp).hasFieldOrPropertyWithValue("fullname", "James Bond");
        Assertions.assertThat(saveEmp).hasNoNullFieldsOrProperties();

    }
    @Test
    void givenId_whenFindById_getIdObject(){
            Employee  givenEmp=Employee.builder()
                    // .id(1)
                    .fname("James")
                    .lname("Bond")
                    .fullname("James Bond")
                    .age(25)
                    .salary(120000L)
                    .empCode("JA55VA")
                    .dept("JAVA")
                    .build();
            //when
            Employee   saveEmp=repository.save(givenEmp);
        Optional<Employee> employee=repository.findById(saveEmp.getId());

        Assertions.assertThat(employee.get()).isNotNull();
        Assertions.assertThat(employee.get().getEmpCode()).isEqualTo("JA55VA");



        }

    }





