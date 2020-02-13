package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.List;
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


	public UserActivity(String userId, Map<String , ProductActions> productsActions) {
		this.userId = userId;
		this.productsActions = productsActions;
	}


	public String getUserId() {
		return userId;
	}

	public Map<String , ProductActions> getProductsActions() {
		return productsActions;
	}
	
}
