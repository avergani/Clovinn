/**
 * 
 */
package com.hulks.stock.controller.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.hulks.stock.controller.HulkCustomException;
import com.hulks.stock.controller.model.Cart;
import com.hulks.stock.controller.model.Customer;

/**
 * @author afvergani
 */
public interface ICustomerService {
	
	public List<Customer> list();
	public Optional<Customer> listbyId(int id);
	public int add(Customer newCustomer);
	public void delete(int id);
	public boolean buyCart(Customer customer, Cart cart, long creditCardNumber, int expiryDate, int cardVerificationNumber) throws HulkCustomException;
	public boolean validatePassword(String pass, String reentryPass) throws HulkCustomException;
}
