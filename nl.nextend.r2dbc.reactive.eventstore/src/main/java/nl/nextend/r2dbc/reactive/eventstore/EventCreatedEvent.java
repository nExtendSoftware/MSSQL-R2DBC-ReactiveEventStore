package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.context.ApplicationEvent;

public class EventCreatedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public EventCreatedEvent(Event source) {
        super(source);
    }
}
