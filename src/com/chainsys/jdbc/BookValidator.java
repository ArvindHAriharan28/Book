package com.chainsys.jdbc;

public class BookValidator {
	public void validateadd(Book book) throws Exception {

		if (book.name.equalsIgnoreCase("null")) {
			throw new Exception("invalid name");
		}
		if (book.price <= 0) {
			throw new Exception("invalid price");
		}

	}
	public void validateUpdate(Book book) throws Exception {

		if (book.name == null) {
			throw new Exception("invalid name");
		}
		if (book.id <= 0) {
			throw new Exception("invalid id");
		}

	}
	public void validateDelete(Book book) throws Exception {

		if (book.id <= 0) {
			throw new Exception("invalid id");
		}

	}
	public void validateFindById(Book book) throws Exception {

		if (book.id <= 0) {
			throw new Exception("invalid id");
		}

	}
}
