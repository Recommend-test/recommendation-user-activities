package com.integrant.recommendation.user.activities.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.integrant.recommendation.user.activities.constants.AppConstants;
import com.integrant.recommendation.user.activities.dto.UserActivityDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.model.UserAction;
import com.integrant.recommendation.user.activities.model.UserActivity;
import com.integrant.recommendation.user.activities.repository.UserActionRepository;
import com.integrant.recommendation.user.activities.repository.UserActivityRepository;

/**
 * The Class UserActivitiesServiceImp.
 */
@Service
public class UserActivitiesServiceImp implements UserActivitiesService {

	/** The user activity repository. */
	@Autowired
	private UserActivityRepository userActivityRepository;

	/** The user action repository. */
	@Autowired
	private UserActionRepository userActionRepository;

	/** The mongo operation. */
	@Autowired
	private MongoOperations mongoOperation;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Gets the user activities.
	 *
	 * @param userId the user id
	 * @return the user activities
	 */
	@Override
	public UserActivity getUserActivities(String userId) {
		return userActivityRepository.findById(userId).orElse(null);
	}

	/**
	 * Incerment user actions.
	 *
	 * @param userActivityDto the user activity dto
	 */
	@Override
	public void incermentUserActions(UserActivityDto userActivityDto) {

		String actionName = userActivityDto.getAction();

		UserActivity currentUserActivity = getUserActivities(userActivityDto.getUserId());

		if(currentUserActivity == null) {

			UserActivity userActivity = userActivityDto.build(actionName);

			userActivityRepository.save(userActivity);
		}

		else {


			Query query = new Query();

			query.addCriteria(Criteria.where(AppConstants.USER_ID).is(userActivityDto.getUserId()));

			Update update = new Update();

			update.inc(AppConstants.PRODUCT_ACTIONS + userActivityDto.getProductId() + AppConstants.ACTIONS + AppConstants.DOT + actionName + AppConstants.COUNT, 1);
			
			update.addToSet(AppConstants.PRODUCT_ACTIONS + userActivityDto.getProductId() + AppConstants.ACTIONS + AppConstants.DOT + actionName + AppConstants.ACTION_DATE, userActivityDto.getTimeStamp());

			UserActivity userActivityUpdated = mongoOperation.findAndModify(query, update, 
					new FindAndModifyOptions().returnNew(true), UserActivity.class);

			logger.info("userActivityUpdated {}" , userActivityUpdated);
		}
	}

	/**
	 * Validate user activity dto.
	 *
	 * @param userActivityDto the user activity dto
	 * @throws BadRequestException the bad request exception
	 */
	@Override
	public void validateUserActivityDto(UserActivityDto userActivityDto) throws BadRequestException {

		if(!userActivityDto.checkValidity())
			throw new BadRequestException(AppConstants.INVALID_USER_ACTIVITY);

		if(!checkUserActionMatchingStatus(userActivityDto.getAction()))
			throw new BadRequestException(AppConstants.INVALID_USER_ACTION);
	}

	/**
	 * Check user action matching status.
	 *
	 * @param actionName the action name
	 * @return true, if successful
	 */
	@Override
	public boolean checkUserActionMatchingStatus(String actionName) {

		UserAction userAction =  userActionRepository.findUserActionByActionName(actionName);

		return userAction != null;
	}

}
