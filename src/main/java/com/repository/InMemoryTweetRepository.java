package com.repository;

import java.util.HashSet;
import java.util.Set;

import com.domain.Tweet;

public class InMemoryTweetRepository implements TweetRepository {

	private static long ID_GENERATOR = 1;
	private Set<Tweet> tweets = new HashSet<>();
	
	@Override
	public void addTweet(Tweet tweet) {
		tweet.setTweetId(ID_GENERATOR);
		ID_GENERATOR++;
		tweets.add(tweet);
		System.out.println(tweets);
	}

	@Override
	public Tweet getTweet(long tweetId) {
		
		for(Tweet tweet : tweets) {
			if(tweet.getTweetId() == tweetId) {
				return tweet;
			}
		}
		return new Tweet();
	}

	@Override
	public void updateTweet(Tweet tweet) {
		tweets.add(tweet);
	}

	@Override
	public Iterable<Tweet> allTweets() {
		return tweets;
	}

}
