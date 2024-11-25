package de.haegerconsulting.sample.employees.api.domain;

import de.haegerconsulting.sample.common.domain.DomainEvent;
import de.haegerconsulting.sample.employees.core.application.EmployeeLeavesCompany;

public record EmployeeLeftCompany(EmployeeId employeeId) implements DomainEvent {
  public static EmployeeLeftCompany of(EmployeeLeavesCompany employeeLeavesCompany) {
    return new EmployeeLeftCompany(employeeLeavesCompany.employeeId());
  }

  @Override
  public int eventVersion() {
    return 1;
  }
}
