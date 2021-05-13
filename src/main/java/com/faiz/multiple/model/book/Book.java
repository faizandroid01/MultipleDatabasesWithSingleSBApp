package com.faiz.multiple.model.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private int id;
	@Column(name = "BOOK_NAME")
	private String bookName;

	public Book() {
		super();
	}

	public Book(int id, String bookName) {
		super();
		this.id = id;
		this.bookName = bookName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

}
