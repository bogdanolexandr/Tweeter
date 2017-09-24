package com.Tweeter;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.RepositoryConfig;
import com.config.ServiceConfig;
import com.domain.Timeline;
import com.domain.Tweet;
import com.domain.User;
import com.repository.TimelineRepository;
import com.repository.TweetRepository;
import com.repository.UserRepository;
import com.service.SimpleTweeterService;
import com.service.TweeterService;

public class App {
	
	private static final long USER_ID = 1;
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext repoAc = new AnnotationConfigApplicationContext(RepositoryConfig.class);
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ServiceConfig.class);
		ac.setParent(repoAc);
		ac.refresh();
		
		TweeterService service = ac.getBean(SimpleTweeterService.class);
		UserRepository userRepo = (UserRepository) ac.getBean("userRepository");
		TweetRepository tweetRepo = (TweetRepository) ac.getBean("tweetRepository");
		TimelineRepository timelineRepo = (TimelineRepository) ac.getBean("timelineRepository");
		
		service.addUser("first user");
		service.addUser("second user");
		
		User user = userRepo.getUser(1);
		Tweet tweet = new Tweet("my tweet",user,new ArrayList<>());
		
		tweetRepo.addTweet(tweet);
		tweet = tweetRepo.getTweet(1);
		tweet.addLike();
		tweetRepo.updateTweet(tweet);
		
		Timeline timeline = new Timeline();
		timeline.setUser(user);
		
		timelineRepo.addTimeline(timeline);
		
		timeline = timelineRepo.getTimelineByUserId(USER_ID);
		timeline.addTweet(tweet);
		
		timelineRepo.updateTimeline(timeline);
		
		
		System.out.println(tweetRepo.getTweet(USER_ID));
		System.out.println(timelineRepo.getTimelineByUserId(USER_ID));
		
	}
}
