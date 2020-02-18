package com.integrant.recommendation.user.activities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.integrant.recommendation.user.activities.model.ActionDetails;
import com.integrant.recommendation.user.activities.model.ProductActions;
import com.integrant.recommendation.user.activities.model.UserActivity;

/**
 * The Class UserActivityDto.
 */
public class UserActivityDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	private String userId;

	/** The product id. */
	private String productId;

	/** The action. */
	private String action;

	/** The time stamp. */
	@JsonFormat
	(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date timeStamp;

	/** The Constant VIEW. */
	private static final String VIEW = "view";

	/** The Constant ADD_TO_CART. */
	private static final String ADD_TO_CART = "addToCart";

	/** The Constant CHECKOUT. */
	private static final String CHECKOUT = "checkout";

	/** The Constant JOIN. */
	private static final String JOIN = "join";

	/** The Constant SUBSCRIBE. */
	private static final String SUBSCRIBE = "subscribe";

	/** The Constant PLACE_ORDER. */
	private static final String PLACE_ORDER = "placeOrder";
	
	public UserActivityDto() {
	}

	/**
	 * Instantiates a new user activity dto.
	 *
	 * @param userId the user id
	 * @param productId the product id
	 * @param action the action
	 * @param timeStamp the time stamp
	 */
	public UserActivityDto(String userId, String productId, String action, Date timeStamp) {
		this.userId = userId;
		this.productId = productId;
		this.action = action;
		this.timeStamp = timeStamp;
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
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Gets the time stamp.
	 *
	 * @return the time stamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	public boolean checkValidity() {
		return userId != null && productId != null && action != null && timeStamp != null;
	}

	/**
	 * Builds the.
	 *
	 * @return the user activity
	 */
	public UserActivity build() {

		Map<String , ProductActions> productsActionsMap = new HashMap<>();

		Map<String, ActionDetails> actionsMap = new HashMap<>();

		createAction(actionsMap, VIEW);
		
		createAction(actionsMap, ADD_TO_CART);

		createAction(actionsMap, CHECKOUT);

		createAction(actionsMap, JOIN);

		createAction(actionsMap, SUBSCRIBE);

		createAction(actionsMap, PLACE_ORDER);

		ProductActions productActions = new ProductActions(productId, actionsMap);

		productsActionsMap.put(productId, productActions);

		return new UserActivity(userId, productsActionsMap);
	}

	/**
	 * Creates the action.
	 *
	 * @param actionsMap the actions map
	 * @param actionName the action name
	 */
	private void createAction(Map<String, ActionDetails> actionsMap, String actionName) {

		ActionDetails viewDetails;

		List<Date> dates = new ArrayList<>();

		if(action.equalsIgnoreCase(actionName)) {

			dates.add(timeStamp);

			viewDetails = new ActionDetails(1, dates);
		}

		else {

			viewDetails = new ActionDetails(0, null);
		}

		actionsMap.put(actionName, viewDetails);
	}

	/**
	 * Checks for action.
	 *
	 * @param actionName the action name
	 * @return true, if successful
	 */
	public boolean hasAction(String actionName) {
		return action.equalsIgnoreCase(actionName);
	}

	@Override
	public String toString() {
		return "UserActivityDto [userId=" + userId + ", productId=" + productId + ", action=" + action + ", timeStamp="
				+ timeStamp + "]";
	}
}
