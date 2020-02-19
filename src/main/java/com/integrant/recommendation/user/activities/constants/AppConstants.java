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

	/** The Constant INVALID_USER_ACTION. */
	public static final String INVALID_USER_ACTION = "Invalid user action";
	
	/** The Constant USER_ID. */
	public static final String USER_ID = "_id";

	/** The Constant PRODUCT_ID. */
	public static final String ACTIONS = ".actions";

	/** The Constant PRODUCT_ACTIONS. */
	public static final String PRODUCT_ACTIONS = "product_actions.";
	
	/** The Constant COUNT. */
	public static final String COUNT = ".count";
	
	/** The Constant ACTION_DATE. */
	public static final String ACTION_DATE = ".action_date";
	
	/** The Constant DOT. */
	public static final String DOT = ".";
}
