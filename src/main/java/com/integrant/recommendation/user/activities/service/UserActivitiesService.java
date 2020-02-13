package com.integrant.recommendation.user.activities.service;

import com.integrant.recommendation.user.activities.dto.UserActivityDto;
import com.integrant.recommendation.user.activities.model.UserActivity;

public interface UserActivitiesService {
	
	public void incermentUserActions(UserActivityDto userActivityDto);
	
	public UserActivity getUserActivities(String userId);
	
	

}
