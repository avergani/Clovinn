package com.hulks.stock.controller.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hulks.stock.controller.model.Customer;

/**
 * @author afvergani
 */
@Repository
public interface ICustomer extends CrudRepository<Customer, Integer>{

}
