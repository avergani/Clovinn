package com.hulks.stock.controller.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hulks.stock.controller.model.User;

/**
 * @author afvergani
 */
@Repository
public interface IUser extends CrudRepository<User, Integer>{
	

}
