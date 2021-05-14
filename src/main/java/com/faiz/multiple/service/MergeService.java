package com.faiz.multiple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faiz.multiple.model.book.Book;
import com.faiz.multiple.model.user.User;

@Service
public class MergeService {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	public Object getAllBooksAndUsers() {

		List<User> users = userService.getAllUsers();
		List<Book> books = bookService.getAllBooks();

		List<Object> usersAndBooks = new ArrayList<>();
		usersAndBooks.add(users);
		usersAndBooks.add(books);

		return usersAndBooks;
	}

	@Transactional(value = "chainedTransactionManager")
	public String saveAllBooksAndUsers() {
		String saveBookStatus = bookService.saveBooks();
		String saveUserStatus = userService.saveUsers();

		return saveUserStatus.contains("Success") && saveBookStatus.contains("Success") ? "Success in merge service"
				: "Failure in merge service";

	}

}
