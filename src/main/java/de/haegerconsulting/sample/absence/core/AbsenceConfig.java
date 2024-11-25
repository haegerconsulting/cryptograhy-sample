package de.haegerconsulting.sample.absence.core;

import de.haegerconsulting.sample.absence.core.adapter.port.secondary.AbsencePersistenceAdapter;
import de.haegerconsulting.sample.absence.core.application.AbsencePrimaryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AbsenceConfig {

  private final AbsencePersistenceAdapter absencePersistenceAdapter;

  @Bean
  AbsencePrimaryPort absencePrimaryPort() {
    return new AbsencePrimaryPort(absencePersistenceAdapter);
  }
}
