package com.faiz.multiple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.multiple.model.book.Book;
import com.faiz.multiple.model.user.User;
import com.faiz.multiple.repo.book.BookRepo;
import com.faiz.multiple.repo.user.UserRepo;

@RestController
public class TestController {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private UserRepo userRepo;

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepo.findAll();

	}

}
