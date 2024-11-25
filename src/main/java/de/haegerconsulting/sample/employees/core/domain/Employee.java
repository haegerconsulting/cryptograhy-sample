package de.haegerconsulting.sample.employees.core.domain;

import de.haegerconsulting.sample.common.domain.EmailAddress;
import de.haegerconsulting.sample.common.domain.Entity;
import de.haegerconsulting.sample.common.domain.Role;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;
import lombok.Getter;
import org.jmolecules.ddd.annotation.AggregateRoot;

@Getter
@AggregateRoot
public class Employee extends Entity {

  private EmployeeId employeeId;
  private EmailAddress emailAddress;
  private FirstName firstName;
  private LastName lastName;
  private BirthDay birthday;
  private Role role;

  public Employee(EmailAddress emailAddress, FirstName firstName, LastName lastName, BirthDay birthday, Role role) {
    setEmployeeId(EmployeeId.gen());
    setEmailAddress(emailAddress);
    setFirstName(firstName);
    setLastName(lastName);
    setBirthday(birthday);
    setRole(role);
  }

  public Employee(EmployeeId employeeId, EmailAddress emailAddress, FirstName firstName, LastName lastName, BirthDay birthday,
                  Role role) {
    setEmployeeId(employeeId);
    setEmailAddress(emailAddress);
    setFirstName(firstName);
    setLastName(lastName);
    setBirthday(birthday);
    setRole(role);
  }

  public void setEmployeeId(EmployeeId employeeId) {
    if (employeeId == null) {
      throw new IllegalArgumentException("Cannot provide null value for employeeId");
    }
    if (this.employeeId != null) {
      return;
    }
    this.employeeId = employeeId;
  }

  private void setEmailAddress(EmailAddress emailAddress) {
    if (emailAddress == null) {
      throw new IllegalArgumentException("Cannot provide null value for emailAddress");
    }
    this.emailAddress = emailAddress;
  }

  private void setFirstName(FirstName firstName) {
    if (firstName == null) {
      throw new IllegalArgumentException("Cannot provide null value for firstName");
    }
    this.firstName = firstName;
  }

  public void setLastName(LastName lastName) {
    if (lastName == null) {
      throw new IllegalArgumentException("Cannot provide null value for lastName");
    }
    this.lastName = lastName;
  }

  private void setBirthday(BirthDay birthday) {
    if (birthday == null) {
      throw new IllegalArgumentException("Cannot provide null value for birthday");
    }
    this.birthday = birthday;
  }

  public void setRole(Role role) {
    if (role == null) {
      throw new IllegalArgumentException("Cannot provide null value for role");
    }
    this.role = role;
  }
}
