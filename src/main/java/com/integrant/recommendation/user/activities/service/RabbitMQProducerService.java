package com.integrant.recommendation.user.activities.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The Class RabbitMQProducerService.
 */
@Service
public class RabbitMQProducerService {

	/** The user activity exchange name. */
	@Value("${recommendation.exchange.name}")
	private String recommendationExchangeName;

	/** The rabbit template. */
	@Autowired
	private RabbitTemplate rabbitTemplate;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Produce message.
	 *
	 * @param message the message
	 * @param routingKey the routing key
	 */
	public void produceMessage(String message, String routingKey) {

		logger.info("Sending {}", message);

		rabbitTemplate.convertAndSend(recommendationExchangeName, routingKey, message);
	}
}
