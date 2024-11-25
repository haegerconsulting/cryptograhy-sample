package de.haegerconsulting.sample.employees.core.domain;

import de.haegerconsulting.sample.common.domain.EmailAddress;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository {
  Optional<Employee> find(EmployeeId id);

  Employee save(Employee employee);

  void delete(EmployeeId employeeId);

  Collection<Employee> findAll();

  boolean existsByEmail(EmailAddress emailAddress);
}
