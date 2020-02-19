package com.integrant.recommendation.user.activities.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.integrant.recommendation.user.activities.model.UserAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets the weight.
 *
 * @return the weight
 */
@Getter

/**
 * Sets the weight.
 *
 * @param weight the new weight
 */
@Setter 

/**
 * Instantiates a new user action dto.
 */
@NoArgsConstructor

/**
 * Instantiates a new user action dto.
 *
 * @param id the id
 * @param actionName the action name
 * @param weight the weight
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class UserActionDto {
	
	/** The id. */
	private String id;
	
	/** The action name. */
	@NotNull(message = "User action must not be null")
	@NotEmpty(message = "User action not be empty")
	private String actionName;
	
	/** The weight. */
	@NotNull(message = "Action weight must not be null")
	private Integer weight;

	/**
	 * Builds the.
	 *
	 * @return the user action
	 */
	public UserAction build() {
		return new UserAction(actionName, weight);
	}
	
	/**
	 * Builds the for update.
	 *
	 * @return the user action
	 */
	public UserAction buildForUpdate() {
		return new UserAction(id, actionName, weight);
	}
}
