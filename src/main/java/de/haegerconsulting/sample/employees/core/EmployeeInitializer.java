package de.haegerconsulting.sample.employees.core;

import de.haegerconsulting.sample.common.domain.EmailAddress;
import de.haegerconsulting.sample.common.domain.Role;
import de.haegerconsulting.sample.employees.core.application.EmployeePrimaryPort;
import de.haegerconsulting.sample.employees.core.application.HireEmployee;
import de.haegerconsulting.sample.employees.core.domain.BirthDay;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;
import de.haegerconsulting.sample.employees.core.domain.FirstName;
import de.haegerconsulting.sample.employees.core.domain.LastName;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class EmployeeInitializer implements ApplicationRunner {

  private final EmployeeRepository employeeRepository;
  private final EmployeePrimaryPort employeePrimaryPort;

  @Override
  public void run(ApplicationArguments args) {
    HireEmployee hireEmployee = new HireEmployee(
      new EmailAddress("christoph.englisch@gmail.com"),
      new FirstName("Christoph"),
      new LastName("Englisch"),
      new BirthDay(LocalDate.of(2000, 6, 1)),
      Role.EMPLOYEE
    );

    if (employeeRepository.existsByEmail(hireEmployee.emailAddress())) {
      return;
    }

    employeePrimaryPort.hire(hireEmployee);
  }
}
