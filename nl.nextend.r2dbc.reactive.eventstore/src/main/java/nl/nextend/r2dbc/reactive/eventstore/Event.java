package nl.nextend.r2dbc.reactive.eventstore;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "Events")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonFormat
@JsonPropertyOrder({ "id", "event", "version", "level" })
class Event {

	@JsonProperty("id")
	@Id
	private String id;

	@JsonProperty("event")
	@Column(value = "event")
	private String event;

	@JsonProperty("version")
	@Column(value = "version")
	private String version;

	@JsonProperty("level")
	@Column(value = "level")
	private String level;
}
