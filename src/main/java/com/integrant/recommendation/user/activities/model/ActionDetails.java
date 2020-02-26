package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class Action.
 */

/**
 * Gets the action date.
 *
 * @return the action date
 */
@Getter

/**
 * Instantiates a new action details.
 */
@NoArgsConstructor

/**
 * Instantiates a new action details.
 *
 * @param count the count
 * @param actionDate the action date
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class ActionDetails implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The count. */
	@Field("count")
	private Integer count;
	
	/** The action date. */
	@Field("action_date")
	private List<Date> actionDate;
}
