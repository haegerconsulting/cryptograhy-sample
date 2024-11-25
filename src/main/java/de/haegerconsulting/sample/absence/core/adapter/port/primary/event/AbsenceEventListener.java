package de.haegerconsulting.sample.absence.core.adapter.port.primary.event;

import de.haegerconsulting.sample.absence.core.application.AbsencePrimaryPort;
import de.haegerconsulting.sample.employees.core.application.EmployeeLeavesCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AbsenceEventListener {

  private final AbsencePrimaryPort absencePrimaryPort;

  @EventListener(EmployeeLeavesCompany.class)
  public void onEvent(EmployeeLeavesCompany employeeLeavesCompany) {
    absencePrimaryPort.deleteAllAbsencesForEmployee(employeeLeavesCompany.employeeId());
  }
}
