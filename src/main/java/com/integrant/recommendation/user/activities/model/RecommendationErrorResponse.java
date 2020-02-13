package com.integrant.recommendation.user.activities.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

/**
 * The Class RecommendationErrorResponse.
 */
public class RecommendationErrorResponse {

	/** The timestamp. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	
	/** The status. */
	private int status;
	
	/** The error. */
	private String error;

	/**
	 * Instantiates a new recommendation error response.
	 *
	 * @param timestamp the timestamp
	 * @param status the status
	 * @param error the error
	 */
	public RecommendationErrorResponse(LocalDateTime timestamp, int status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;

	}
	
	/**
	 * Gets the error.
	 *
	 * @return the error
	 */
	public String getError() {
		return error;
	}
}

