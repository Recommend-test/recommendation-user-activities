package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

public class ProductActions implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("product_id")
	private String productId;
	
	@Field("actions")
	private Map<String, ActionDetails> actions;

	public ProductActions(String productId, Map<String, ActionDetails> actions) {
		this.productId = productId;
		this.actions = actions;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Map<String, ActionDetails> getActions() {
		return actions;
	}

	public void setActions(Map<String, ActionDetails> actions) {
		this.actions = actions;
	}
}
