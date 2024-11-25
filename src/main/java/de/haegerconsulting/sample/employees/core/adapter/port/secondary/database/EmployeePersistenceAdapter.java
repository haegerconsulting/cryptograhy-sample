package de.haegerconsulting.sample.employees.core.adapter.port.secondary.database;

import de.haegerconsulting.sample.common.domain.EmailAddress;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;
import de.haegerconsulting.sample.employees.core.domain.Employee;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class EmployeePersistenceAdapter implements EmployeeRepository {

  private final EmployeeJpaRepository repository;
  private final EmployeeMapper mapper;

  @Override
  public Optional<Employee> find(EmployeeId id) {
    return repository.findById(id.id()).map(mapper::to);
  }

  @Override
  public Collection<Employee> findAll() {
    return repository.findAll().stream().map(mapper::to).collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public boolean existsByEmail(EmailAddress emailAddress) {
    return repository.existsByEmailAddress(emailAddress.value());
  }

  @Override
  public Employee save(Employee employee) {
    EmployeeEntity employeeEntity = mapper.to(employee);
    return mapper.to(repository.save(employeeEntity));
  }

  @Override
  public void delete(EmployeeId employeeId) {
    repository.deleteById(employeeId.id());
  }
}
