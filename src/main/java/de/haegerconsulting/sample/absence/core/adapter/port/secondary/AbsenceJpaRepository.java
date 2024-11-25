package de.haegerconsulting.sample.absence.core.adapter.port.secondary;

import de.haegerconsulting.annotationtypes.Pseudonymize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AbsenceJpaRepository extends JpaRepository<AbsenceEntity, String> {
  Collection<AbsenceEntity> findByEmployeeId(@Pseudonymize(reference = EmployeeReference.REFERENCE) String employeeId);

  void deleteByEmployeeId(@Pseudonymize(reference = EmployeeReference.REFERENCE) String employeeId);
}