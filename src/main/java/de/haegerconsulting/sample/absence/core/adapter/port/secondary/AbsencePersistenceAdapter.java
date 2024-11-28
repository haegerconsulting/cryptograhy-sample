package de.haegerconsulting.sample.absence.core.adapter.port.secondary;

import de.haegerconsulting.sample.absence.core.domain.Absence;
import de.haegerconsulting.sample.absence.core.domain.AbsenceRepository;
import de.haegerconsulting.sample.employees.api.domain.EmployeeId;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AbsencePersistenceAdapter implements AbsenceRepository {

  private final AbsenceJpaRepository repository;
  private final AbsenceMapper mapper;

  @Override
  public Collection<Absence> findByEmployeeId(EmployeeId employeeId) {
    return repository.findByEmployeeId(employeeId.id())
      .stream()
      .map(mapper::to)
      .collect(Collectors.toList());
  }

  @Override
  public Collection<Absence> findAll() {
    return repository.findAll()
      .stream()
      .map(mapper::to)
      .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void deleteByEmployeeId(EmployeeId employeeId) {
    repository.deleteByEmployeeId(employeeId.id());
  }

  @Override
  public void save(Absence absence) {
    repository.save(mapper.to(absence));
  }
}
