package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService {

	private final ApplicationEventPublisher publisher; 
	private final EventRepository eventRepository; 

	EventService(ApplicationEventPublisher publisher, EventRepository eventRepository) {
		this.publisher = publisher;
		this.eventRepository = eventRepository;
	}

	public Flux<Event> all() { 
		return this.eventRepository.findAll();
	}

	public Mono<Event> get(String id) { 
		return this.eventRepository.findById(id);
	}

	public Mono<Event> update(String id, String eventContent, String version, String level) { 
		return this.eventRepository.findById(id).map(p -> new Event(p.getId(), eventContent, version, level))
				.flatMap(this.eventRepository::save);
	}

	public Mono<Event> delete(String id) { 
		return this.eventRepository.findById(id).flatMap(p -> this.eventRepository.deleteById(p.getId()).thenReturn(p));
	}

	public Mono<Event> create(String eventContents, String version, String level) { 
		return this.eventRepository.save(new Event(eventContents, version, level))
				.doOnSuccess(event -> this.publisher.publishEvent(new EventCreatedEvent(event)));
	}

}
