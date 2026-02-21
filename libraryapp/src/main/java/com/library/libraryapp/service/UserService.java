package com.library.libraryapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.libraryapp.entity.DTOUser;
import com.library.libraryapp.entity.User;
import com.library.libraryapp.repository.DTOUserRepository;
import com.library.libraryapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DTOUserRepository dtoUserRepository;

	public User saveUser(User user) {

		User checkUserIsPresent = userRepository.getUserByEmailId(user.getEmail());

		if (!Objects.isNull(checkUserIsPresent)) {

			user.setId(checkUserIsPresent.getId());
		}

		return userRepository.save(user);
	}

	public User getUserByEmailAndPassword(String emailId, String password) {

		return userRepository.getUserByEmailAndPassword(emailId, password);
	}

	public List<DTOUser> getAllUsers() {
		// get all users

		return dtoUserRepository.getAllUsers();
	}

	public List<User> getAll() {
		// get all users

		return userRepository.findAll();
	}
}
