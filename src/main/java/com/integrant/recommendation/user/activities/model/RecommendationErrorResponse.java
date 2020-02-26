package com.integrant.recommendation.user.activities.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class RecommendationErrorResponse.
 */

/**
 * Gets the error.
 *
 * @return the error
 */
@Getter

/**
 * Instantiates a new recommendation error response.
 */
@NoArgsConstructor

/**
 * Instantiates a new recommendation error response.
 *
 * @param timestamp the timestamp
 * @param status the status
 * @param error the error
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class RecommendationErrorResponse {

	/** The timestamp. */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private LocalDateTime timestamp;
	
	/** The status. */
	private int status;
	
	/** The error. */
	private String error;
}

