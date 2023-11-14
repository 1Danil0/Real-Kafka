package com.danilermolenko.spring.consumer;

import com.danilermolenko.spring.consumer.entity.Wikimedia;
import com.danilermolenko.spring.consumer.repository.WikiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private final WikiRepository wikiRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    @Autowired
    public KafkaDatabaseConsumer(WikiRepository wikiRepository) {
        this.wikiRepository = wikiRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String message){
        Wikimedia wikimedia = new Wikimedia();
        wikimedia.setWikiEventData(message);
        LOGGER.info(String.format("The data \"%s\" was received by database consumer", message));
        wikiRepository.save(wikimedia);
    }
}
