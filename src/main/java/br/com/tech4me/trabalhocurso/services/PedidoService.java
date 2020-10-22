package br.com.tech4me.trabalhocurso.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.trabalhocurso.domain.ItemPedido;
import br.com.tech4me.trabalhocurso.domain.PagamentoComBoleto;
import br.com.tech4me.trabalhocurso.domain.Pedido;
import br.com.tech4me.trabalhocurso.domain.enums.EstadoPagamento;
import br.com.tech4me.trabalhocurso.repositories.ItemPedidoRepository;
import br.com.tech4me.trabalhocurso.repositories.PagamentoRepository;
import br.com.tech4me.trabalhocurso.repositories.PedidoRepository;
import br.com.tech4me.trabalhocurso.services.exception.ObjectNotFoundException;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		 Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		} 

	
	public Pedido insert(Pedido obj) {
			obj.setId(null);
			obj.setInstante(new Date());
			obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
			obj.getPagamento().setPedido(obj);
			if(obj.getPagamento() instanceof PagamentoComBoleto) {
				PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
				boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
			}
			obj = repo.save(obj);
			pagamentoRepository.save(obj.getPagamento());
			for(ItemPedido ip : obj.getItens()) {
				ip.setDesconto(0.0);
				ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
				ip.setPedido(obj);
			}
			itemPedidoRepository.saveAll(obj.getItens());
			return obj;
	}
	
}
