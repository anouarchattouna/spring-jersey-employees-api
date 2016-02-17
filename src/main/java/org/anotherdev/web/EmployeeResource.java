package org.anotherdev.web;

import org.anotherdev.domain.Employee;
import org.anotherdev.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Component
@Path("employees")
@XmlRootElement
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getOneByFirstNameAndLastName(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
        System.out.println("******************** " + firstName + " **** " + lastName);
        return employeeService.findByFirstNameAndLastName(firstName, lastName);
    }

}
