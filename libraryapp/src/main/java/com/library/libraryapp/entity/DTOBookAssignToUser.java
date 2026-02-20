package com.library.libraryapp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DTOBookAssignToUser {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "book_id")
	private String bookId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "from_issue_date")
	private String fromIssueDate;

	@Column(name = "to_issue_date")
	private String toIssueDate;

	@Column(name = "return_date")
	private String returnDate;

	// 0 = Issued, 1 = Returned
	@Column(name = "status")
	private Integer status;

	@Column(name = "insert_date_time")
	private LocalDateTime insertDateTime;

	@Column(name = "book_name") 
	private String bookName;

	@Column(name = "user_name")
	private String userName;

}
