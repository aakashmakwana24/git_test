package com.sacumentask.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacumentask.entities.SacumenJenkinsData;
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
	public List<SacumenJenkinsData> getAllJobs() {
		log.info("request intercepted by controller");
		try {
			return sacumenServices.getAlljobs();
		} catch (URISyntaxException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

}
