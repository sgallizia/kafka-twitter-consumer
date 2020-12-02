# kafka-twitter-consumer
This Spring Boot project is an example of Kafka consumer. It reads tweets from a kafka topic and write them on mongo db. For an example of producer please visit [this project](https://github.com/sgallizia/kafka-twitter-producer).
## Quickstart
You must have [this project](https://github.com/sgallizia/kafka-twitter-producer) up & running.

You must have MongoDB installed.

Change the property app.kafka.topic in application.yml with the right topic.

Start the Spring Boot Application.