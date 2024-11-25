package de.haegerconsulting.sample.employees.core.adapter.port.secondary.database;

import de.haegerconsulting.cryptography.CryptographyCondition;
import de.haegerconsulting.utils.algorithm.Decrypter;
import de.haegerconsulting.sample.employees.core.domain.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EmployeeRepositoryConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryConfig.class);

  private final EmployeeJpaRepository employeeJpaRepository;
  private final EmployeeMapper employeeMapper;

  @Bean
  @Conditional(CryptographyCondition.class)
  public EmployeeRepository employeeCryptographyPersistenceAdapter(Decrypter decrypter) {
    LOGGER.info("using implementation {} for {}", EmployeeCryptographyPersistenceAdapter.class, EmployeeRepository.class);
    return new EmployeeCryptographyPersistenceAdapter(decrypter, employeeJpaRepository, employeeMapper);
  }

  @Bean
  @ConditionalOnMissingBean(EmployeeRepository.class)
  public EmployeeRepository employeePersistenceAdapter() {
    LOGGER.info("using implementation {} for {}", EmployeePersistenceAdapter.class, EmployeeRepository.class);
    return new EmployeePersistenceAdapter(employeeJpaRepository, employeeMapper);
  }
}
