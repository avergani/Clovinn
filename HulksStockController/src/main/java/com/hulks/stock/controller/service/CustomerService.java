package com.hulks.stock.controller.service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulks.stock.controller.HulkCustomException;
import com.hulks.stock.controller.interfaces.ICustomer;
import com.hulks.stock.controller.model.Cart;
import com.hulks.stock.controller.model.Customer;
import com.hulks.stock.controller.serviceInterfaces.ICustomerService;

/**
 * @author afvergani
 *
 */
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomer data;
	
	/**
	 * Method that list all customers
	 */
	@Override
	public List<Customer> list() {
		return (List<Customer>) data.findAll();
	}

	/**
	 * Method that list customer by ID
	 * @throws IllegalArgumentException
	 */
	@Override
	public Optional<Customer> listbyId(int id) throws IllegalArgumentException{
		return data.findById(id);
	}

	/**
	 * Method that adds a new customer if newCustomer not null
	 * @throws IllegalArgumentException
	 */
	@Override
	public int add(Customer newCustomer) throws IllegalArgumentException{
		int result = 0;
		Customer customer = data.save(newCustomer);
		if(!customer.equals(null)) {
			result = 1;
		}
		return result;
	}

	/**
	 * Method that delete a customer by ID
	 * @throws IllegalArgumentException
	 */
	@Override
	public void delete(int id) throws IllegalArgumentException{
		data.deleteById(id);
	}

	
	/**
	 * Method that validate if pass and reentryPass are equal.
	 * @return TRUE if pass equal to reentryPass, FALSE in any other case
	 * @throws HulkCustomException
	 */
	@Override
	public boolean validatePassword(String pass, String reentryPass) throws HulkCustomException{
		
		boolean result = true;
		if(!pass.equalsIgnoreCase(reentryPass)) {
			result = false;
			throw new HulkCustomException("There is a difference between the pass and the reentrypass");
		}
		if(pass.length()< 8) {
			result = false;
			throw new HulkCustomException("The ccNumber entered has less than 8 characters.");
		}	
		return result;
	}

	/**
	 * Method to encrypt sensitive customer data creditCardNumber, expiryDate, cardVerificatinValue.
	 * 
	 * @param customer
	 * @param cart
	 * @param creditCardNumber
	 * @param expiryDate
	 * @param cardVerificationValue
	 * @throws HulkCustomException
	 * @return TRUE if the payment is successful, FALSE otherwise.
	 */
	@Override
	public boolean buyCart(Customer customer, Cart cart, long creditCardNumber, int expiryDate, int cardVerificationValue) throws HulkCustomException {
		
		boolean result = false;
		
		// Creating StringBuffers for sensitive customer data
        StringBuffer ccNumber = new StringBuffer();
        StringBuffer expDate = new StringBuffer();
        StringBuffer cvv = new StringBuffer();
        
        ccNumber.append(creditCardNumber);
        expDate.append(expiryDate);
        cvv.append(cardVerificationValue);
       
        try {
			//Creating an encryptor (AES CBC with 16 bytes key)
			Cipher encryptor = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecureRandom random = new SecureRandom();
			byte[] keyCode = new byte[16];
			random.nextBytes(keyCode);
			SecretKeySpec specKey = new SecretKeySpec (keyCode, "AES");
			encryptor.init(Cipher.ENCRYPT_MODE, specKey);

			//Storing the StringBuffer in the SealedObject using encryptor
			SealedObject ccNumberEncrypted = new SealedObject(ccNumber, encryptor);
			SealedObject expDateEncrypted = new SealedObject(expDate, encryptor);
			SealedObject cvvEncrypted = new SealedObject(expDate, encryptor);
			
			// *******************************************
			//TODO Create Payment API with makeAPay method. 
			
			/*
			 * boolean result = paymentAPI.makeAPay(customer, cart, ccNumberEncrypted, expDateEncrypted, cvvEncrypted, specKey);  
			 *  
			 */
			
			//Eliminate StringBuffer
	        ccNumber.delete(0, ccNumber.length());
	        expDate.delete(0, expDate.length());
	        cvv.delete(0, expDate.length());
	        
	        return result;
			
			
		} catch (InvalidKeyException e) {
			throw new HulkCustomException(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new HulkCustomException(e.getMessage());
		} catch (NoSuchPaddingException e) {
			throw new HulkCustomException(e.getMessage());
		} catch (IllegalBlockSizeException e) {
			throw new HulkCustomException(e.getMessage());
		} catch (IOException e) {
			throw new HulkCustomException(e.getMessage());
		}
	}
}
