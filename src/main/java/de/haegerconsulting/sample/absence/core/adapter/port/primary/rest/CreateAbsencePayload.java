package de.haegerconsulting.sample.absence.core.adapter.port.primary.rest;

import de.haegerconsulting.sample.absence.core.domain.TypeOfAbsence;

public record CreateAbsencePayload(String employeeId, TypeOfAbsence typeOfAbsence, String reason) {
}
