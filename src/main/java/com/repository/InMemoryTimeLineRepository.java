package com.repository;

import java.util.HashSet;
import java.util.Set;

import com.domain.Timeline;

public class InMemoryTimeLineRepository implements TimelineRepository {
	
	private static long ID_GENERATOR = 1;
	private Set<Timeline> timelines = new HashSet<>();
	
	@Override
	public void addTimeline(Timeline timeline) {
		timeline.setTimelineId(ID_GENERATOR);
		ID_GENERATOR++;
		timelines.add(timeline);
	}

	@Override
	public void updateTimeline(Timeline timeline) {
		timelines.add(timeline);
	}

	@Override
	public Timeline getTimelineByUserId(long userId) {
		for(Timeline timeline : timelines) {
			if(timeline.getTimelineId() == userId) {
				return timeline;
			}
		}
		return new Timeline();
	}

}
