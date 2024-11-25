package de.haegerconsulting.sample.employees.core.application;

import de.haegerconsulting.sample.common.domain.EmailAddress;
import de.haegerconsulting.sample.common.domain.Role;
import de.haegerconsulting.sample.employees.core.adapter.port.primary.http.HireEmployeePayload;
import de.haegerconsulting.sample.employees.core.domain.BirthDay;
import de.haegerconsulting.sample.employees.core.domain.FirstName;
import de.haegerconsulting.sample.employees.core.domain.LastName;

public record HireEmployee(EmailAddress emailAddress, FirstName firstName, LastName lastName, BirthDay birthday, Role role) {
  public static HireEmployee of(HireEmployeePayload hireEmployeePayload) {
    return new HireEmployee(
      new EmailAddress(hireEmployeePayload.emailAddress()),
      new FirstName(hireEmployeePayload.firstName()),
      new LastName(hireEmployeePayload.lastName()),
      new BirthDay(hireEmployeePayload.birthday()),
      hireEmployeePayload.role()
    );
  }
}
