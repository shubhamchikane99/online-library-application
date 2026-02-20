package com.library.libraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.libraryapp.entity.DTOBookAssignToUser;

@Repository
public interface DTOBookAssignToUserRepository extends JpaRepository<DTOBookAssignToUser, String> {

	@Query(value = " SELECT\r\n"
			+ "    b.name AS book_name,\r\n"
			+ "    u.name AS user_name,\r\n"
			+ "    DATE_FORMAT(assign.from_issue_date, '%d-%m-%Y') AS from_issue_date,\r\n"
			+ "    DATE_FORMAT(assign.to_issue_date, '%d-%m-%Y') AS to_issue_date,\r\n"
			+ "    assign.id,\r\n"
			+ "    assign.book_id,\r\n"
			+ "    assign.user_id,\r\n"
			+ "    assign.return_date,\r\n"
			+ "    assign.status,\r\n"
			+ "    assign.insert_date_time\r\n"
			+ "FROM\r\n"
			+ "    book_assign_to_user assign,\r\n"
			+ "    book b,\r\n"
			+ "    user u\r\n"
			+ "WHERE\r\n"
			+ "        assign.user_id = u.id\r\n"
			+ "    AND assign.book_id = b.id ", nativeQuery =  true)
	List<DTOBookAssignToUser> getAssignBookToUsers();

}
