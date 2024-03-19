package edu.kh.bookList.model.service;

import static edu.kh.bookList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.bookList.model.dao.BookDAO;
import edu.kh.bookList.model.dao.BookDAOImpl;
import edu.kh.bookList.model.dto.Book;
import edu.kh.bookList.model.exception.BookAddException;


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
	
	
	
	// 부서 추가 서비스
	public int addBook(Book book) throws BookAddException {
		
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			
			result = dao.addBook(conn, book);
			
			if(result > 0)	commit(conn);
			else						rollback(conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			rollback(conn);
			
			throw new BookAddException();
			
		} finally {
			close(conn);
		}
		
		return result;
		
	}
	
	
	// 도서 검색
	@Override
	public List<Book> searchBook(String keyword) throws SQLException {
		
		Connection conn = getConnection();
		
		List<Book> bookList = dao.searchBook(conn, keyword);
		
		return bookList;
	}
	
	
	// 카테고리로 검색
	@Override
	public List<Book> serchByCategory(String cate) throws SQLException{
		
		Connection conn = getConnection();
		
		List<Book> bookList = dao.serchByCategory(conn, cate);
	
		return bookList;
		
	}
	
	
	
}















































