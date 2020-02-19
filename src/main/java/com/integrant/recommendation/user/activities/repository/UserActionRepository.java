package com.integrant.recommendation.user.activities.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integrant.recommendation.user.activities.model.UserAction;

/**
 * The Interface UserActionRepository.
 */
@Repository
public interface UserActionRepository extends MongoRepository<UserAction, String> {
	
	/**
	 * Find user action by action name.
	 *
	 * @param actionName the action name
	 * @return the user action
	 */
	public UserAction findUserActionByActionName(String actionName);

}
