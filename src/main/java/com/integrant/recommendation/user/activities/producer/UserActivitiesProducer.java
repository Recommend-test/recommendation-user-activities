package com.integrant.recommendation.user.activities.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrant.recommendation.user.activities.dto.UserActivityDto;
import com.integrant.recommendation.user.activities.service.RabbitMQProducerService;

/**
 * The Class UserActivitiesProducer.
 */
@Component
public class UserActivitiesProducer {

	/** The user activity exchange name. */
	@Value("${recommendation.exchange.name}")
	private String userActivityExchangeName;

	/** The user activity queue name. */
	@Value("${user.activity.queue.name}")
	private String userActivityQueueName;

	/** The rabbit MQ producer service. */
	@Autowired
	private RabbitMQProducerService rabbitMQProducerService;

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

		rabbitMQProducerService.produceMessage(objectMapper.writeValueAsString(userActivityDto), userActivityQueueName);
	}
}

