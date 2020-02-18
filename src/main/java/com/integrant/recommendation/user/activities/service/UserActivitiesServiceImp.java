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
import com.integrant.recommendation.user.activities.model.UserActivity;
import com.integrant.recommendation.user.activities.repository.UserActivityRepository;

/**
 * The Class UserActivitiesServiceImp.
 */
@Service
public class UserActivitiesServiceImp implements UserActivitiesService {

	/** The user activity repository. */
	@Autowired
	private UserActivityRepository userActivityRepository;

	/** The mongo operation. */
	@Autowired
	private MongoOperations mongoOperation;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The Constant USER_ID. */
	private static final String USER_ID = "_id";

	/** The Constant PRODUCT_ID. */
	private static final String ACTIONS = ".actions";

	/** The Constant VIEW. */
	private static final String VIEW = ".view";

	/** The Constant ADD_TO_CART. */
	private static final String ADD_TO_CART = ".addToCart";

	/** The Constant CHECKOUT. */
	private static final String CHECKOUT = ".checkout";

	/** The Constant JOIN. */
	private static final String JOIN = ".join";

	/** The Constant SUBSCRIBE. */
	private static final String SUBSCRIBE = ".subscribe";

	/** The Constant PLACE_ORDER. */
	private static final String PLACE_ORDER = ".placeOrder";
	
	/** The Constant PRODUCT_ACTIONS. */
	private static final String PRODUCT_ACTIONS = "product_actions.";
	
	/** The Constant COUNT. */
	private static final String COUNT = ".count";
	
	/** The Constant ACTION_DATE. */
	private static final String ACTION_DATE = ".action_date";

	/**
	 * Incerment user actions.
	 *
	 * @param userActivityDto the user activity dto
	 */
	@Override
	public void incermentUserActions(UserActivityDto userActivityDto) {

		UserActivity currentUserActivity = getUserActivities(userActivityDto.getUserId());

		if(currentUserActivity == null) {

			UserActivity userActivity = userActivityDto.build();

			userActivityRepository.save(userActivity);
		}

		else {

			Query query = new Query();

			query.addCriteria(Criteria.where(USER_ID).is(userActivityDto.getUserId()));

			Update update = new Update();

			if(userActivityDto.hasAction("view")) {
				update.inc(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + VIEW + COUNT, 1);
				update.addToSet(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + VIEW + ACTION_DATE, userActivityDto.getTimeStamp());
			}

			if(userActivityDto.hasAction("addToCart")) {
				update.inc(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + ADD_TO_CART + COUNT, 1);
				update.addToSet(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + ADD_TO_CART + ACTION_DATE, userActivityDto.getTimeStamp());
			}

			if(userActivityDto.hasAction("checkout")) {
				update.inc(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + CHECKOUT + COUNT, 1);
				update.addToSet(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + CHECKOUT + ACTION_DATE, userActivityDto.getTimeStamp());
			}

			if(userActivityDto.hasAction("join")) {
				update.inc(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + JOIN + COUNT, 1);
				update.addToSet(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + JOIN + ACTION_DATE, userActivityDto.getTimeStamp());
			}

			if(userActivityDto.hasAction("subscribe")) {
				update.inc(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + SUBSCRIBE + COUNT, 1);
				update.addToSet(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + SUBSCRIBE + ACTION_DATE, userActivityDto.getTimeStamp());
			}

			if(userActivityDto.hasAction("placeOrder")) {
				update.inc(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + PLACE_ORDER + COUNT, 1);
				update.addToSet(PRODUCT_ACTIONS + userActivityDto.getProductId() + ACTIONS + PLACE_ORDER + ACTION_DATE, userActivityDto.getTimeStamp());
			}

			UserActivity userActivityUpdated = mongoOperation.findAndModify(query, update, 
					new FindAndModifyOptions().returnNew(true), UserActivity.class);

			logger.info("userActivityUpdated - " + userActivityUpdated);
		}
	}

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
	 * Validate user activity dto.
	 *
	 * @param userActivityDto the user activity dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateUserActivityDto(UserActivityDto userActivityDto) throws BadRequestException {

		if(!userActivityDto.checkValidity())
			throw new BadRequestException(AppConstants.INVALID_USER_ACTIVITY);
	}

}
