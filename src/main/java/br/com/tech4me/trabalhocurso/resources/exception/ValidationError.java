package br.com.tech4me.trabalhocurso.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	
	
	public ValidationError(int value, String message, long currentTimeMillis) {
		super(value, message, currentTimeMillis);

	}


	public List<FieldMessage> getErros() {
		return erros;
	}



	public void addError(String fieldName, String mensagem) {
		erros.add(new FieldMessage(fieldName, mensagem));
	}
	

	
}
