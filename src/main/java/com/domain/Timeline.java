package com.domain;

import java.util.ArrayList;
import java.util.List;

public class Timeline {

	private long timelineId;
	private List<Tweet> tweets;
	private User user;

	public long getTimelineId() {
		return timelineId;
	}

	public void setTimelineId(long timelineId) {
		this.timelineId = timelineId;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addTweet(Tweet tweet) {
		if(tweets == null) {
			tweets = new ArrayList<>();
		}
		tweets.add(tweet);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (timelineId ^ (timelineId >>> 32));
		result = prime * result + ((tweets == null) ? 0 : tweets.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Timeline other = (Timeline) obj;
		if (timelineId != other.timelineId)
			return false;
		if (tweets == null) {
			if (other.tweets != null)
				return false;
		} else if (!tweets.equals(other.tweets))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Timeline [timelineId=" + timelineId + ", tweets=" + tweets + ", user=" + user + "]";
	}

}
