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
}
		
		










































