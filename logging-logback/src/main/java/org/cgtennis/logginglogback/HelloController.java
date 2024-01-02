package org.cgtennis.logginglogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/")
    public String hello()
    {
        logger.info("Hello from logback in HelloController!!!");
        logger.debug("This is a debug message from HelloController!!!");
        return "Hello, World!";
    }
}
