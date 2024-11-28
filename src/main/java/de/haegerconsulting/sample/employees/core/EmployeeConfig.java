package de.haegerconsulting.sample.employees.core;

import de.haegerconsulting.sample.common.adapter.port.secondary.event.EventPublisherAdapter;
import de.haegerconsulting.sample.employees.core.application.EmployeePrimaryPort;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

  @Bean
  EmployeePrimaryPort employeePrimaryPort(EmployeeRepository employeeRepository, EventPublisherAdapter eventPublisherAdapter) {
    return new EmployeePrimaryPort(employeeRepository, eventPublisherAdapter);
  }
}
