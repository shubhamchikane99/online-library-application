package com.library.libraryapp.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_assign_to_user")
@Data
public class BookAssignToUser {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@Column(name = "book_id")
	private String bookId;

	@Column(name = "user_id")
	private String userId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "from_issue_date")
	private Date fromIssueDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "to_issue_date")
	private Date toIssueDate;

	@Column(name = "return_date")
	private Date returnDate;

	// 0 = Issued, 1 = Returned
	@Column(name = "status")
	private Integer status;

	@Column(name = "insert_date_time")
	private LocalDateTime insertDateTime;
}
