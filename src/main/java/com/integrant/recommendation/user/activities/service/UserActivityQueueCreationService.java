package com.integrant.recommendation.user.activities.service;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The Class UserActivityQueueCreationService.
 */
@Service
public class UserActivityQueueCreationService {
	
	/** The recommendation exchange name. */
	@Value("${recommendation.exchange.name}")
	private String recommendationExchangeName;
	
	/** The user activity queue name. */
	@Value("${user.activity.queue.name}")
	private String userActivityQueueName;
	
	/** The rabbit admin. */
	@Autowired
	private RabbitAdmin rabbitAdmin;
	
	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		
		DirectExchange exchange = new DirectExchange(recommendationExchangeName);

		rabbitAdmin.declareExchange(exchange);
		
		rabbitAdmin.declareQueue(new Queue(userActivityQueueName));
		
		rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue(userActivityQueueName)).to(exchange).with(userActivityQueueName));
	}

}
