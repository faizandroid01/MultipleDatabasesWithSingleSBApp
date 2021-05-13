package com.faiz.multiple.repo.book;

import org.springframework.data.repository.CrudRepository;

import com.faiz.multiple.model.book.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{

}
