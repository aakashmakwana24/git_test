package com.sacumentask.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sacumentask.entities.JenkinsResponse;
import com.sacumentask.externalservice.JenkinsServiceUtil;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class SacumenServices {

	private ModelMapper modelMapper;

	private JenkinsServiceUtil jenkinsServiceUtil;

	public JenkinsResponse getAlljobs() {

		JenkinsResponse jenkinsResponse = modelMapper.map(jenkinsServiceUtil.getAllJobs().getBody(),
				JenkinsResponse.class);

		jenkinsResponse.setJobs(jenkinsResponse.getJobs().parallelStream().map(job -> {

			var status = switch (job.getColor()) {
			case "blue" -> "Success";
			case "red" -> "Failed";
			case "notbuilt" -> "Not Built";
			default -> throw new IllegalArgumentException("Unexpected value: " + job.getColor());
			};

			job.setStatus(status);

			return job;
		}).collect(Collectors.toList()));

		return jenkinsResponse;
	}

}
