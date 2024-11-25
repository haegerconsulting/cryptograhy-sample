package de.haegerconsulting.sample.absence.core.domain;

import de.haegerconsulting.sample.employees.api.domain.EmployeeId;

import java.util.Collection;

public interface AbsenceRepository {
  Collection<Absence> findByEmployeeId(EmployeeId employeeId);

  void deleteByEmployeeId(EmployeeId employeeId);

  void save(Absence absence);

  Collection<Absence> findAll();
}
