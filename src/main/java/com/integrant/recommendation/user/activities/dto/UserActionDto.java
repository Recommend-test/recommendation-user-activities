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
 * The Class UserActionDto.
 */
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
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
