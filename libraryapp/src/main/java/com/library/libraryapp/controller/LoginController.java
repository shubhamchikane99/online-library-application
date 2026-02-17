package com.library.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.library.libraryapp.entity.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String helloPage() {
		return "loginpage"; // loads hello.html
	}

	@GetMapping("/register")
	public String registerPage() {
		return "registerpage"; // loads hello.html
	}

	@PostMapping("/save-user")
	public String saveUser(User user) {

		User saveUser = userService.saveUser(user);

		return "redirect:/registerpage";
	}

	@PostMapping("/log-in")
	public String check(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes redirectAttributes) {

		User vaidUser = userService.getUserByEmailAndPassword(email, password);

		if (vaidUser != null) {
			// Login successful → redirect to welcome page
			return "redirect:/welcome";
		} else {
			// Login failed → show error on login page
			redirectAttributes.addFlashAttribute("error", "Incorrect email or password!");
			return "redirect:/";
		}
	}

	// Welcome page after login
	@GetMapping("/welcome")
	public String welcomePage() {

		return "welcome";
	}

	@GetMapping("/guest")
	public String guestLoginPage() {

		return "guestpage";
	}

	// Handle guest form submission
	@PostMapping("/guest-login")
	public String guestLogin(@RequestParam("name") String name, HttpSession session) {

		User guest = new User();
		guest.setName(name);
		guest.setEmail("guest@library.com");
		guest.setMembership("0");
		// Save in session
		session.setAttribute("currentUser", guest);

		// Redirect to book list page
		return "redirect:/books";
	}

}
