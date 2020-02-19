package com.integrant.recommendation.user.activities.service;

import java.util.List;

import com.integrant.recommendation.user.activities.dto.UserActionDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.model.UserAction;

/**
 * The Interface UserActionService.
 */
public interface UserActionService {
	
	/**
	 * Save user action.
	 *
	 * @param userAction the user action
	 * @return the string
	 */
	public String saveUserAction(UserAction userAction);
	
	/**
	 * Gets the user action.
	 *
	 * @param id the id
	 * @return the user action
	 */
	public UserAction getUserAction(String id);
	
	/**
	 * Gets the all user actions.
	 *
	 * @return the all user actions
	 */
	public List<UserAction> getAllUserActions();
	
	/**
	 * Validate user action.
	 *
	 * @param userActionDto the user action dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateUserActionDto(UserActionDto userActionDto) throws BadRequestException;
	
	/**
	 * Validate user action for update.
	 *
	 * @param userActionDto the user action dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateUserActionForUpdate(UserActionDto userActionDto) throws BadRequestException;
}
