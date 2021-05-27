package com.chainsys.book.client;

import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) throws BookNotFoundException {

		Set<Book> bookSet;

		BookService service = new BookServiceImpl();
		System.out.println("Enter the choice");
		System.out.println(" 1. Find All Products");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println(" 1. Find All Products");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
		default:
			break;

		}
		scanner.close();
	}
}
