package de.haegerconsulting.sample.absence.core.adapter.port.secondary;

import de.haegerconsulting.annotationtypes.GdprRelevant;
import de.haegerconsulting.annotationtypes.Pseudonymize;
import de.haegerconsulting.sample.absence.core.domain.TypeOfAbsence;
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
@Table(name = "absences")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AbsenceEntity {
  @Id
  private String id;
  @Pseudonymize(reference = EmployeeReference.REFERENCE)
  private String employeeId;
  @Enumerated(EnumType.STRING)
  private TypeOfAbsence typeOfAbsence;
  @GdprRelevant
  private String reason;
}
