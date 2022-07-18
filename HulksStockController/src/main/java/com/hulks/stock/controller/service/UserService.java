package com.hulks.stock.controller.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulks.stock.controller.HulkCustomException;
import com.hulks.stock.controller.interfaces.IUser;
import com.hulks.stock.controller.model.User;
import com.hulks.stock.controller.serviceInterfaces.IUserService;

/**
 * @author afvergani
 */
@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUser data;

	/**
	 * Method that list all users
	 */
	@Override
	public List<User> list() {
		return (List<User>) data.findAll();
	}

	/**
	 * Method that search user by ID
	 */
	@Override
	public Optional<User> listbyId(int id) throws IllegalArgumentException {
		return data.findById(id);
	}

	/**
	 * Method that adds a new user
	 */
	@Override
	public int add(User newUser) throws IllegalArgumentException{
		int result = 0;
		User user = data.save(newUser);
		if(!user.equals(null)) {
			result = 1;
		}
		return result;
	}

	/**
	 * Method that delete an user by ID
	 */
	@Override
	public void delete(int id) throws IllegalArgumentException{
		data.deleteById(id);
	}

	@Override
	public boolean validatePassword(String pass, String reentryPass) throws HulkCustomException {
		boolean result = true;
		if(!pass.equalsIgnoreCase(reentryPass)) {
			result = false;
			throw new HulkCustomException("There is a difference between the pass and the reentrypass");
		}
		if(pass.length()< 8) {
			result = false;
			throw new HulkCustomException("The password entered has less than 8 characters.");
		}	
		return result;
	}
}
