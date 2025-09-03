package com.rogerr.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.rogerr.dtos.CriarUsuarioResponse;

@Component
public class RabbitMQConsumerComponent {

	@Autowired
	private JavaMailSender javaMailSender;

	@RabbitListener(queues = "usuarios")
	public void consumer(CriarUsuarioResponse registro) {
		
		try {
			var message = javaMailSender.createMimeMessage();

			var helper = new MimeMessageHelper(message, true, "UTF-8");

			helper.setTo(registro.getEmail());
			helper.setSubject("Olá " + registro.getNome() + ", seja bem-vindo ao sistema!");

			helper.setText("""
					<h2>Parabéns! Sua conta foi criada com sucesso.</h2>
					<p>A partir de agora você poderá acessar sua conta no sistema.</p>
					<p>Seja bem-vindo e aproveite as funcionalidades da nossa aplicação.</p>
					<p>Att,</p>
					<p>Roger Ribeiro Santos</p>
					""", true); // true = HTML

			javaMailSender.send(message);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
