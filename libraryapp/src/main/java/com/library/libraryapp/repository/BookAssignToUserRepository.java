package com.library.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.libraryapp.entity.BookAssignToUser;

@Repository
public interface BookAssignToUserRepository extends JpaRepository<BookAssignToUser, String> {

}
