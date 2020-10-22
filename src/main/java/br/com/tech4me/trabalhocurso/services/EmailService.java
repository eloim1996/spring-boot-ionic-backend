package br.com.tech4me.trabalhocurso.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.tech4me.trabalhocurso.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
		
	void sendEmail(SimpleMailMessage msg);
}
