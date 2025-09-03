package com.rogerr.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rogerr.dtos.CriarUsuarioResponse;

@Component
public class RabbitMQProducerComponent {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue usuariosQueue;

	public void send(CriarUsuarioResponse usuario) {
		rabbitTemplate.convertAndSend(usuariosQueue.getName(), usuario);
	}
}
