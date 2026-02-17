package com.library.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.libraryapp.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
