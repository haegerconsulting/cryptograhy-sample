package de.haegerconsulting.sample.employees.core.adapter.port.secondary.database;

import de.haegerconsulting.annotationtypes.GdprRelevant;
import de.haegerconsulting.sample.common.domain.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeEntity {
  @Id
  private String id;
  @GdprRelevant
  private String emailAddress;
  @GdprRelevant
  private String firstName;
  @GdprRelevant
  private String lastName;
  @GdprRelevant
  private String birthday;
  @Enumerated(EnumType.STRING)
  private Role role;
}
