package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;
//import java.util.List;

public class BookDAOImpl implements BookDAO {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static List<String> nameList;
	private static List<Integer> idList;


	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:EBS1228", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from book_2591");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book books = new Book(rs.getInt("id"), rs.getString("name"), rs.getDate("publish_date").toLocalDate());
				bookSet.add(books);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookSet;
	}

	
	@Override
	public List<String> findAllName() {
		try {
			pstmt = con.prepareStatement("select Name from book_2591");
			rs = pstmt.executeQuery();
			nameList = new ArrayList<>();
			while (rs.next()) {
				nameList.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}

	@Override
	public List<Integer> findAllId() {
		try {
			pstmt = con.prepareStatement("select id from book_2591");
			rs = pstmt.executeQuery();
			idList = new ArrayList<>();
			while (rs.next()) {
				idList.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idList;
	}	

	@Override
	public void save(Book book) {
		try {
			pstmt = con.prepareStatement("insert into book_2591 values(?,?,?)");
			pstmt.setInt(1, book.getId());
			pstmt.setString(2, book.getName());
			pstmt.setDate(3, Date.valueOf(book.getPublish_Date()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Book book) {
		try {
			pstmt = con.prepareStatement("update book_2591 set name=? where id=?");
			pstmt.setString(1, book.getName());
			pstmt.setInt(2, book.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
