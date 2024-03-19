package edu.kh.bookList.model.service;

import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dto.Book;
import edu.kh.bookList.model.exception.BookAddException;

public interface BookService {

	/** 전체 도서 조회
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> selectAll() throws SQLException;

	
	/** 도서 추가 서비스
	 * @param book
	 * @return result
	 * @throws BookAddException
	 */
	int addBook(Book book) throws BookAddException;


	/** 도서 검색
	 * @param keyword
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> searchBook(String keyword) throws SQLException;


	/** 카테고리로 검색
	 * @param cate
	 * @return bookList
	 * @throws SQLException
	 */
	List<Book> serchByCategory(String cate) throws SQLException;


}
