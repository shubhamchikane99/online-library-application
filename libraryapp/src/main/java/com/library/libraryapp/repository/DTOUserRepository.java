package com.library.libraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.libraryapp.entity.DTOUser;

@Repository
public interface DTOUserRepository extends JpaRepository<DTOUser, String> {

	@Query(value = " SELECT\r\n"
			+ "    DATEDIFF(CURDATE(), u.member_ship_date) AS diff,\r\n"
			+ "    DATE_FORMAT(DATE(u.insert_date_time), '%d-%m-%Y') AS join_date,\r\n"
			+ "    u.id,\r\n"
			+ "    u.name,\r\n"
			+ "    u.email,\r\n"
			+ "    u.membership\r\n"
			+ "FROM\r\n"
			+ "    user u\r\n"
			+ "ORDER BY u.insert_date_time DESC  ", nativeQuery =   true)
	List<DTOUser> getAllUsers();

}
