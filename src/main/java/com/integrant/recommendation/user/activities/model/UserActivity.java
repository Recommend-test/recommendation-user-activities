package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class UserActivity.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("user_activities")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserActivity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@Indexed
	@Field("_id")
	private String userId;

	/** The action. */
	@Field("product_actions")
	private Map<String , ProductActions> productsActions;
}
