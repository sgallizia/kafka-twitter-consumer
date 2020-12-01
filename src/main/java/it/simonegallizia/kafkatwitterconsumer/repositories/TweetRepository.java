package it.simonegallizia.kafkatwitterconsumer.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.simonegallizia.kafkatwitterconsumer.models.Tweet;

public interface TweetRepository extends MongoRepository<Tweet, String> {

}
