package com.sacumentask.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SacumenJenkinsData {

	@JsonProperty("jenkins_job_name")
	private String jenkinsJobName;

	@JsonProperty("jenkins_job_status")
	private String jenkinsJobStatus;

}
