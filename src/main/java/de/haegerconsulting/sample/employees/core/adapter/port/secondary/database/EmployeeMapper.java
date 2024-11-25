package de.haegerconsulting.sample.employees.core.adapter.port.secondary.database;

import de.haegerconsulting.sample.common.domain.EmailAddress;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;
import de.haegerconsulting.sample.employees.core.domain.BirthDay;
import de.haegerconsulting.sample.employees.core.domain.Employee;
import de.haegerconsulting.sample.employees.core.domain.FirstName;
import de.haegerconsulting.sample.employees.core.domain.LastName;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeMapper {
  public Employee to(EmployeeEntity employeeEntity) {
    return new Employee(
      new EmployeeId(employeeEntity.getId()),
      new EmailAddress(employeeEntity.getEmailAddress()),
      new FirstName(employeeEntity.getFirstName()),
      new LastName(employeeEntity.getLastName()),
      new BirthDay(LocalDate.parse(employeeEntity.getBirthday())),
      employeeEntity.getRole()
    );
  }

  public EmployeeEntity to(Employee employee) {
    return new EmployeeEntity(
      employee.getEmployeeId() != null ? employee.getEmployeeId().id() : null,
      employee.getEmailAddress().value(),
      employee.getFirstName().value(),
      employee.getLastName().value(),
      employee.getBirthday().localDate().toString(),
      employee.getRole()
    );
  }
}