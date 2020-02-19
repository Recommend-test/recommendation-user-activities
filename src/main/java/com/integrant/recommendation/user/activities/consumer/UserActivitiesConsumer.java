package com.integrant.recommendation.user.activities.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrant.recommendation.user.activities.dto.UserActivityDto;
import com.integrant.recommendation.user.activities.exceptions.BadRequestException;
import com.integrant.recommendation.user.activities.service.UserActivitiesServiceImp;

/**
 * The Class UserActivitiesConsumer.
 */
@Component
public class UserActivitiesConsumer {

	/** The user activities service imp. */
	@Autowired
	private UserActivitiesServiceImp userActivitiesServiceImp;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** The object mapper. */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Receive message.
	 *
	 * @param message the message
	 * @throws BadRequestException the bad request exception
	 */
	@RabbitListener(queues="${user.activity.queue.name}")
	public void receiveMessage(String message) throws BadRequestException {

		logger.info("Received {}", message);

		UserActivityDto userActivityDto = null;

		try {

			userActivityDto = objectMapper.readValue(message, UserActivityDto.class);

			logger.info("UserActivityDto {}", userActivityDto);

			userActivitiesServiceImp.validateUserActivityDto(userActivityDto);

			userActivitiesServiceImp.incermentUserActions(userActivityDto);

			logger.info("User Activity Added");

		} catch (IOException e) {

			logger.error("Exception", e);
		}
	}
}

