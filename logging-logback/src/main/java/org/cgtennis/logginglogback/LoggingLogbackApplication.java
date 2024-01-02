package org.cgtennis.logginglogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingLogbackApplication {

	private static final Logger log = LoggerFactory.getLogger(LoggingLogbackApplication.class);

	public static void main(String[] args) {

		log.info("*************************************");
		log.info("    This is a test from CGW ");
		log.info("***********************************");

		SpringApplication.run(LoggingLogbackApplication.class, args);

		log.info("*************************************");
		log.info("    This is a Another test from CGW ");
		log.info("***********************************");
	}

}
