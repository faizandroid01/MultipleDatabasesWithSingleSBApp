package com.faiz.multiple;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.faiz.multiple.model.book.Book;
import com.faiz.multiple.model.user.User;
import com.faiz.multiple.repo.book.BookRepo;
import com.faiz.multiple.repo.user.UserRepo;

@SpringBootApplication
public class MultipleDatabaseApplication {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private UserRepo userRepo;

	@PostConstruct
	public void addData2Db() {
		
		bookRepo.saveAll(Stream.of(new Book(001,"John"),new Book(002 , "Adam")).collect(Collectors.toList()));
		userRepo.saveAll(Stream.of(new User(001,"Way to Mars"),new User(002 , " Life On Earth ")).collect(Collectors.toList()));

	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabaseApplication.class, args);
	}

}
