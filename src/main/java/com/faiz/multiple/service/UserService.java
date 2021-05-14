package com.faiz.multiple.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faiz.multiple.model.user.User;
import com.faiz.multiple.repo.user.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String saveUsers() {
		//int c = 1 / 0;
		return userRepo.saveAll(Stream.of(new User(001, "Way to Mars"), new User(002, " Life On Earth "))
				.collect(Collectors.toList())) != null ? "Successfully saved in User Db > User Table. "
						: "Failure while saving in User Db > User Table. ";

	}

}
