package br.com.casacodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
public class HomeController {

	@RequestMapping("/")
	public String index() {
		//aqui ainda vamos carregar os produtos
		System.out.println("Carregando so produtos");
		return "hello-world";
	}
	
}
