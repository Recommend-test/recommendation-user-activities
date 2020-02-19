package com.integrant.recommendation.user.activities.exceptions;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RecommendationException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param message the message
	 */
	public ResourceNotFoundException(String message) {
		super(404, message);
	}

}
