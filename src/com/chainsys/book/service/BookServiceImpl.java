package com.chainsys.book.service;

import java.util.List;
import java.util.Set;

import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public class BookServiceImpl implements BookService {
	private static BookDAO dao;

	public BookServiceImpl() {
		dao = new BookDAOImpl();
	}

	@Override
	public Set<Book> findAll() {
		return dao.findAll();
	}

	@Override
	public List<String> findAllName() {
		return dao.findAllName();
	}

	@Override
	public List<Integer> findAllId() {
		return dao.findAllId();
	}

	@Override
	public void save(Book book) {
		dao.save(book);
	}

	@Override
	public void update(Book book) throws BookNotFoundException {
		dao.update(book);
	}

	@Override
	public void delete(int id) throws BookNotFoundException {
		dao.delete(id);
	}

}
