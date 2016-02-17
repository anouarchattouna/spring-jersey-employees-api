package org.anotherdev;

import org.anotherdev.domain.Employee;
import org.anotherdev.service.EmployeeRepository;
import org.anotherdev.service.EmployeeService;
import org.anotherdev.web.EmployeeResource;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class EmployeeResourceTest {
    private Mockery context;
    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;
    private EmployeeResource employeeResource;

    @Before
    public void beforeEachTest() throws Exception {
        context = new Mockery();
        employeeService = new EmployeeService();
        employeeRepository = context.mock(EmployeeRepository.class);

        employeeResource = new EmployeeResource();

        Field field = employeeService.getClass().getDeclaredField("employeeRepository");
        field.setAccessible(true);
        field.set(employeeService, employeeRepository);

    }

    @Test
    public void findByUserNameTest() {
        final String firstName = "j2ee";
        final String lastName = "j2ee";

        context.checking(new Expectations() {
            {
                oneOf(employeeRepository)
                        .findByFirstNameAndLastName(with(any(String.class)), with(any(String.class)));
                will(returnValue(with(any(Employee.class))));
            }
        });
        employeeService.findByFirstNameAndLastName(firstName, lastName);

        context.assertIsSatisfied();
    }
}