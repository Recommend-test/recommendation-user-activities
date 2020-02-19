package com.integrant.recommendation.user.activities.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrant.recommendation.user.activities.dto.UserActivityDto;

/**
 * The Class UserActivitiesProducer.
 */
@Component
public class UserActivitiesProducer {

	/** The user activity exchange name. */
	@Value("${user.activity.exchange.name}")
	private String userActivityExchangeName;

	/** The user activity queue name. */
	@Value("${user.activity.queue.name}")
	private String userActivityQueueName;

	/** The rabbit template. */
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The object mapper. */
	@Autowired
	private ObjectMapper objectMapper;
	
	/**
	 * Send message.
	 *
	 * @param userActivityDto the user activity dto
	 * @throws JsonProcessingException the json processing exception
	 */
	public void sendMessage(UserActivityDto userActivityDto) throws JsonProcessingException {

		logger.info("Sending {}", userActivityDto);

		rabbitTemplate.convertAndSend(userActivityExchangeName, userActivityQueueName, objectMapper.writeValueAsString(userActivityDto));
	}
}

