package com.integrant.recommendation.user.activities.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.integrant.recommendation.user.activities.model.UserAction;

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
public class UserActionDto {
	
	@NotNull(message = "User action must not be null")
	@NotEmpty(message = "User action not be empty")
	private String actionName;
	
	@NotNull(message = "Action weight must not be null")
	private Integer weight;

	public UserAction build() {
		return new UserAction(actionName, weight);
	}
}
