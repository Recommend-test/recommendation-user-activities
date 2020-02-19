package com.integrant.recommendation.user.activities.config;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The Class AppConfig.
 */
@Configuration
public class AppConfig {
	
	/** The rabbit template. */
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * Rabbit admin.
	 *
	 * @return the rabbit admin
	 */
	@Bean
	public RabbitAdmin rabbitAdmin() {
		
		return new RabbitAdmin(rabbitTemplate);
	}

}
