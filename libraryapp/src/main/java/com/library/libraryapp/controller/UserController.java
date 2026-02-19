package com.library.libraryapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.libraryapp.entity.DTOUser;
import com.library.libraryapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
 
	@GetMapping("/get-all-users")
	public String getAllUsers(Model model) {

		List<DTOUser> allUsers = new ArrayList<>();

		allUsers = userService.getAllUsers();

		model.addAttribute("users", allUsers);

		return "userspage"; // loads hello.html
	}

}
