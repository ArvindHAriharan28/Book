package com.chainsys.jdbc.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.jdbc.Book;
import com.chainsys.jdbc.BookDAO;
import com.chainsys.jdbc.BookValidator;

public class TestBookDAO {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		int q = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println(" HOME ");
			System.out.println("--------");
			System.out.println("ENTER 1)insert  2)update  3)delete  4)selectcolumn   5)selectall");
			System.out.println("Enter the operation");
			BookDAO bookDAO = new BookDAO();
			int a = scanner.nextInt();
			Book book = new Book();
			BookValidator validateBook = new BookValidator();
				switch (a) {
				case 1:
					
					System.out.println("enter NAME : ");
					String name =scanner.next();
					book.name= name;
					System.out.println("enter PRICE : ");
					int price = scanner.nextInt();
					book.price= price;
					System.out.println("Enter Date(yyyy-MM-DD)");
					String date = scanner.next();
					book.publishdate=LocalDate.parse(date);
					
				
					try {
						validateBook.validateadd(book);
						bookDAO.addBook(book);
						bookDAO.findAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				case 2:

					System.out.println("enter ID : ");
					int id2 = scanner.nextInt();
					book.id =id2;
					System.out.println("enter NAME to be changed : ");
					String name2 = scanner.next();
					book.name= name2;
					try {
						validateBook.validateUpdate(book);
						bookDAO.updateBook(book);
						bookDAO.findAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				case 3:
					System.out.println("enter ID : ");
					int id3 = scanner.nextInt();
					book.id = id3;
					try {
						validateBook.validateDelete(book);
						bookDAO.deleteBook(book);
						bookDAO.findAll();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

					break;
					
				case 4:
					System.out.println("enter ID : ");
					int id4 = scanner.nextInt();
					book.id=id4;
					try {
						validateBook.validateFindById(book);
						Book b = bookDAO.findById(book);
			if(b!=null)
			{
							System.out.println(b.id);
							System.out.println(b.name);
							System.out.println(b.price);
							System.out.println(b.publishdate);
			}
			else
			{
				System.out.println("no record found");
			}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 5:
					try {
						bookDAO.findAll();
						if(book!=null){
						ArrayList<Book> b1 = bookDAO.findAll();
						
						for(Book temp : b1){
							System.out.println(temp.id);
							System.out.println(temp.name);
							System.out.println(temp.price);
							System.out.println(temp.publishdate);
						}
						}
						else
						{
							System.out.println("no record found");
						}
					} catch (Exception e) {
					
						e.printStackTrace();
					}
				default:
					break;
				}

				System.out.println("HOME PRES 1");
				q = scanner.nextInt();
		}while (q == 1);
		scanner.close();
	
}

}