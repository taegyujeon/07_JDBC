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

	

	/** 도서 추가
	 * @param conn
	 * @param book
	 * @return result
	 * @throws SQLException
	 */
	int addBook(Connection conn, Book book) throws SQLException;


	
	/** 도서 검색
	 * @param conn
	 * @param keyword
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> searchBook(Connection conn, String keyword) throws SQLException;



	/** 카테고리로 검색
	 * @param conn
	 * @param cate
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> serchByCategory(Connection conn, String cate) throws SQLException;

}
