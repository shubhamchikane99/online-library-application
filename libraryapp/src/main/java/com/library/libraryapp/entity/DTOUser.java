package com.library.libraryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DTOUser {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "membership")
	private String membership;

	@Column(name = "join_date")
	private String joinDate;

	@Column(name = "diff")
	private int diff;

}
