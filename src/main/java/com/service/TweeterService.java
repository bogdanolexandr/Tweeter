package com.service;

import java.util.List;

import com.domain.Timeline;
import com.domain.Tweet;
import com.domain.User;

public interface TweeterService {

	public Timeline getTimeline(long userId);

	public void addUser(String name);
	
	public User getUser(long userId);

	public void addTweet(long userId, String text, List<User> mentions);
	
	public Tweet getTweet(long tweetId);
	
	public void addLike(long tweetId);
	
	public void retweet(long userId, long tweetId);
	
}
