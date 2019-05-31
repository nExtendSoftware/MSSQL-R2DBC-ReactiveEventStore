package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "Events")
class Event {

	@Id
	private String id;

	@Column(value = "event")
	private String event;

	@Column(value = "version")
	private String version;

	@Column(value = "level")
	private String level;
}
