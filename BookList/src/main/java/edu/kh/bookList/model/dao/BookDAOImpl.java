package edu.kh.bookList.model.dao;

import static edu.kh.bookList.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.bookList.model.dto.Book;

public class BookDAOImpl implements BookDAO{
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public BookDAOImpl() {
		
		try {
			
			prop = new Properties();
			String path 
				= BookDAOImpl.class.getResource("/edu/kh/bookList/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<Book> seletAll(Connection conn) throws SQLException{
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			// 조회 결과 한 행씩 접근
			while(rs.next()) {
				int bookNo = rs.getInt("BOOK_NO");
				String bookTitle = rs.getString("BOOK_TITLE");
				String bookAuthor = rs.getString("BOOK_AUTHOR");
				String bookPublisher = rs.getString("BOOK_PUB");
				String category = rs.getString("BOOK_CATE");
				int stock = rs.getInt("BOOK_STOCK");
				
				Book book = new Book(bookNo, bookTitle, bookAuthor,
						                 bookPublisher, category, stock);
				bookList.add(book);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return bookList;
		
		
	}
	
	
	// 도서 추가
	public int addBook(Connection conn, Book book) throws SQLException{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("addBook");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, book.getBookNo());
			pstmt.setString(2, book.getBookTitle());
			pstmt.setString(3, book.getBookAuthor());
			pstmt.setString(4, book.getBookPublisher());
			pstmt.setString(5, book.getCategory());
			pstmt.setInt(6, book.getStock());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// 도서 검색
	public List<Book> searchBook(Connection conn, String keyword) throws SQLException{
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			
			String sql = prop.getProperty("searchBook");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookNo = rs.getInt(1);
				String bookTitle = rs.getString(2);
				String bookAuthor = rs.getString(3);
				String bookPublisher = rs.getString(4);
				String category = rs.getString(5);
				int stock = rs.getInt(6);
				
				Book book = new Book(bookNo, bookTitle, bookAuthor,
            bookPublisher, category, stock);
				
				bookList.add(book);
				
			}
			
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		return bookList;
	}
	
	
	// 카테고리로 검색
	public List<Book> serchByCategory(Connection conn, String cate) throws SQLException{
		
		List<Book> bookList = new ArrayList<Book>();
		
		try {
		
			String sql = prop.getProperty("searchByCategory");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookNo = rs.getInt(1);
				String bookTitle = rs.getString(2);
				String bookAuthor = rs.getString(3);
				String bookPublisher = rs.getString(4);
				String category = rs.getString(5);
				int stock = rs.getInt(6);
				
				Book book = new Book(bookNo, bookTitle, bookAuthor,
            bookPublisher, category, stock);
				
				bookList.add(book);
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return bookList;
	}
	
	
	
	
	
	
	
}
		
		










































