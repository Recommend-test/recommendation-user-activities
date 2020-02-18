package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ProductActions.
 */
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
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
