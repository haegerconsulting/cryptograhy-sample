package de.haegerconsulting.sample.absence.core.adapter.port.secondary;

import de.haegerconsulting.sample.absence.core.domain.Absence;
import de.haegerconsulting.sample.absence.core.domain.AbsenceId;
import de.haegerconsulting.sample.absence.core.domain.AbsenceReason;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {
  public Absence to(AbsenceEntity absenceEntity) {
    return new Absence(
      new AbsenceId(absenceEntity.getId()),
      new EmployeeId(absenceEntity.getEmployeeId()),
      absenceEntity.getTypeOfAbsence(),
      new AbsenceReason(absenceEntity.getReason())
    );
  }

  public AbsenceEntity to(Absence absence) {
    return new AbsenceEntity(
      absence.getAbsenceId().id(),
      absence.getEmployeeId().id(),
      absence.getTypeOfAbsence(),
      absence.getReason().reason()
    );
  }
}
