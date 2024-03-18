package edu.kh.bookList.model.service;

import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.Book;

public interface BookService {

	/** 전체 도서 조회
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> selectAll() throws SQLException;

}
