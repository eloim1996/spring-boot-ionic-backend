package br.com.tech4me.trabalhocurso.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.tech4me.trabalhocurso.domain.PagamentoComBoleto;

@Service
public class BoletoService {
		
	public void preencherPagamentoComBoleto (PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
