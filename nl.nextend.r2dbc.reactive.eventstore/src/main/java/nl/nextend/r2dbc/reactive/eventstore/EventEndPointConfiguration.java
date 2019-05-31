package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EventEndPointConfiguration {
	
	@Bean
    RouterFunction<ServerResponse> routes(EventHandler handler) { 
        return route(i(GET("/events")), handler::all) 
            .andRoute(i(GET("/events/{id}")), handler::getById)
            .andRoute(i(DELETE("/events/{id}")), handler::deleteById)
            .andRoute(i(POST("/events")), handler::create)
            .andRoute(i(PUT("/events/{id}")), handler::updateById);
    }

    private static RequestPredicate i(RequestPredicate target) {
        return new CaseInsensitiveRequestPredicate(target);
    }
	
}
