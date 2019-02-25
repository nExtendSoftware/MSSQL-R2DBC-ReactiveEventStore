package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}
	
	@Bean
	RouterFunction<?> routes (EventsRepository eventsRepository){
		return RouterFunctions.route(RequestPredicates.GET("/events"), req -> ServerResponse.ok().body(eventsRepository.findAllEvents(), Event.class));
	}

}

