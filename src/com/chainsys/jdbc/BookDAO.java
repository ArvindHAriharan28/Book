package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

	/**
	 * @param name
	 * @param price
	 * @throws Exception
	 *             precondition id,name,price must be valid
	 */
	public void addBook(Book book) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		try {
			String sql = "insert into book(id,name,price,publishdate) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, book.id);
			preparedStatement.setString(2, book.name);
			preparedStatement.setInt(3, book.price);
			preparedStatement.setDate(4, Date.valueOf(book.publishdate));
			int rows = preparedStatement.executeUpdate();
			System.out.println("Rows inserted: " + rows);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable insert");
		}
	}

	public void updateBook(Book book) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "update book set name=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.name);
			preparedStatement.setInt(2, book.id);
			int rows1 = preparedStatement.executeUpdate();
			System.out.println("Rows updated: " + rows1);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable update");
		}
	}

	public void deleteBook(Book book) throws Exception {
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql2 = "delete from book where id =?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql2);
			preparedStatement.setInt(1, book.id);
			int rows2 = preparedStatement.executeUpdate();
			System.out.println("Rows deleted: " + rows2);
			ConnectionUtil.close(connection, preparedStatement, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable delete");
		}
	}

	public ArrayList<Book> findAll() throws Exception {

		ArrayList<Book> booklist = new ArrayList<Book>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql4 = "select id,name,price,publishdate from book ORDER BY id desc";
			PreparedStatement preparedStatement = connection.prepareStatement(sql4);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			while (resultSet.next()) {

				Book book1 = new Book();
				book1.id=resultSet.getInt("id");
				book1.name=resultSet.getString("name");
				book1.price=resultSet.getInt("price");
				Date date = resultSet.getDate("publishdate");
				if(date ==null) {
					book1.publishdate = null;
				}
				else {
				book1.publishdate=resultSet.getDate("publishdate").toLocalDate();
				}
				booklist.add(book1);
			}
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable findall");
		}
		return booklist;

	}

	public Book findById(Book book) throws Exception {
		Book book1 = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql4 = "select id,name,price,publishdate from book where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql4);
			preparedStatement.setInt(1, book.id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				book1 = new Book();
				book1.id=resultSet.getInt("id");
				book1.name=resultSet.getString("name");
				book1.price=resultSet.getInt("price");
				book1.publishdate=resultSet.getDate("publishdate").toLocalDate();
			}
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("unable findbyid");
		}
		
		return book1;
	}

}
