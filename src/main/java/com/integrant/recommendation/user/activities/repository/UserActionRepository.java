package com.integrant.recommendation.user.activities.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integrant.recommendation.user.activities.model.UserAction;

@Repository
public interface UserActionRepository extends MongoRepository<UserAction, String> {
	
	public UserAction findUserActionByActionName(String actionName);

}
