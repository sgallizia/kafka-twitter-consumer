package it.simonegallizia.kafkatwitterconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import it.simonegallizia.kafkatwitterconsumer.models.Tweet;
import it.simonegallizia.kafkatwitterconsumer.repositories.TweetRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class Consumer {
	@Autowired
	TweetRepository repository;
	
	@KafkaListener(topics = "${app.kafka.topic}")
	public void readTwitter(Tweet tweet) {
		log.info("saving tweet on mongodb " + tweet);
		repository.save(tweet);
	}

}
