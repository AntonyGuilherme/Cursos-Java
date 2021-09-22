package br.com.alura.mvc.mudi.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repositoy.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping()
	public ModelAndView home(Principal principal) {
		
		Sort ordenacao = Sort.by("dataDaEntrega").descending();
		PageRequest page = PageRequest.of(0, 10,ordenacao);
		
		ModelAndView modelAndView = new ModelAndView("home");
		List<Pedido> pedidos = pedidoRepository.findAllByStatus(StatusPedido.ENTREGUE,page);
		modelAndView.addObject("pedidos",pedidos);
		return modelAndView;
		
	}
	
	
}
