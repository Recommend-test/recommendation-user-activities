package com.integrant.recommendation.user.activities.model;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Gets the weight.
 *
 * @return the weight
 */
@Getter

/**
 * Instantiates a new user action.
 */
@NoArgsConstructor

/**
 * Instantiates a new user action.
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
@Document("user_actions")
public class UserAction {

	/** The id. */
	@Id
	@Indexed
	@Field("_id")
	@NotNull(message = "Id must not be null")
	@NotEmpty(message = "Id must not be empty")
	private String id;

	/** The action name. */
	@NotNull(message = "Action Name must not be null")
	@NotEmpty(message = "Action Name must not be empty")
	@Field("action_name")
	private String actionName;

	/** The weight. */
	@NotNull(message = "Action weight must not be null")
	@Field("weight")
	private Integer weight;

	/**
	 * Instantiates a new user action.
	 *
	 * @param actionName the action name
	 * @param weight the weight
	 */
	public UserAction(String actionName, Integer weight) {
		this.id = UUID.randomUUID().toString();
		this.actionName = actionName;
		this.weight = weight;
	}

}
