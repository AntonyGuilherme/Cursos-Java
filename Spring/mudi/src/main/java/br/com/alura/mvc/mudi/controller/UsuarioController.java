package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("usuario")
public class UsuarioController {

	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("pedido")
	public ModelAndView home(Principal principal) {
		
		ModelAndView modelAndView = new ModelAndView("usuario/home");
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		modelAndView.addObject("pedidos",pedidos);
		return modelAndView;
		
	}
	
	@GetMapping("pedido/{status}")
	public ModelAndView aguardando(@PathVariable("status") String status,Principal principal) {
		
		ModelAndView modelAndView = new ModelAndView("usuario/home");
		List<Pedido> pedidos = pedidoRepository
				.findByStatusAndUsername(
						principal.getName(),
						StatusPedido.valueOf(status.toUpperCase())
						);
		modelAndView.addObject("pedidos",pedidos);
		modelAndView.addObject("status",status);
		return modelAndView;
		
	}
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
	
	
}
