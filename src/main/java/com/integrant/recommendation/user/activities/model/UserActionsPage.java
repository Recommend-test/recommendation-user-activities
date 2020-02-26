package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Gets the total count.
 *
 * @return the total count
 */
@Getter

/**
 * Instantiates a new user actions page.
 */
@NoArgsConstructor

/**
 * Instantiates a new user actions page.
 *
 * @param UserActionList the user action list
 * @param totalCount the total count
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class UserActionsPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The User action list. */
	private List<UserAction> userActionList;
	
	/** The total count. */
	private Long totalCount;

}
