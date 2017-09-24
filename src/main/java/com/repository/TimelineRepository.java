package com.repository;

import com.domain.Timeline;

public interface TimelineRepository {

	public void addTimeline(Timeline timeline);
	
	public void updateTimeline(Timeline timeline);
	
	public Timeline getTimelineByUserId(long userId);
	
}
