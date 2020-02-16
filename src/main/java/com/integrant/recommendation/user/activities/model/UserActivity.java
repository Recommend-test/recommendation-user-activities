package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class UserActivity.
 */
@Document("user_activities")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserActivity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@Indexed
	@Field("_id")
	private String userId;

	/** The action. */
	@Field("product_actions")
	private Map<String , ProductActions> productsActions;
	
	/**
	 * Instantiates a new user activity.
	 */
	public UserActivity() {
	}

	/**
	 * Instantiates a new user activity.
	 *
	 * @param userId the user id
	 * @param productsActions the products actions
	 */
	public UserActivity(String userId, Map<String , ProductActions> productsActions) {
		this.userId = userId;
		this.productsActions = productsActions;
	}


	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Gets the products actions.
	 *
	 * @return the products actions
	 */
	public Map<String , ProductActions> getProductsActions() {
		return productsActions;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "UserActivity [userId=" + userId + ", productsActions=" + productsActions + "]";
	}
}
