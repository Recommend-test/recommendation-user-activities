package com.integrant.recommendation.user.activities.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.integrant.recommendation.user.activities.dto.UserActivityDto;

@Component
public class UserActivitiesProducer {

	@Value("${user.activity.exchange.name}")
	private String userActivityExchangeName;

	@Value("${user.activity.queue.name}")
	private String userActivityQueueName;

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void sendMessage(UserActivityDto userActivityDto) throws AmqpException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		logger.info("Send msg = " + objectMapper.writeValueAsString(userActivityDto));
		
		rabbitTemplate.convertAndSend(userActivityExchangeName, userActivityQueueName, objectMapper.writeValueAsString(userActivityDto));
	}
}

