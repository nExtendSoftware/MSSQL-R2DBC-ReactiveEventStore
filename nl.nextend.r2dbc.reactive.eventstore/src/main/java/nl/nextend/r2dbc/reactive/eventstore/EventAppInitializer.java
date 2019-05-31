package nl.nextend.r2dbc.reactive.eventstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class EventAppInitializer implements ApplicationRunner{

	@Autowired
	private EventRepository eventsRepository;
	
	/** The log */
	private static final Logger log = LoggerFactory.getLogger( EventAppInitializer.class );
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("[start initializer]");
		
		Flux.just("login","logout","loadobject","saveobject")
			.map(name -> new Event("PL 7.0.1", name , "1.0.0" ))
			.flatMap(this.eventsRepository::save)
			.subscribe();
		
		log.info("[finish initializer]");
	}

}
