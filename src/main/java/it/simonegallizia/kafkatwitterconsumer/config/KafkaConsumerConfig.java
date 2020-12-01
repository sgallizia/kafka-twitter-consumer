package it.simonegallizia.kafkatwitterconsumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import it.simonegallizia.kafkatwitterconsumer.models.Tweet;

@Configuration
public class KafkaConsumerConfig {
	@Bean
	  public Map<String, Object> consumerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "json");	
	    return props;
	  }
	
	  @Bean
	  public ConsumerFactory<String, Tweet> consumerFactory() {
		  JsonDeserializer<Tweet> jsonDeserializer = new JsonDeserializer<>(Tweet.class);
		  jsonDeserializer.addTrustedPackages("*");
		  jsonDeserializer.setRemoveTypeHeaders(false);
		  jsonDeserializer.setUseTypeMapperForKey(true);
	    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(),
	    		jsonDeserializer);
	  }
	
	  @Bean
	  public ConcurrentKafkaListenerContainerFactory<String, Tweet> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<String, Tweet> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());
	
	    return factory;
	  }

}
