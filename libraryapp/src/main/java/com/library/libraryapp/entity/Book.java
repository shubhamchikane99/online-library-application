package com.library.libraryapp.entity;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

	@Id
	@Column(name = "id")
	private String id = UUID.randomUUID().toString();

	@Column(name = "name")
	private String name;

	@Column(name = "author")
	private String author;

	@Column(name = "category")
	private String category;

	@Column(name = "status")
	private int status;

	@Column(name = "price")
	private double price;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_date_time", updatable = false)
	private Date insertDateTime; 
}
