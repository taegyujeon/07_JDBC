package edu.kh.bookList.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.Book;

public interface BookDAO {

	/** 전체 도서 조회
	 * @param conn
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> seletAll(Connection conn) throws SQLException;

}
