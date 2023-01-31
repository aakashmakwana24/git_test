package com.sacumentask.JenkinsInt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sacumentask.controller.SacumenController;
import com.sacumentask.entities.JenkinsResponse;
import com.sacumentask.entities.SacumenJenkinsJobData;
import com.sacumentask.service.SacumenServices;

@SpringBootTest
class JenkinsIntApplicationTests {

	@MockBean
	private SacumenServices sacumenServices;

	@Autowired
	private SacumenController sacumenController;

	@Test
	public void getAllJobsTest() throws URISyntaxException, IOException {

		when(sacumenServices.getAlljobs())
				.thenReturn(new JenkinsResponse(Stream
						.of(new SacumenJenkinsJobData("First_job", "blue", "Success"),
								new SacumenJenkinsJobData("Second_job", "red", "Failure"),
								new SacumenJenkinsJobData("Third_job", "notbuilt", "Notbuilt"))
						.collect(Collectors.toList())));

		assertEquals(3, sacumenController.getAllJobs().getJobs().size());
		assertEquals(4, sacumenController.getAllJobs().getJobs().size());
		assertEquals(5, sacumenController.getAllJobs().getJobs().size());
	}
}
