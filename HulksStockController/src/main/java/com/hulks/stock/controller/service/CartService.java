package com.hulks.stock.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulks.stock.controller.interfaces.ICart;
import com.hulks.stock.controller.model.Cart;
import com.hulks.stock.controller.serviceInterfaces.ICartService;

/**
 * @author afvergani
 */
@Service
public class CartService implements ICartService{
	
	@Autowired
	private ICart data;
	
	/**
	 * Method that list all carts
	 */
	@Override
	public List<Cart> list() {
		return (List<Cart>) data.findAll();
	}

	/**
	 * Method that list carts by id
	 */
	@Override
	public Optional<Cart> listbyId(int id) throws IllegalArgumentException{
		return data.findById(id);
	}

	/**
	 * Method that adds new cart
	 */
	@Override
	public int add(Cart newCart) throws IllegalArgumentException {
		int result = 0;
		Cart cart = data.save(newCart);
		if(!cart.equals(null)) {
			result = 1;
		}
		return result;
	}

	/**
	 * Method that delete cart by id
	 */
	@Override
	public void delete(int id) throws IllegalArgumentException{
		data.deleteById(id);
		
	}

}
