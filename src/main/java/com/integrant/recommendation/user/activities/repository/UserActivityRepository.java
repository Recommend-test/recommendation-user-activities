package com.integrant.recommendation.user.activities.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.integrant.recommendation.user.activities.model.UserActivity;

/**
 * The Interface UserActivityRepository.
 */
@Repository
public interface UserActivityRepository extends MongoRepository<UserActivity, String> {

}
