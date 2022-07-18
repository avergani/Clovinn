package com.hulks.stock.controller.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.hulks.stock.controller.model.Product;

/**
 * @author afvergani
 */
public interface IProductService {
	
	public List<Product> list();
	public Optional<Product> listbyId(int id);
	public int add(Product newProduct);
	public void delete(int id);

}
