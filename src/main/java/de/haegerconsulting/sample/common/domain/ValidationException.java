package de.haegerconsulting.sample.common.domain;

public class ValidationException extends RuntimeException {
  public ValidationException(String message) {
    super(message);
  }
}
