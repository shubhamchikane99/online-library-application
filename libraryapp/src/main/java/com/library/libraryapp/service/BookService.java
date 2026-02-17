package com.library.libraryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryapp.entity.Book;
import com.library.libraryapp.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book saveBook(Book book) {
		// save book

		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		// get all books

		return bookRepository.findAll();
	}
}
