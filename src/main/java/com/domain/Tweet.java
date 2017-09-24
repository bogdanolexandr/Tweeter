package com.domain;

import java.util.List;

public class Tweet {

	private long tweetId;
	private String text;
	private User user;
	private long likesCount;
	private long retweetCount;
	private List<User> mentions;
	private List<Timeline> timelines;

	public Tweet() {
		
	}
	
	public Tweet(String text, User user, List<User> mentions) {
		this.text = text;
		this.user = user;
		this.mentions = mentions;
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getLikesCount() {
		return likesCount;
	}

	public void addLike() {
		likesCount++;
	}

	public long getRetweetCount() {
		return retweetCount;
	}

	public void addRetweet() {
		retweetCount++;
	}

	public List<User> getMentions() {
		return mentions;
	}

	public void setMentions(List<User> mentions) {
		this.mentions = mentions;
	}

	public List<Timeline> getTimelines() {
		return timelines;
	}

	public void setTimelines(List<Timeline> timelines) {
		this.timelines = timelines;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (likesCount ^ (likesCount >>> 32));
		result = prime * result + ((mentions == null) ? 0 : mentions.hashCode());
		result = prime * result + (int) (retweetCount ^ (retweetCount >>> 32));
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((timelines == null) ? 0 : timelines.hashCode());
		result = prime * result + (int) (tweetId ^ (tweetId >>> 32));
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
		Tweet other = (Tweet) obj;
		if (likesCount != other.likesCount)
			return false;
		if (mentions == null) {
			if (other.mentions != null)
				return false;
		} else if (!mentions.equals(other.mentions))
			return false;
		if (retweetCount != other.retweetCount)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (timelines == null) {
			if (other.timelines != null)
				return false;
		} else if (!timelines.equals(other.timelines))
			return false;
		if (tweetId != other.tweetId)
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
		return "Tweet [tweetId=" + tweetId + ", text=" + text + ", user=" + user + ", likesCount=" + likesCount
				+ ", retweetCount=" + retweetCount + ", mentions=" + mentions + ", timelines=" + timelines + "]";
	}

}
