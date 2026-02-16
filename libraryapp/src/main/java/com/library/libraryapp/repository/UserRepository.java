package com.library.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.libraryapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(value = " SELECT u.* FROM user u WHERE u.email =:emailId ", nativeQuery = true)
	User getUserByEmailId(@Param("emailId") String emailId);

	@Query(value = " SELECT u.* FROM user u WHERE u.email =:emailId AND u.password =:password  ", nativeQuery = true)
	User getUserByEmailAndPassword(String emailId, String password);
}
