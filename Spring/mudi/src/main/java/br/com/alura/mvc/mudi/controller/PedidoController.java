package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repositoy.PedidoRepository;
import br.com.alura.mvc.mudi.repositoy.UserRepository;

@Controller
@RequestMapping(value = {"pedido"})
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		
		return "pedido/formulario";
		
	}
	
	@PostMapping("novo")
	public ModelAndView novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
		
		
		if(result.hasErrors()) {
			return new ModelAndView("pedido/formulario");
		}
		
		String username = SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getName();
		
		User user = this.userRepository.findById(username).get();
		
		ModelAndView modelAndView = new ModelAndView("redirect:/home");
		Pedido pedido = requisicao.toPedido();
		pedido.setUser(user);
		this.pedidoRepository.save(pedido);
		
		
		return modelAndView;
	}
	
	
}
