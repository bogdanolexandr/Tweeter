package com.repository;

import com.domain.Tweet;

public interface TweetRepository {

	public void addTweet(Tweet tweet);
	
	public Tweet getTweet(long tweetId);
	
	public void updateTweet(Tweet tweet);
	
	public Iterable<Tweet> allTweets();
	
}
