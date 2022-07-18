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

import com.hulks.stock.controller.model.Product;
import com.hulks.stock.controller.serviceInterfaces.IProductService;

/**
 * @author afvergani
 */
@Controller
@RequestMapping
public class ProductDAO {
	
	@Autowired
	private IProductService service;
	private static Logger logger = Logger.getLogger(ProductDAO.class);
	
	/**
	 * @param model
	 * @return redirect to listProducts
	 */
	@GetMapping("/listProducts")
	public String listProducts(Model model) {
		List<Product> products = service.list();
		model.addAttribute("products", products);
		logger.info("Listing all products");
		logger.debug("Products: " + products);
		return "redirect:/listProducts";
	}
	
	/**
	 * @param model
	 * @return redirect to formNewProduct
	 */
	@GetMapping("/newProduct")
	public String newProduct(Model model) {
		model.addAttribute("product", new Product());
		logger.info("newProduct requested");
		return "formNewProduct";
	}
	
	/**
	 * @param newProduct
	 * @param model
	 * @return redirect to listProduct
	 */
	@PostMapping("/saveProduct")
	public String save(@Validated Product newProduct, Model model) {
		service.add(newProduct);
		logger.info("Adding a new Product");
		logger.debug("Product parameters: " + newProduct.toString());
		return "redirect:/listProduct";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return redirect to formNewProduct
	 */
	@GetMapping("/editProduct/{id}")
	public String updateProduct(@PathVariable int id, Model model) {
		Optional<Product> product = service.listbyId(id);
		model.addAttribute("product", product);
		logger.info("Edit existing product, product ID: " + id);
		logger.debug("Product parameters: " + product.toString());
		return "formNewProduct";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return redirect to listProducts
	 */
	@GetMapping("/deletePRoduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model) {
		service.delete(id);
		logger.debug("Product deleted, product ID: " + id);
		return "redirect:/listProducts";
	}

}
