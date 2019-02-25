package nl.nextend.r2dbc.reactive.eventstore;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(value="Events")
class Event {
	
		public Event(String level, String event, String version) {
			this.event = event;
			this.level = level;
			this.version = version;
		}
		
		@Id
		private String id;
		
		@Column(value="event")
		private String event;
		
		@Column(value="version")
		private String version;
		
		@Column(value="level")
		private String level;
}
