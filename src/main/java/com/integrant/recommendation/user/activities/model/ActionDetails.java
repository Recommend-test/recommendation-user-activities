package com.integrant.recommendation.user.activities.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class Action.
 */
public class ActionDetails implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The count. */
	@Field("count")
	private Integer count;
	
	/** The action date. */
	@Field("action_date")
	private List<Date> actionDate;

	/**
	 * Instantiates a new action details.
	 *
	 * @param count the count
	 * @param actionDate the action date
	 */
	public ActionDetails(Integer count, List<Date> actionDate) {
		this.count = count;
		this.actionDate = actionDate;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * Gets the action date.
	 *
	 * @return the action date
	 */
	public List<Date> getActionDate() {
		return actionDate;
	}

	/**
	 * Sets the action date.
	 *
	 * @param actionDate the new action date
	 */
	public void setActionDate(List<Date> actionDate) {
		this.actionDate = actionDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ActionDetails [count=" + count + ", actionDate=" + actionDate + "]";
	}
}
