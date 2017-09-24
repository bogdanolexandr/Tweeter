package com.service;

import java.util.List;

import com.domain.Timeline;
import com.domain.Tweet;
import com.domain.User;
import com.repository.TimelineRepository;
import com.repository.TweetRepository;
import com.repository.UserRepository;

public class SimpleTweeterService implements TweeterService {

	private TweetRepository tweetRepository;

	private TimelineRepository timelineRepository;

	private UserRepository userRepository;

	@Override
	public Timeline getTimeline(long userId) {
		return timelineRepository.getTimelineByUserId(userId);
	}

	@Override
	public void addUser(String name) {
		User user = new User(name);
		userRepository.addUser(user);
	}

	@Override
	public User getUser(long userId) {
		return userRepository.getUser(userId);
	}

	@Override
	public void addTweet(long userId, String text, List<User> mentions) {
		
		System.out.println("--------------");
		User user = userRepository.getUser(userId);
		Tweet tweet = new Tweet(text, user, mentions);
		tweetRepository.addTweet(tweet);
	}

	@Override
	public Tweet getTweet(long tweetId) {
		return tweetRepository.getTweet(tweetId);
	}

	@Override
	public void addLike(long tweetId) {
		Tweet tweet = tweetRepository.getTweet(tweetId);
		System.out.println(tweet);
		tweet.addLike();
		System.out.println("=-=-=-=-=-=");
		tweetRepository.updateTweet(tweet);
	}

	@Override
	public void retweet(long userId, long tweetId) {
		User user = userRepository.getUser(userId);
		Tweet tweet = tweetRepository.getTweet(tweetId);
		Timeline timeline = user.getTimeline();
		timeline.addTweet(tweet);
		timelineRepository.updateTimeline(timeline);
	}

	public void setTweetRepository(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public void setTimelineRepository(TimelineRepository timelineRepository) {
		this.timelineRepository = timelineRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
