package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class ProductActions.
 */
public class ProductActions implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The product id. */
	@Field("product_id")
	private String productId;
	
	/** The actions. */
	@Field("actions")
	private Map<String, ActionDetails> actions;

	/**
	 * Instantiates a new product actions.
	 *
	 * @param productId the product id
	 * @param actions the actions
	 */
	public ProductActions(String productId, Map<String, ActionDetails> actions) {
		this.productId = productId;
		this.actions = actions;
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
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Gets the actions.
	 *
	 * @return the actions
	 */
	public Map<String, ActionDetails> getActions() {
		return actions;
	}

	/**
	 * Sets the actions.
	 *
	 * @param actions the actions
	 */
	public void setActions(Map<String, ActionDetails> actions) {
		this.actions = actions;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ProductActions [productId=" + productId + ", actions=" + actions + "]";
	}
}
