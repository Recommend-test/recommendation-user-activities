package com.integrant.recommendation.user.activities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class UserActivitiesApplication.
 */
@SpringBootApplication
public class UserActivitiesApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		/** The logger. */
		Logger logger = LoggerFactory.getLogger(UserActivitiesApplication.class);

		try {

			SpringApplication.run(UserActivitiesApplication.class, args);

			logger.info("Application Started Successfully");

		} catch (Exception e) {

			logger.error("Error occured while starting the applicaion");	
		}
	}
}
