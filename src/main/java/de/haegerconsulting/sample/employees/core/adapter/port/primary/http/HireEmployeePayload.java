package de.haegerconsulting.sample.employees.core.adapter.port.primary.http;

import de.haegerconsulting.sample.common.domain.Role;

import java.time.LocalDate;

public record HireEmployeePayload(String emailAddress, String firstName, String lastName, LocalDate birthday, Role role) {
}
