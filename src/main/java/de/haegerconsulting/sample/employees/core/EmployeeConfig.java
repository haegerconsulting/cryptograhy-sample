package de.haegerconsulting.sample.employees.core;

import de.haegerconsulting.sample.common.adapter.port.secondary.event.EventPublisherAdapter;
import de.haegerconsulting.sample.employees.core.application.EmployeePrimaryPort;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EmployeeConfig {

  private final EmployeeRepository employeeRepository;
  private final EventPublisherAdapter eventPublisherAdapter;

  @Bean
  EmployeePrimaryPort employeePrimaryPort() {
    return new EmployeePrimaryPort(
      employeeRepository,
      eventPublisherAdapter
    );
  }
}
