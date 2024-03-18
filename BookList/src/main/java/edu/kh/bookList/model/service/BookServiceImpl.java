package edu.kh.bookList.model.service;

import static edu.kh.bookList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dao.BookDAO;
import edu.kh.bookList.model.dao.BookDAOImpl;
import edu.kh.bookList.model.dto.Book;

public class BookServiceImpl implements BookService{
	
	private BookDAO dao= new BookDAOImpl();
	
	// 전체 도서 조회
	@Override
	public List<Book> selectAll() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Book> bookList = dao.seletAll(conn);
		
		close(conn);
		
		return bookList;
	}	
	
	
}
