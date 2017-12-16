package br.com.casacodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casacodigo.loja.daos.ProductDao;
import br.com.casacodigo.loja.models.BookType;
import br.com.casacodigo.loja.models.Product;

@Controller
@Transactional
public class ProductsController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public String save(Product product) {
		productDao.save(product);
		System.out.println("produto cadastrado" + product);
		return "products/ok";
	}
	
	@RequestMapping("/produtos/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		return modelAndView;
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", productDao.list());
		return modelAndView;
	}
	
}
