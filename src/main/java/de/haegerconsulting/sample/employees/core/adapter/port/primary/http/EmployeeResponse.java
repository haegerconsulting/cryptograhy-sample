package de.haegerconsulting.sample.employees.core.adapter.port.primary.http;

import de.haegerconsulting.sample.common.domain.Role;
import de.haegerconsulting.sample.employees.core.domain.Employee;

import java.time.LocalDate;

public record EmployeeResponse(String employeeId, String emailAddress, String firstName, String lastName, LocalDate birthday,
                               Role role) {
  public static EmployeeResponse of(Employee employee) {
    return new EmployeeResponse(
      employee.getEmployeeId().id(),
      employee.getEmailAddress().value(),
      employee.getFirstName().value(),
      employee.getLastName().value(),
      employee.getBirthday().localDate(),
      employee.getRole()
    );
  }
}
