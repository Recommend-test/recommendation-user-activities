package com.integrant.recommendation.user.activities.constants;

/**
 * The Class AppConstants.
 */
public final class AppConstants {

	  /**
  	 * Instantiates a new app constants.
  	 */
  	private AppConstants() {
		    throw new IllegalStateException("AppConstants class");
		  }
	
	/** The Constant ACTION_ALREADY_EXISTS. */
	public static final String ACTION_ALREADY_EXISTS = "This user action already exists";
	
	/** The Constant INVALID_ACTION_ID. */
	public static final String INVALID_ACTION_ID = "Invalid user action Id";
	
	/** The Constant ACTION_NOT_EXISTS. */
	public static final String ACTION_NOT_EXISTS = "This user action not exists";
	
	/** The Constant INVALID_USER_ACTIVITY. */
	public static final String INVALID_USER_ACTIVITY = "Invalid User Activity";
	
	/** The Constant USER_ID. */
	public static final String USER_ID = "_id";

	/** The Constant PRODUCT_ID. */
	public static final String ACTIONS = ".actions";

	/** The Constant VIEW. */
	public static final String VIEW = ".view";

	/** The Constant ADD_TO_CART. */
	public static final String ADD_TO_CART = ".addToCart";

	/** The Constant CHECKOUT. */
	public static final String CHECKOUT = ".checkout";

	/** The Constant JOIN. */
	public static final String JOIN = ".join";

	/** The Constant SUBSCRIBE. */
	public static final String SUBSCRIBE = ".subscribe";

	/** The Constant PLACE_ORDER. */
	public static final String PLACE_ORDER = ".placeOrder";
	
	/** The Constant PRODUCT_ACTIONS. */
	public static final String PRODUCT_ACTIONS = "product_actions.";
	
	/** The Constant COUNT. */
	public static final String COUNT = ".count";
	
	/** The Constant ACTION_DATE. */
	public static final String ACTION_DATE = ".action_date";

}
