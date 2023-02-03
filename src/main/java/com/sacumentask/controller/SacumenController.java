package com.sacumentask.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacumentask.service.SacumenServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/${project.version}/jenkins-data")
@AllArgsConstructor
@Slf4j
public class SacumenController {

	private SacumenServices sacumenServices;

	@GetMapping("/get-all-jobs")
	public Optional<?> getAllJobs() {
		log.info("Request intercepted by the controller");

		return Optional.ofNullable(sacumenServices.getAlljobs());
	}
}
