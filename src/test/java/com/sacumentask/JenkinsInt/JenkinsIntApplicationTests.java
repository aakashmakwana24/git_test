package com.sacumentask.JenkinsInt;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sacumentask.controller.SacumenController;
import com.sacumentask.service.SacumenServices;

@SpringBootTest
class JenkinsIntApplicationTests {

	@MockBean
	private SacumenServices sacumenServices;

	@Autowired
	private SacumenController sacumenController;

	@Test
	public void getAllJobsTest() throws URISyntaxException, IOException {

//		when(sacumenServices.getAlljobs()).thenReturn(Stream
//				.of(new SacumenJenkinsJobData("first_job", "FAILURE", null), new SacumenJenkinsJobData("second_job", "SUCCESS", null))
//				.collect(Collectors.toList()));
//		
//		assertEquals(2, sacumenController.getAllJobs().size());
//		assertEquals(1, sacumenController.getAllJobs().size());

	}
}
