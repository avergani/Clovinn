package com.hulks.stock.controller.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hulks.stock.controller.model.Cart;

/**
 * @author afvergani
 *
 */
@Repository
public interface ICart extends CrudRepository<Cart, Integer>{
	

}
