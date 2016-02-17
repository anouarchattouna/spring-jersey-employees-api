package org.anotherdev;

import org.anotherdev.domain.Employee;
import org.anotherdev.service.EmployeeRepository;
import org.anotherdev.service.EmployeeService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class EmployeeServiceTest {
    private Mockery context;
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @Before
    public void beforeEachTest() throws Exception {
        context = new Mockery();
        employeeRepository = context.mock(EmployeeRepository.class);
        employeeService = new EmployeeService();

        Field field = employeeService.getClass().getDeclaredField("employeeRepository");
        field.setAccessible(true);
        field.set(employeeService, employeeRepository);
    }

    @Test
    public void findByUserNameTest() {
        final String firstName = "jean";
        final String lastName = "dupond";

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
