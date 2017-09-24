package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.repository.InMemoryTimeLineRepository;
import com.repository.InMemoryTweetRepository;
import com.repository.InMemoryUserRepository;
import com.repository.TimelineRepository;
import com.repository.TweetRepository;
import com.repository.UserRepository;

@Configuration
public class RepositoryConfig {

	@Bean
	public TimelineRepository timelineRepository() {
		return new InMemoryTimeLineRepository();
	}
	
	@Bean
	public TweetRepository tweetRepository() {
		return new InMemoryTweetRepository();
	}
	
	@Bean
	public UserRepository userRepository() {
		return new InMemoryUserRepository();
	}
	
}
