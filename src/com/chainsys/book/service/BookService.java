package com.chainsys.book.service;

import java.util.List;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public interface BookService {
	Set<Book> findAll();

	void save(Book book) throws BookNotFoundException;

	void update(Book book) throws BookNotFoundException;

	void delete(int id) throws BookNotFoundException;

	List<String> findAllName();

	List<Integer> findAllId();

}
