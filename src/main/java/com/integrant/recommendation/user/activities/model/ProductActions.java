package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ProductActions.
 */

/**
 * Gets the actions.
 *
 * @return the actions
 */
@Getter

/**
 * Instantiates a new product actions.
 */
@NoArgsConstructor

/**
 * Instantiates a new product actions.
 *
 * @param productId the product id
 * @param actions the actions
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class ProductActions implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The product id. */
	@Field("product_id")
	private String productId;

	/** The actions. */
	@Field("actions")
	private Map<String, ActionDetails> actions;
}
