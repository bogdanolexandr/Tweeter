package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.repository.TimelineRepository;
import com.repository.TweetRepository;
import com.repository.UserRepository;
import com.service.SimpleTweeterService;
import com.service.TweeterService;

@Configuration
public class ServiceConfig {

	@Bean
	public TweeterService tweeterService(TimelineRepository timelineRepository,TweetRepository tweetRepository,UserRepository userRepository) {
		
		SimpleTweeterService tweeterService = new SimpleTweeterService();
		
		tweeterService.setTimelineRepository(timelineRepository);
		tweeterService.setTweetRepository(tweetRepository);
		tweeterService.setUserRepository(userRepository);
		
		return tweeterService;
		
	}
	
	
}
