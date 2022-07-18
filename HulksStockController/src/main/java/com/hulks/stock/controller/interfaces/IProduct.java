package com.hulks.stock.controller.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hulks.stock.controller.model.Product;

/**
 * @author afvergani
 */
@Repository
public interface IProduct extends CrudRepository<Product, Integer> {

}
