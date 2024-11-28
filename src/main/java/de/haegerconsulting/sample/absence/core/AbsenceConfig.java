package de.haegerconsulting.sample.absence.core;

import de.haegerconsulting.sample.absence.core.adapter.port.secondary.AbsencePersistenceAdapter;
import de.haegerconsulting.sample.absence.core.application.AbsencePrimaryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AbsenceConfig {

  @Bean
  AbsencePrimaryPort absencePrimaryPort(AbsencePersistenceAdapter absencePersistenceAdapter) {
    return new AbsencePrimaryPort(absencePersistenceAdapter);
  }
}
