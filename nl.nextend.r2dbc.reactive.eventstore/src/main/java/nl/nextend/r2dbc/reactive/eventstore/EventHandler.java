package nl.nextend.r2dbc.reactive.eventstore;

import java.net.URI;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EventHandler {
	
    private final EventService eventService;

    EventHandler(EventService eventService) {
        this.eventService = eventService;
    }

    Mono<ServerResponse> getById(ServerRequest r) {
        return defaultReadResponse(this.eventService.get(id(r)));
    }

    Mono<ServerResponse> all(ServerRequest r) {
        return defaultReadResponse(this.eventService.all());
    }

    Mono<ServerResponse> deleteById(ServerRequest r) {
        return defaultReadResponse(this.eventService.delete(id(r)));
    }

    Mono<ServerResponse> updateById(ServerRequest r) {
        Flux<Event> id = r.bodyToFlux(Event.class)
            .flatMap(p -> this.eventService.update(id(r), p.getEvent(), p.getVersion(), p.getLevel()));
        return defaultReadResponse(id);
    }

    Mono<ServerResponse> create(ServerRequest request) {
        Flux<Event> flux = request
            .bodyToFlux(Event.class)
            .flatMap(toWrite -> this.eventService.create(toWrite.getEvent(), toWrite.getVersion(), toWrite.getLevel()));
        return defaultWriteResponse(flux);
    }

    private static Mono<ServerResponse> defaultWriteResponse(Publisher<Event> events) {
        return Mono
            .from(events)
            .flatMap(p -> ServerResponse
                .created(URI.create("/events/" + p.getId()))
                .build()
            );
    }

    private static Mono<ServerResponse> defaultReadResponse(Publisher<Event> events) {
        return ServerResponse
            .ok()
            .body(events, Event.class);
    }

    private static String id(ServerRequest r) {
        return r.pathVariable("id");
    }

}
