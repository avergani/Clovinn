/**
 * 
 */
package com.hulks.stock.controller.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.hulks.stock.controller.model.Cart;

/**
 * @author afvergani
 *
 */
public interface ICartService {
	
	public List<Cart> list();
	public Optional<Cart> listbyId(int id);
	public int add(Cart newCart);
	public void delete(int id);

}
