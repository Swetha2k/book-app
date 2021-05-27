package com.chainsys.book.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;

public class BookClient {
	public static void main(String[] args) throws BookNotFoundException {

		Set<Book> bookSet;
		DateTimeFormatter dateFormat;
		String date;
		int id;
		String name;

		BookService service = new BookServiceImpl();
		System.out.println("Enter the choice");
		System.out.println(" 1. Find All Books\n 2. Adding a Book \n 3. Update the Book Name Based on the Id");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Books");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
			
		case 2:
			System.out.println("Adding a Book");
			System.out.println("Enter Id");
			id = scanner.nextInt();
			System.out.println("Enter Name");
			name = scanner.next();
			System.out.println("Enter date in dd/MM/yyyy format");
			date = scanner.next();
			dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Book newBook = new Book(id, name, LocalDate.parse(date, dateFormat));
			service.save(newBook);
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
		case 3:
			System.out.println("Update the Book Name Based on the Id");
			System.out.println("Enter Id");
			id = scanner.nextInt();
			System.out.println("Enter Name");
			name = scanner.next();
			Book updateBook = new Book(id, name, null);
			try {
				service.update(updateBook);
				bookSet = service.findAll();
				System.out.println(bookSet);
			} catch (BookNotFoundException e) {

			}
			break;

		default:
			break;

		}
		scanner.close();
	}
}
