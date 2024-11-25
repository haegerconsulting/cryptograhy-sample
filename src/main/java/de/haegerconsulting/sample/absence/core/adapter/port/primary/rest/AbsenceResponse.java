package de.haegerconsulting.sample.absence.core.adapter.port.primary.rest;

import de.haegerconsulting.sample.absence.core.domain.Absence;
import de.haegerconsulting.sample.absence.core.domain.TypeOfAbsence;

public record AbsenceResponse(String id, String employeeId, TypeOfAbsence typeOfAbsence, String reason) {
  public static AbsenceResponse of(Absence absence) {
    return new AbsenceResponse(
      absence.getAbsenceId().id(),
      absence.getEmployeeId().id(),
      absence.getTypeOfAbsence(),
      absence.getReason().reason()
    );
  }
}
