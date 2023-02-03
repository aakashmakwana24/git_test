package com.sacumentask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SacumenJenkinsJobData {
	@JsonProperty("job_name")
	private String name;

	@JsonIgnore
	private String color;

	@JsonProperty("job_status")
	private String status;

	@JsonProperty("job_buildable")
	private boolean buildable;

}
