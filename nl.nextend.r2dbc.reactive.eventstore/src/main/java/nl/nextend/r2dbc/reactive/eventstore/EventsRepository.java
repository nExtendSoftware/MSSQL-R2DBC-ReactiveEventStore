package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

interface EventsRepository extends ReactiveCrudRepository<Event, String> {

	@Query("select * from events e")
	Flux<Event> findAllEvents();
}