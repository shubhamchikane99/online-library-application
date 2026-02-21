package com.library.libraryapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.libraryapp.entity.BookAssignToUser;
import com.library.libraryapp.repository.BookAssignToUserRepository;

@Service
public class BookAssignToUserService {

	// constructor injection
	private final BookAssignToUserRepository bookAssignToUserRepository;

	public BookAssignToUserService(BookAssignToUserRepository bookAssignToUserRepository) {
		this.bookAssignToUserRepository = bookAssignToUserRepository;
	}

	public BookAssignToUser saveBookAssignToUser(BookAssignToUser bookAssignToUser) {

		return bookAssignToUserRepository.save(bookAssignToUser);
	}

	public BookAssignToUser findBookAssignToUserById(String id) {

		Optional<BookAssignToUser> bookAssignToUserOpt = bookAssignToUserRepository.findById(id);

		return bookAssignToUserOpt.get();
	}
}
