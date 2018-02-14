package com.base;

import com.base.model.Employee;
import com.base.repository.EmployeeRepository;
import com.base.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;


    @Before
    public void setUp() {
        Employee employee = new Employee("alex");
        List<Employee> employeeList = Arrays.asList(employee);

        Mockito.when(employeeRepository.findByName(employee.getName())).thenReturn(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
    }

    @Test
    public void employeeTest() {
        String name = "alex";
        Employee employee = employeeService.findByName(name);

        assertThat(employee.getName()).isEqualTo(name);
    }

    @Test
    public void esployeeListTest() {
        Employee employee = new Employee("alex");

        List<Employee> employeeList = employeeService.findAll();

        assertThat(employeeList.get(0)).isEqualTo(employee);
    }
}
