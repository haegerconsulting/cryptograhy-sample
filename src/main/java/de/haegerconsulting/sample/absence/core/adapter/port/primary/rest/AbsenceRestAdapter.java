package de.haegerconsulting.sample.absence.core.adapter.port.primary.rest;

import de.haegerconsulting.sample.absence.core.application.AbsencePrimaryPort;
import de.haegerconsulting.sample.absence.core.application.CreateAbsence;
import de.haegerconsulting.sample.absence.core.domain.AbsenceRepository;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("absences")
public class AbsenceRestAdapter {

  private final AbsencePrimaryPort absencePrimaryPort;
  private final AbsenceRepository absenceRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public AbsenceResponse post(@RequestBody CreateAbsencePayload createAbsencePayload) {
    return AbsenceResponse.of(absencePrimaryPort.createAbsence(CreateAbsence.of(createAbsencePayload)));
  }

  @GetMapping
  public Collection<AbsenceResponse> get() {
    return absenceRepository.findAll().stream().map(AbsenceResponse::of).toList();
  }

  @GetMapping(params = "employee-id")
  public Collection<AbsenceResponse> getByEmployeeId(@RequestParam("employee-id") String employeeId) {
    return absenceRepository.findByEmployeeId(new EmployeeId(employeeId)).stream().map(AbsenceResponse::of).toList();
  }

  @DeleteMapping(params = "employee-id")
  public void deleteByEmployeeId(@RequestParam("employee-id") String employeeId) {
    absenceRepository.deleteByEmployeeId(new EmployeeId(employeeId));
  }
}
