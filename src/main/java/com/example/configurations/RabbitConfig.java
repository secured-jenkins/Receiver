package com.example.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.example.DTO.CarDTO;
import com.example.DTO.EmployeeDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;

import java.util.List;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitConfig implements RabbitListenerConfigurer {
	final static String queueName = "spring-boot";
	final static String queueName2 = "summer-boot";

	@Bean(name = "firstQueue")
	Queue queue() {
		Queue x = new Queue(queueName, false);
//		x.addArgument("x-max-length", 5);
//		x.addArgument("x-message-ttl", Integer.parseUnsignedInt("1000"));
		return x;
	}

	@Bean(name = "secondQueue")
	Queue queue2() {
		Queue x = new Queue(queueName2, false);
//		x.addArgument("x-max-length", 5);
//		x.addArgument("x-message-ttl", Integer.parseUnsignedInt("1000"));
		return x;
	}

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setUsername("guest");
		return cachingConnectionFactory;
	}

	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		return converter;
	}

	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(jackson2Converter());
		return factory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrentConsumers(3); // Set the desired number of consumer threads
		factory.setMaxConcurrentConsumers(5); // Set the maximum number of consumer threads
		return factory;
	}

	@RabbitListener(queues = "summer-boot")
	public void receiveEmployees(List<EmployeeDTO> x) {

		System.out.println("received on summer queue: " + x.get(0).getUsername());
	}

	@RabbitListener(queues = "spring-boot")
	public void receiveCars(CarDTO x) {
		System.out.println("Received on spring queue: model: " + x.getModel() + ", Id:" + x.getId());
	}

}
