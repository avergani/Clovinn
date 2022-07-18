package com.hulks.stock.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulks.stock.controller.interfaces.IProduct;
import com.hulks.stock.controller.model.Product;
import com.hulks.stock.controller.serviceInterfaces.IProductService;

/**
 * @author afvergani
 */
@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProduct data;

	/**
	 * Method that list all products
	 */
	@Override
	public List<Product> list() {
		return (List<Product>) data.findAll();
	}
	
	/**
	 * Method that search product by ID
	 */
	@Override
	public Optional<Product> listbyId(int id) throws IllegalArgumentException{
		return data.findById(id);
	}

	/**
	 * Method that adds a new product if newProduct not null
	 */
	@Override
	public int add(Product newProduct) throws IllegalArgumentException{
		int result = 0;
		Product product = data.save(newProduct);
		if(!product.equals(null)) {
			result = 1;
		}
		return result;
	}

	/**
	 * Method that delete a product by ID
	 */
	@Override
	public void delete(int id) throws IllegalArgumentException{
		data.deleteById(id);
		
	}
}
