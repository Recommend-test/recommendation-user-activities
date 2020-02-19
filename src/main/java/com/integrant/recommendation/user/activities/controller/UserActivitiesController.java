package com.integrant.recommendation.user.activities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.integrant.recommendation.user.activities.dto.UserActivityDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.model.UserActivity;
import com.integrant.recommendation.user.activities.producer.UserActivitiesProducer;
import com.integrant.recommendation.user.activities.service.UserActivitiesServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class UserActivitiesController.
 */
@Api(value="Operations pertaining to User Activity Management")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserActivitiesController {

		/** The user activities service imp. */
		@Autowired
		private UserActivitiesServiceImp userActivitiesServiceImp;
		
		/** The user activities producer. */
		@Autowired
		private UserActivitiesProducer userActivitiesProducer;

		/**
		 * Save user activity.
		 *
		 * @param userActivityDto the user activity dto
		 * @return the response entity
		 * @throws BadRequestException the bad request exception
		 * @throws JsonProcessingException the json processing exception
		 */
		@ApiOperation(value = "Add new User Activity")
		@PostMapping("/activities")
		public ResponseEntity<Object> saveUserActivity(@Validated @RequestBody UserActivityDto userActivityDto) throws BadRequestException, JsonProcessingException {
			
			userActivitiesServiceImp.validateUserActivityDto(userActivityDto);

			userActivitiesProducer.sendMessage(userActivityDto);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}

		/**
		 * Gets the user activity by user id.
		 *
		 * @param userId the user id
		 * @return the user activity by user id
		 */
		@ApiOperation(value = "get User Activity By User Id")
		@GetMapping("/activities/{userId}")
		public UserActivity getUserActivityByUserId(@Validated @PathVariable String userId) {

			return userActivitiesServiceImp.getUserActivities(userId);
		}
}
