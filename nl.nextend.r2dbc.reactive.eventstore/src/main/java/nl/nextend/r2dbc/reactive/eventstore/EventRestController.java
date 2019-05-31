package nl.nextend.r2dbc.reactive.eventstore;

import java.net.URI;

import org.reactivestreams.Publisher;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
@RefreshScope
public class EventRestController {

	private final MediaType mediaType = MediaType.APPLICATION_JSON;
	private final EventService eventService;

	EventRestController(EventService profileRepository) {
		this.eventService = profileRepository;
	}

	@GetMapping
	Publisher<Event> getAll() {
		return this.eventService.all();
	}

	@GetMapping("/{id}")
	Publisher<Event> getById(@PathVariable("id") String id) {
		return this.eventService.get(id);
	}

	@PostMapping
	Publisher<ResponseEntity<Event>> create(@RequestBody Event toWrite) {
		return this.eventService.create(toWrite.getEvent(), toWrite.getVersion(), toWrite.getLevel())
				.map(p -> ResponseEntity.created(URI.create("/events/" + p.getId())).contentType(mediaType).build());
	}

	@DeleteMapping("/{id}")
	Publisher<Event> deleteById(@PathVariable String id) {
		return this.eventService.delete(id);
	}

	@PutMapping("/{id}")
	Publisher<ResponseEntity<Event>> updateById(@PathVariable String id, @RequestBody Event event) {
		return Mono.just(event).flatMap(p -> this.eventService.update(id, p.getEvent(), p.getVersion(), p.getLevel()))
				.map(p -> ResponseEntity.ok().contentType(this.mediaType).build());
	}

}
