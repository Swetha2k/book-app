package com.chainsys.book.dao;

import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookDAO {

	Set<Book> findAll();
	void save (Book book);
	void update (Book book);
}
