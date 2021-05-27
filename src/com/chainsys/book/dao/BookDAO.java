package com.chainsys.book.dao;

import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;

public interface BookDAO {

	Set<Book> findAll();

	List<String> findAllName();

	void save(Book book);

	void update(Book book);

	List<Integer> findAllId();

	void delete(int id);

}
