package de.haegerconsulting.sample.common.adapter.port.secondary.event;

import de.haegerconsulting.sample.common.domain.DomainEvent;
import de.haegerconsulting.sample.common.domain.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
@RequiredArgsConstructor
public class EventPublisherAdapter implements EventPublisher {

  private final ApplicationEventPublisher applicationEventPublisher;

  public void publish(DomainEvent event) {
    applicationEventPublisher.publishEvent(event);
  }

  @Override
  public void publishAll(Queue<DomainEvent> domainEvent) {
    domainEvent.forEach(this::publish);
  }
}