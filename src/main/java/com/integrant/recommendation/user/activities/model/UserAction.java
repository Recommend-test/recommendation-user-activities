package com.integrant.recommendation.user.activities.model;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("user_actions")
public class UserAction {

	@Id
	@Indexed
	@Field("_id")
	@NotNull(message = "Id must not be null")
	@NotEmpty(message = "Id must not be empty")
	private String id;

	@NotNull(message = "Action Name must not be null")
	@NotEmpty(message = "Action Name must not be empty")
	@Field("action_name")
	private String actionName;

	@NotNull(message = "Action weight must not be null")
	@Field("weight")
	private Integer weight;

	public UserAction(String actionName, Integer weight) {
		this.id = UUID.randomUUID().toString();
		this.actionName = actionName;
		this.weight = weight;
	}

}
