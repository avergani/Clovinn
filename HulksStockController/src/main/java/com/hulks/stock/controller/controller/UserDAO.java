package com.hulks.stock.controller.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hulks.stock.controller.model.User;
import com.hulks.stock.controller.serviceInterfaces.IUserService;

/**
 * @author afvergani
 */
@Controller
@RequestMapping
public class UserDAO {
	
	@Autowired
	private IUserService service;
	private static Logger logger = Logger.getLogger(UserDAO.class);
	
	/**
	 * @param model
	 * @return redirect to listUsers
	 */
	@GetMapping("/listUsers")
	public String listUsers(Model model) {
		List<User> users = service.list();
		model.addAttribute("users", users);
		logger.info("Listing all Users");
		logger.debug("Users: " + users.toString());
		return "redirect:/listUsers";	
	}
	
	/**
	 * @param model
	 * @return formNewUser
	 */
	@GetMapping("/newUser")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		logger.info("newUser requested");
		return "formNewUser";
	}
	
	/**
	 * @param newUser
	 * @param model
	 * @return redirect to listUser
	 */
	@PostMapping("/saveUser")
	public String save(@Validated User newUser, Model model) {
		service.add(newUser);
		logger.info("Adding new User");
		logger.debug("User parameters: " + newUser.toString());
		return "redirect:/listUser";
	}
	
	/**
	 * @param id
	 * @param model
	 * @return formNewUser
	 */
	@GetMapping("/editUser/{id}")
	public String updateUser(@PathVariable int id, Model model) {
		Optional<User> user = service.listbyId(id);
		model.addAttribute("user", user);
		logger.info("Update User, user ID: " + id);
		logger.debug("Actual User parameters: " + user.toString());
		return "formNewUser";
	}
	
	
	/**
	 * @param id
	 * @param model
	 * @return redirect to listUser
	 */
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id, Model model) {
		service.delete(id);
		logger.info("User deleted, user ID: " + id);
		return "redirect:/listUsers";	
	}

}
