package com.sacumentask.JenkinsInt;

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
	public void getAllJobsTest() {
//
//		when(sacumenServices.getAlljobs()).thenReturn(new JenkinsResponse(Stream
//				.of(new SacumenJenkinsJobData("First_job", "blue", "Success", true),
//						new SacumenJenkinsJobData("Second_job", "red", "Failure", true),
//						new SacumenJenkinsJobData("Third_job", "notbuilt", "Notbuilt", true))
//				.collect(Collectors.toList())));
//		assertEquals(3, sacumenController.getAllJobs().getJobs().size());
//		assertEquals(4, sacumenController.getAllJobs().getJobs().size());
//		assertEquals(5, sacumenController.getAllJobs().getJobs().size());
	}

}
