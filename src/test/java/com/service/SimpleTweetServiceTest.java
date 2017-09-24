package com.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.domain.Timeline;
import com.domain.Tweet;
import com.domain.User;
import com.repository.TimelineRepository;
import com.repository.TweetRepository;
import com.repository.UserRepository;

public class SimpleTweetServiceTest {

	private SimpleTweeterService service;
	private TimelineRepository timelineRepository;
	private UserRepository userRepository;
	private TweetRepository tweetRepository;
	private final long USER_ID = 1;
	private final String TEXT = "message";
	
	@Before
	public void setUp() throws Exception {
		timelineRepository = mock(TimelineRepository.class);
		userRepository = mock(UserRepository.class);
		tweetRepository = mock(TweetRepository.class);		
		service = new SimpleTweeterService();
		service.setTimelineRepository(timelineRepository);
		service.setUserRepository(userRepository);
		service.setTweetRepository(tweetRepository);
	}

	@Test
	public void testGetTimeline() {
		Timeline actual = new Timeline();
		when(timelineRepository.getTimelineByUserId(USER_ID)).thenReturn(actual);
		Timeline expected = service.getTimeline(1);
		verify(timelineRepository,times(1)).getTimelineByUserId(USER_ID);
		assertSame(expected, actual);
	}
	
	@Test
	public void testAddUser() {
		String userName = "UserName";
		service.addUser(userName);
		verify(userRepository,times(1)).addUser(new User(userName));
	}

	@Test
	public void testAddTweet() {
		List<User> mentions = new ArrayList<>();
		service.addTweet(USER_ID,TEXT, mentions);
		verify(tweetRepository,times(1)).addTweet(new Tweet(TEXT,any(),mentions));
	}
		
}
