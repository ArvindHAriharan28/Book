package com.chainsys.jdbc;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class BookDAOTest {

	@Test
	public void testAddBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id=1;
		book.name="java";
		book.price = 400;
		book.publishdate = LocalDate.parse("2019-09-09");
		bookDAO.addBook(book);
		
		Book book1 = new Book();
		book1.id=1;
		Book b = bookDAO.findById(book1);
		
		assertEquals(book.id, b.id);
	}

	@Test
	public void testUpdateBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 1;
		book.name="c";
		bookDAO.updateBook(book);
		
		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDAO.findById(book1);
		assertEquals(book.id, b.id);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testDeleteBook() throws Exception {
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 1;
	
		
		Book book1 = new Book();
		book1.id = 1;
		Book b = bookDAO.findById(book1);
		assertEquals(book.id, b.id);
		bookDAO.deleteBook(book);
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAll() throws Exception {
		BookDAO bookDAO = new BookDAO();
		bookDAO.findAll();
		//fail("Not yet implemented");
	}

	@Test
	public void testFindById() throws Exception {
		//fail("Not yet implemented");
		BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.id = 1;
		bookDAO.findById(book);
		
		Book book1 = new Book();
		book1.id= 1;
		Book b = bookDAO.findById(book1);
		assertEquals(book.id, b.id);
	}

}
