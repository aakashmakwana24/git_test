package com.sacumentask.appconfig;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.offbytwo.jenkins.JenkinsServer;

@Configuration
public class SacumenConfiguration {

	@Value("${jenkins.username}")
	private String username;

	@Value("${jenkins.password}")
	private String password;

	@Value("${jenkins.url}")
	private String url;

	@Bean
	public JenkinsServer getServer() {
		try {
			return new JenkinsServer(new URI(url), username, password);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
