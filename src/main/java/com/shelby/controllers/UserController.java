package com.shelby.controllers;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shelby.models.User;
import com.shelby.repositories.UserRepository;
import com.shelby.services.UserService;


@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/add-user")
	public String addUser(Model model) {
		model.addAttribute("user_obj",new User());
		return "add_user";
	}
	@PostMapping("/add-user")
	public String addUser(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("")
	public String showHome(Model model) {
		Iterator<User> allUsers=userService.getAllUsers();
		model.addAttribute("allUsers",allUsers);
		return "home";
	}
	
	@GetMapping("/update-user/{id}")
	public String updateUserById(@PathVariable int id, Model model) {
		User user =userService.getUserById(id);
		model.addAttribute("user_obj",user);
		return "update_user";
	}
	
	@PostMapping("/update-user")
	public String updateUserById(@ModelAttribute User user) {
		userService.addUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUserById(@PathVariable int id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}

}
