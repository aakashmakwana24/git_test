package com.sacumentask.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Jenkins-service", url = "http://localhost:8080/api/json?trFee=jobs[name,url,buildable]", configuration = JenkinsServerConfig.class)

public interface JenkinsServiceUtil {

	@GetMapping
	public ResponseEntity<?> getAllJobs();
}
