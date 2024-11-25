package de.haegerconsulting.sample.employees.core.adapter.port.primary.http;

import de.haegerconsulting.sample.employees.core.application.EmployeeLeavesCompany;
import de.haegerconsulting.sample.employees.core.application.EmployeePrimaryPort;
import de.haegerconsulting.sample.employees.core.application.HireEmployee;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeRestAdapter {

  private final EmployeePrimaryPort employeePrimaryPort;
  private final EmployeeRepository employeeRepository;

  @GetMapping
  public Collection<EmployeeResponse> get() {
    return employeeRepository.findAll().stream().map(EmployeeResponse::of).toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EmployeeResponse post(@RequestBody HireEmployeePayload hireEmployeePayload) {
    return EmployeeResponse.of(employeePrimaryPort.hire(HireEmployee.of(hireEmployeePayload)));
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(@PathVariable String id) {
    employeePrimaryPort.leaveCompany(EmployeeLeavesCompany.of(id));
  }
}
