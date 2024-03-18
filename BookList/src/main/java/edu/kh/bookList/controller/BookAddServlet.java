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
import jakarta.websocket.Session;

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
			
			BookService sevice = new BookServiceImpl();
			
			String bookNo = req.getParameter("bookNo");
			String bookTitle = req.getParameter("bookTitle");
			String bookAuthor = req.getParameter("bookAuthor");
			String bookPublisher = req.getParameter("bookPublisher");
			String category = req.getParameter("category");
			String stock = req.getParameter("stock");
			
			Book book = new Book(bookNo, bookTitle, bookAuthor, bookPublisher, category, stock);
			
			int result = service.addBook(book);
			
			String message = null;
			
			if(result > 0) 	message = "도서 추가 성공!!";
			else						message = "도서 추가 실패...";
			
			Session.setAttribute("message", message);
			
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


