package com.chainsys.book.model;

import java.time.LocalDate;

public class Book {

	private int id;
	private String name;
	private LocalDate publish_Date;

	public Book() {
		super();
	}

	public Book(String name) {
		this.name = name;
	}

	public Book(int id) {
		this.id = id;
	}

	public Book(LocalDate publish_Date) {
		this.publish_Date = publish_Date;
	}

	public Book(int id, String name, LocalDate publish_Date) {
		super();
		this.id = id;
		this.name = name;
		this.publish_Date = publish_Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPublish_Date() {
		return publish_Date;
	}

	public void setPublish_Date(LocalDate publish_Date) {
		this.publish_Date = publish_Date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publish_Date == null) ? 0 : publish_Date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publish_Date == null) {
			if (other.publish_Date != null)
				return false;
		} else if (!publish_Date.equals(other.publish_Date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publish_Date=" + publish_Date + "]";
	}

}
