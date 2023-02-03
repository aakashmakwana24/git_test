package com.sacumentask.service;

import java.util.Optional;
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

	public Optional<?> getAlljobs() {

		JenkinsResponse jenkinsResponse = modelMapper.map(jenkinsServiceUtil.getAllJobs().getBody(),
				JenkinsResponse.class);
		log.info("Request hitting the service layer");

		jenkinsResponse.setJobs(jenkinsResponse.getJobs().stream().map(job -> {

//			Optional<String> var = job.getColor();
//			var status = switch (var) {
//			case "blue" -> "Success";
//			case "red" -> "Failed";
//			case "notbuilt" -> "Not Built";
//			default -> throw new IllegalArgumentException("Unexpected value: " + job.getColor());
//			};

			Optional<String> var = Optional.ofNullable(job.getColor());
			log.info(String.format("" + var));
			if (var.isPresent()) {
				if (var.get().equalsIgnoreCase("red")) {
					job.setStatus("Failed");

				} else if (var.get().equalsIgnoreCase("blue")) {
					job.setStatus("success");
				} else if (var.get().equalsIgnoreCase("notbuilt")) {
					job.setStatus("notbuilt");
				}
			} else {
				job.setStatus("Null");
				log.info("setting the status null");
			}

			return job;
		}).collect(Collectors.toList()));
		log.info(String.format("Returning the response: " + jenkinsResponse.getJobs()));

		return Optional.ofNullable(jenkinsResponse.getJobs());

	}

}
