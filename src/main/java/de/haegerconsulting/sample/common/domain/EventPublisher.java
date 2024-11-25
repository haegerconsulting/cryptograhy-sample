package de.haegerconsulting.sample.common.domain;

import java.util.Queue;

public interface EventPublisher {

  void publish(DomainEvent event);

  void publishAll(Queue<DomainEvent> domainEvent);
}
