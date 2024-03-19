package edu.kh.bookList.controller;

import java.io.IOException;

import edu.kh.bookList.model.dto.Book;
import edu.kh.bookList.model.service.BookService;
import edu.kh.bookList.model.service.BookServiceImpl;
import edu.kh.bookList.model.exception.BookAddException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bookList/add")
public class BookAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/add.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		  // 서비스 객체 생성
			BookService service = new BookServiceImpl();
			
		  // 파라미터 얻어오기
			int bookNo = Integer.parseInt(req.getParameter("bookNo"));
			String bookTitle = req.getParameter("bookTitle");
			String bookAuthor = req.getParameter("bookAuthor");
			String bookPublisher = req.getParameter("bookPublisher");
			String category = req.getParameter("category");
			int stock = Integer.parseInt(req.getParameter("stock"));
			
			Book book = new Book(bookNo, bookTitle, bookAuthor, bookPublisher, category, stock);
			
			int result = service.addBook(book);
			
			String message = null;
			
			HttpSession session = req.getSession();
			
			if(result > 0) 	message = "도서 추가 성공!!";
			else						message = "도서 추가 실패...";
			
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/bookList/selectAll");
			
			
		} catch(BookAddException e) {
			
			req.setAttribute("errorMessage", e.getMessage());

			String path = "/WEB-INF/views/error.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}


