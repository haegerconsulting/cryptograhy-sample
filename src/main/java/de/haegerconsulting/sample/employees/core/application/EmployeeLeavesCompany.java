package de.haegerconsulting.sample.employees.core.application;

import de.haegerconsulting.sample.employees.api.domain.EmployeeId;

public record EmployeeLeavesCompany(EmployeeId employeeId) {
  public static EmployeeLeavesCompany of(String id) {
    return new EmployeeLeavesCompany(new EmployeeId(id));
  }
}
