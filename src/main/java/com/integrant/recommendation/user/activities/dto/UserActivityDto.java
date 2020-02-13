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

	private static final String VIEW = "view";

	private static final String ADD_TO_CART = "addToCart";

	private static final String CHECKOUT = "checkout";

	private static final String JOIN = "join";

	private static final String SUBSCRIBE = "subscribe";

	private static final String PLACE_ORDER = "placeOrder";

	public UserActivityDto(String userId, String productId, String action, Date timeStamp) {
		this.userId = userId;
		this.productId = productId;
		this.action = action;
		this.timeStamp = timeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public String getProductId() {
		return productId;
	}

	public String getAction() {
		return action;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public boolean isValid() {
		return userId != null && productId != null && action != null && timeStamp != null;
	}

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

	public boolean hasAction(String actionName) {
		return action.equalsIgnoreCase(actionName);
	}
}
