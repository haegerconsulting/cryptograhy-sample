package de.haegerconsulting.sample.employees.core.domain;

import de.haegerconsulting.sample.common.domain.EmailAddress;

public class EmailAlreadyExistsException extends RuntimeException {
  public EmailAlreadyExistsException(EmailAddress emailAddress) {
    super("emailAddress {} already exists".formatted(emailAddress.value()));
  }
}
