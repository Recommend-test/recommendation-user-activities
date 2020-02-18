package com.integrant.recommendation.user.activities.model;

import java.util.UUID;

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
	private String id;
	
	@Field("action_name")
	private String actionName;
	
	@Field("weight")
	private Integer weight;

	public UserAction(String actionName, Integer weight) {
		this.id = UUID.randomUUID().toString();
		this.actionName = actionName;
		this.weight = weight;
	}

}
