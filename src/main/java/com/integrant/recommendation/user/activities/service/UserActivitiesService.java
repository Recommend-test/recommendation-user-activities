package com.integrant.recommendation.user.activities.service;

import com.integrant.recommendation.user.activities.dto.UserActivityDto;
import com.integrant.recommendation.user.activities.model.UserActivity;

/**
 * The Interface UserActivitiesService.
 */
public interface UserActivitiesService {
	
	/**
	 * Incerment user actions.
	 *
	 * @param userActivityDto the user activity dto
	 */
	public void incermentUserActions(UserActivityDto userActivityDto);
	
	/**
	 * Gets the user activities.
	 *
	 * @param userId the user id
	 * @return the user activities
	 */
	public UserActivity getUserActivities(String userId);
}
