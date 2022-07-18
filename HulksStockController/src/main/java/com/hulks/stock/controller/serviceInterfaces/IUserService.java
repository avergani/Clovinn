package com.hulks.stock.controller.serviceInterfaces;

import java.util.List;
import java.util.Optional;

import com.hulks.stock.controller.HulkCustomException;
import com.hulks.stock.controller.model.User;

/**
 * @author afvergani
 */
public interface IUserService {
	
	public List<User> list();
	public Optional<User> listbyId(int id);
	public int add(User newUser);
	public void delete(int id);
	public boolean validatePassword(String pass, String reentryPass) throws HulkCustomException;


}
