package com.integrant.recommendation.user.activities.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.integrant.recommendation.user.activities.model.ActionDetails;
import com.integrant.recommendation.user.activities.model.ProductActions;
import com.integrant.recommendation.user.activities.model.UserActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class UserActivityDto.
 */
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserActivityDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@NotNull(message = "User Id must not be null")
	@NotEmpty(message = "User Id must not be empty")
	private String userId;

	/** The product id. */
	@NotNull(message = "Product Id must not be null")
	@NotEmpty(message = "Product Id must not be empty")
	private String productId;

	/** The action. */
	@NotNull(message = "Action must not be null")
	@NotEmpty(message = "Action must not be empty")
	private String action;

	/** The time stamp. */
	@NotNull(message = "Action time must not be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
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
}
