package de.haegerconsulting.sample.common.domain;

import org.jmolecules.ddd.annotation.ValueObject;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

@ValueObject
public record EmailAddress(String value) {

  /**
   * <a href="https://html.spec.whatwg.org/multipage/input.html#valid-e-mail-address">...</a>
   */
  private static final Pattern PATTERN = Pattern.compile(
    "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9]" +
      "(?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?" +
      "(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");

  private static final int MINIMUM_LENGTH = 4;

  public EmailAddress {
    if (!StringUtils.hasText(value) || value.trim().length() < MINIMUM_LENGTH) {
      throw new IllegalArgumentException(
        "E-mail addresses must be at least %s characters long, %s isn't".formatted(MINIMUM_LENGTH, value));
    }
    if (!PATTERN.matcher(value).matches()) {
      throw new IllegalArgumentException(
        "E-mail addresses must be compliant to the WHATWG HTML specification, %s isn't".formatted(value));
    }
  }
}
