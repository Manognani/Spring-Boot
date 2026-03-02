package com.tejait.batch15.controller;
import com.tejait.batch15.model.Employee;
import com.tejait.batch15.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@WebMvcTest(EmployeeController.class) // it loads the web layer, MVC components
public class EmployeeControllerTests {
    @MockitoBean
    EmployeeService service;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void givenId_whenFindById_getIdObject() throws Exception {
        Employee givenEmp = Employee.builder()
                .id(1)
                .fname("James")
                .lname("Bond")
                .fullname("James Bond")
                .age(25)
                .salary(120000L)
                .empCode("JA55VA")
                .dept("JAVA")
                .build();
        // when
        ResultActions result =mockMvc.perform(post("http://localhost:8082/employee/saveEmp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(givenEmp)));
        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());


        //then
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
