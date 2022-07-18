package com.hulks.stock.controller.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hulks.stock.controller.model.Cart;
import com.hulks.stock.controller.serviceInterfaces.ICartService;

/**
 * @author afvergani
 *
 */
@Controller
@RequestMapping
public class CartDAO {
	
	@Autowired
	private ICartService service;
	private static Logger logger = Logger.getLogger(CartDAO.class);
	
	/**
	 * @param model
	 * @return redirect to listCarts
	 */
	@GetMapping("/listCarts")
	public String listCarts(Model model) {
		List<Cart> carts = service.list();
		model.addAttribute("carts", carts);
		logger.info("Listing all carts");
		logger.debug("Carts: " + carts.toString());
		return "redirect:/listCarts";
	}
	
	/**
	 * @param model
	 * @return formCart
	 */
	@GetMapping("/newCart")
	public String newCart(Model model) {
		model.addAttribute("cart", new Cart());
		logger.info("newCart requested");
		return "formCart";
	}
	
	/**
	 * @param newCart
	 * @param model
	 * @return redirect to listCart
	 */
	@PostMapping("saveCart")
	public String save(@Validated Cart newCart, Model model) {
		service.add(newCart);
		logger.info("Adding a newCart");
		logger.debug("Cart parameters: " + newCart.toString());
		return "redirect:/listCart";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return formCart
	 */
	@GetMapping("/editCart/{id}")
	public String updateCart(@PathVariable int id, Model model) {
		Optional<Cart> cart = service.listbyId(id);
		model.addAttribute("cart", cart);
		logger.info("Edit existing cart, cart ID: " + id);
		logger.debug("Cart parameters: " + cart.toString());
		return "formCart";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return redirect to listCart
	 */
	@GetMapping("/deleteCart/{id}")
	public String deleteCart(@PathVariable int id, Model model) {
		service.delete(id);
		logger.info("Cart deleted, cart ID: "+ id);
		return "redirect:/listCart";
	}
}

