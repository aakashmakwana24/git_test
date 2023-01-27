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
import com.sacumentask.entities.SacumenJenkinsData;
import com.sacumentask.service.SacumenServices;

@SpringBootTest
class JenkinsIntApplicationTests {

	@MockBean
	private SacumenServices sacumenServices;

	@Autowired
	private SacumenController sacumenController;

	@Test
	public void getAllJobsTest() throws URISyntaxException, IOException {

		when(sacumenServices.getAlljobs()).thenReturn(Stream
				.of(new SacumenJenkinsData("first_job", "FAILURE"), new SacumenJenkinsData("second_job", "SUCCESS"))
				.collect(Collectors.toList()));
		
		assertEquals(2, sacumenController.getAllJobs().size());
		assertEquals(1, sacumenController.getAllJobs().size());
		
	}
}
