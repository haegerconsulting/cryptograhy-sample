package de.haegerconsulting.sample.employees.core.adapter.port.secondary.database;

import de.haegerconsulting.utils.algorithm.Decrypter;
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
public class EmployeeCryptographyPersistenceAdapter implements EmployeeRepository {

  private final Decrypter decrypter;
  private final EmployeeJpaRepository repository;
  private final EmployeeMapper mapper;

  @Override
  public Optional<Employee> find(EmployeeId id) {
    return repository.findById(id.id()).map(mapper::to);
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

  @Override
  public Collection<Employee> findAll() {
    return repository.findAll().stream().map(mapper::to).collect(Collectors.toCollection(ArrayList::new));
  }

  public Collection<String> findAllEmailAddresses() {
    return repository.findAllEmailAddresses()
      .stream()
      .map(decrypter::decrypt)
      .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public boolean existsByEmail(EmailAddress emailAddress) {
    return findAllEmailAddresses().stream()
      .anyMatch(email -> email.equals(emailAddress.value()));
  }
}
