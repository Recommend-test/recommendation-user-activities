package com.integrant.recommendation.user.activities.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.integrant.recommendation.user.activities.dto.UserActionDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.model.UserAction;
import com.integrant.recommendation.user.activities.service.UserActionServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
	
	@Autowired
	private UserActionServiceImp userActionServiceImp;
	
	@ApiOperation(value = "Add new User actions weights configuration")
	@PostMapping("/actions")
	public ResponseEntity<Object> saveUserActivity(@Validated @RequestBody UserActionDto userActionDto) throws BadRequestException {
		
		userActionServiceImp.validateUserAction(userActionDto);
		
		String id = userActionServiceImp.saveUserAction(userActionDto.build());
		
		Map<String, Object> body = new LinkedHashMap<>();

		body.put("userActionId", id);

		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "View a list of all user actions", response = List.class)
	@GetMapping("/actions")
	public List<UserAction> getAllActions() {

		return userActionServiceImp.getAllUserActions();
	}

	@ApiOperation(value = "get Product Category by Id")
	@GetMapping("/actions/{id}")
	public UserAction getuserActionyById(@Validated @PathVariable String id) {

		return userActionServiceImp.getUserAction(id);
	}
}
