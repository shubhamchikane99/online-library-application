package com.library.libraryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BookCategoryReport {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "category")
	private String category;

	@Column(name = "book_count")
	private int bookCount;

	@Column(name = "percentage")
	private double percentage;
}
