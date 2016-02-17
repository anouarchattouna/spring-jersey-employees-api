package org.anotherdev.service;

import org.anotherdev.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
