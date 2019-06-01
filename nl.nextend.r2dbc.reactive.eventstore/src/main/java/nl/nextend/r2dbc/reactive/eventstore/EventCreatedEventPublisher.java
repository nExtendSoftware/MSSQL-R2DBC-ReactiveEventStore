package nl.nextend.r2dbc.reactive.eventstore;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

import org.springframework.context.ApplicationListener;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Component;


import reactor.core.publisher.FluxSink;
@Component
public class EventCreatedEventPublisher implements ApplicationListener<EventCreatedEvent>, 
		Consumer<FluxSink<EventCreatedEvent>> { 

	private final Executor executor;
	private final BlockingQueue<EventCreatedEvent> queue = new LinkedBlockingQueue<>(); 

	EventCreatedEventPublisher(Executor executor) {
	    this.executor = executor;
	}
	
	@Override
	public void onApplicationEvent(EventCreatedEvent event) {
		this.queue.offer(event);
	}

	@Override
	public void accept(FluxSink<EventCreatedEvent> sink) {
		this.executor.execute(() -> {
			while (true)
				try {
					EventCreatedEvent event = queue.take(); 
					sink.next(event); // <6>
				} catch (InterruptedException e) {
					ReflectionUtils.rethrowRuntimeException(e);
				}
		});
	}
}
