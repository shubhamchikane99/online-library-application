package com.library.libraryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.library.libraryapp.entity.Book;
import com.library.libraryapp.entity.BookAssignToUser;
import com.library.libraryapp.entity.DTOBookAssignToUser;
import com.library.libraryapp.entity.DTOUser;
import com.library.libraryapp.repository.DTOBookAssignToUserRepository;
import com.library.libraryapp.service.BookAssignToUserService;
import com.library.libraryapp.service.BookService;
import com.library.libraryapp.service.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookAssignToUserService bookAssignToUserService;

	@Autowired
	private DTOBookAssignToUserRepository dtoBookAssignToUserRepository;

	@GetMapping("/addBook")
	public String addBook(Model model) {

		List<Book> book = bookService.getAllBooks();
		model.addAttribute("bookList", book);

		return "bookpage"; // loads hello.html
	}

	@PostMapping("/save-book")
	public String saveBook(Book book) {

		bookService.saveBook(book);

		return "redirect:/addBook";
	}

	@GetMapping("/manage-book")
	public String manageBook(Model model) {

		List<Book> book = bookService.getAllBooks();
		List<DTOUser> user = userService.getAllUsers();

		List<DTOBookAssignToUser> assingBook = dtoBookAssignToUserRepository.getAssignBookToUsers();

		model.addAttribute("bookList", book);
		model.addAttribute("userList", user);
		model.addAttribute("assingBookList", assingBook);

		return "managebookpage"; // loads hello.html
	}

	@PostMapping("/assign-book-to-user")
	public String getAssignBookToUser(BookAssignToUser bookAssignToUser) {

		System.err.println("bookAssignToUser " + bookAssignToUser);

		bookAssignToUser.setStatus(0);
		bookAssignToUserService.saveBookAssignToUser(bookAssignToUser);

		return "redirect:/manage-book";// loads hello.html
	}

}
