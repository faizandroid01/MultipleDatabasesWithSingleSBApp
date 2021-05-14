package com.faiz.multiple.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faiz.multiple.model.book.Book;
import com.faiz.multiple.repo.book.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public List<Book> getAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String saveBooks() {
		return bookRepo
				.saveAll(Stream.of(new Book(001, "John"), new Book(002, "Adam")).collect(Collectors.toList())) != null
						? "Successfully saved in Book Db > Book Table. "
						: "Failure while saving in Book Db > Book Table. ";

	}

}
