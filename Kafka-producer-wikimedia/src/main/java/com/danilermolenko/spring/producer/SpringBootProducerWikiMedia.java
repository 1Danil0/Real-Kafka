package com.danilermolenko.spring.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerWikiMedia implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerWikiMedia.class, args);
    }

    @Autowired
    private WikiMediaChangesProducer producer;

    @Override
    public void run(String... args) throws Exception {
        producer.sent();
    }
}
