package com.example.sayhello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class WebController {

    public static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/greeting")
    public String greet() {
        logger.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there!", "Ciao", "Hallo", "Bonjour", "Xin chao");

        Random random = new Random();
        int num = random.nextInt(greetings.size());
        return greetings.get(num);
    }

    /**
     * for ribbon client side load balancing to check for server availability.
     * @return
     */
    @RequestMapping("/")
    public String home() {
        logger.info("Accessing /");
        return "Hello";
    }
}
