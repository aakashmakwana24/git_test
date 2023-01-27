package com.sacumentask.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.sacumentask.entities.SacumenJenkinsData;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class SacumenServices {

	private final JenkinsServer jenkins;

	public List<SacumenJenkinsData> getAlljobs() throws URISyntaxException, IOException {

		Map<String, Job> jobs = jenkins.getJobs();

		List<SacumenJenkinsData> listdata = jobs.values().stream().map(x -> {
			SacumenJenkinsData jenkinsData = SacumenJenkinsData.builder().jenkinsJobName(x.getName()).build();
			try {
				jenkinsData.setJenkinsJobStatus(x.details().getLastBuild().details().getResult().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return jenkinsData;
		}).collect(Collectors.toList());
		log.info("collecting the job list");
		log.info(String.format("Listdata = " + listdata));
		return listdata;
		
		
		
	}

}
