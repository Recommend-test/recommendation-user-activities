package com.integrant.recommendation.user.activities.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integrant.recommendation.user.activities.dto.UserActionDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.exceptions.ResourceNotFoundException;
import com.integrant.recommendation.user.activities.model.UserAction;
import com.integrant.recommendation.user.activities.model.UserActionsPage;
import com.integrant.recommendation.user.activities.service.UserActionServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class UserActionsConfigurationController.
 */
@Api(value="Operations pertaining to User Actions Configuration Management")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved list"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserActionsConfigurationController {
	
	/** The user action service imp. */
	@Autowired
	private UserActionServiceImp userActionServiceImp;
	
	/**
	 * Save user activity.
	 *
	 * @param userActionDto the user action dto
	 * @return the response entity
	 * @throws BadRequestException the bad request exception
	 */
	@ApiOperation(value = "Add new User actions weights configuration")
	@PostMapping("/actions")
	public ResponseEntity<Object> saveUserActivity(@Validated @RequestBody UserActionDto userActionDto) throws BadRequestException {
		
		userActionServiceImp.validateUserActionDto(userActionDto);
		
		String id = userActionServiceImp.saveUserAction(userActionDto.build());
		
		Map<String, Object> body = new LinkedHashMap<>();

		body.put("userActionId", id);

		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	/**
	 * Gets the all actions.
	 *
	 * @return the all actions
	 */
	@ApiOperation(value = "View a list of all user actions", response = List.class)
	@GetMapping("/actions")
	public List<UserAction> getAllActions() {

		return userActionServiceImp.getAllUserActions();
	}

	/**
	 * Gets the user actiony by id.
	 *
	 * @param id the id
	 * @return the user actiony by id
	 */
	@ApiOperation(value = "get User Action by Id")
	@GetMapping("/actions/{id}")
	public UserAction getuserActionyById(@Validated @PathVariable String id) {

		return userActionServiceImp.getUserAction(id);
	}
	
	@ApiOperation(value = "get List of User Action by Offset and Limit")
	@GetMapping("/actions/page")
	public UserActionsPage getUserActionsByOffsetAndLimit(@Validated @RequestParam Integer offset, @Validated @RequestParam Integer limit) {

		return userActionServiceImp.findUserActionsByOffsetAndLimit(offset, limit);
	}
	
	/**
	 * Update user action.
	 *
	 * @param userAction the user action
	 * @return the response entity
	 * @throws BadRequestException the bad request exception
	 * @throws ResourceNotFoundException 
	 */
	@ApiOperation(value = "update User actions weights configuration")
	@PutMapping("/actions")
	public ResponseEntity<Object> updateUserAction(@Validated @RequestBody UserActionDto userActionDto) throws BadRequestException, ResourceNotFoundException {
		
		userActionServiceImp.validateUserActionForUpdate(userActionDto);
		
		userActionServiceImp.saveUserAction(userActionDto.buildForUpdate());

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Delete product category by id.
	 *
	 * @param id the id
	 * @throws DataConflictException the data conflict exception
	 * @throws ResourceNotFoundException 
	 */
	@ApiOperation(value = "delete User Action by Id")
	@DeleteMapping("/actions/{id}")
	public void deleteUserActionById(@Validated @PathVariable String id) throws ResourceNotFoundException {

		userActionServiceImp.deleteUserAction(id);
	}
}
