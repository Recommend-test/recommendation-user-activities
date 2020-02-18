package com.integrant.recommendation.user.activities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrant.recommendation.user.activities.dto.UserActionDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.model.UserAction;
import com.integrant.recommendation.user.activities.repository.UserActionRepository;

/**
 * The Class UserActionServiceImp.
 */
@Service
public class UserActionServiceImp implements UserActionService {

	/** The user action repository. */
	@Autowired
	private UserActionRepository userActionRepository;

	/**
	 * Save user action.
	 *
	 * @param userAction the user action
	 * @return the string
	 */
	@Override
	public String saveUserAction(UserAction userAction) {

		userActionRepository.save(userAction);

		return userAction.getId();
	}

	/**
	 * Gets the user action.
	 *
	 * @param id the id
	 * @return the user action
	 */
	@Override
	public UserAction getUserAction(String id) {
		
		return userActionRepository.findById(id).orElse(null);
	}

	/**
	 * Gets the all user actions.
	 *
	 * @return the all user actions
	 */
	@Override
	public List<UserAction> getAllUserActions() {
		
		return userActionRepository.findAll();
	}

	/**
	 * Validate user action.
	 *
	 * @param userActionDto the user action dto
	 * @throws BadRequestException the bad request exception
	 */
	public void validateUserAction(UserActionDto userActionDto) throws BadRequestException {
		
		UserAction userAction = userActionRepository.findUserActionByActionName(userActionDto.getActionName());
		
		if(userAction != null)
			throw new BadRequestException("This user action already exists");
	}
}

