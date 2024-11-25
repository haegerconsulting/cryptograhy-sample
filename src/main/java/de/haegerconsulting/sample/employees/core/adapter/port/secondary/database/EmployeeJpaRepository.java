package de.haegerconsulting.sample.employees.core.adapter.port.secondary.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, String> {
  boolean existsByEmailAddress(String emailAddress);

  @Query("SELECT e.emailAddress FROM EmployeeEntity e")
  Collection<String> findAllEmailAddresses();
}
