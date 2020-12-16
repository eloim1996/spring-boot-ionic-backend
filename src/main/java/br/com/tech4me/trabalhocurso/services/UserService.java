package br.com.tech4me.trabalhocurso.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.tech4me.trabalhocurso.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}

