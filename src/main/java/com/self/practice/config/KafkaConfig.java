package com.self.practice.config;

import com.self.practice.dto.MessageDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;


@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MessageDto> kafkaListenerContainerFactory(
            ConsumerFactory<String, MessageDto> consumerFactory) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, MessageDto>();
        factory.setConsumerFactory(consumerFactory);
        factory.setCommonErrorHandler(errorHandler());
        return factory;
    }

    @Bean
    public CommonErrorHandler errorHandler() {
        return new DefaultErrorHandler(new FixedBackOff(1000L, 3L));
    }
}