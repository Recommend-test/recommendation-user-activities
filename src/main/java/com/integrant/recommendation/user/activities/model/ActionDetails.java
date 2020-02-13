package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class Action.
 */
public class ActionDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("count")
	private Integer count;
	
	@Field("action_date")
	private List<Date> actionDate;

	public ActionDetails(Integer count, List<Date> actionDate) {
		this.count = count;
		this.actionDate = actionDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Date> getActionDate() {
		return actionDate;
	}

	public void setActionDate(List<Date> actionDate) {
		this.actionDate = actionDate;
	}
}
