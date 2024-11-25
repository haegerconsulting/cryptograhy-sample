package de.haegerconsulting.sample.employees.core.application;

import de.haegerconsulting.sample.common.domain.EventPublisher;
import de.haegerconsulting.sample.employees.api.domain.EmployeeLeftCompany;
import de.haegerconsulting.sample.employees.core.domain.EmailAlreadyExistsException;
import de.haegerconsulting.sample.employees.core.domain.Employee;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;

public class EmployeePrimaryPort {
  private final EmployeeRepository employeeRepository;
  private final EventPublisher eventPublisher;

  public EmployeePrimaryPort(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
    this.employeeRepository = employeeRepository;
    this.eventPublisher = eventPublisher;
  }

  public Employee hire(HireEmployee hireEmployee) {
    if (employeeRepository.existsByEmail(hireEmployee.emailAddress())) {
      throw new EmailAlreadyExistsException(hireEmployee.emailAddress());
    }
    Employee employee = new Employee(
      hireEmployee.emailAddress(),
      hireEmployee.firstName(),
      hireEmployee.lastName(),
      hireEmployee.birthday(),
      hireEmployee.role()
    );
    return employeeRepository.save(employee);
  }

  public void leaveCompany(EmployeeLeavesCompany employeeLeavesCompany) {
    employeeRepository.delete(employeeLeavesCompany.employeeId());
    eventPublisher.publish(EmployeeLeftCompany.of(employeeLeavesCompany));
  }
}
