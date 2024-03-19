package edu.kh.bookList.model.dto;

public class Book {
	private int     bookNo;   
	private String 	bookTitle;		
	private String 	bookAuthor;
	private String 	bookPublisher;
	private String  category; 
	private int  stock;

	// 기본 생성자
	public Book() {}
	
	
	// 매개변수 생성자
	public Book(int bookNo, String bookTitle, String bookAuthor, String bookPublisher, String category, int stock) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.category = category;
		this.stock = stock;
	}
	
	
	// getter / setter
	public int getBookNo() {
		return bookNo;
	}



	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}



	public String getBookTitle() {
		return bookTitle;
	}



	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}



	public String getBookAuthor() {
		return bookAuthor;
	}



	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}



	public String getBookPublisher() {
		return bookPublisher;
	}



	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookPublisher="
				+ bookPublisher + ", category=" + category + ", stock=" + stock + "]";
	}
	
	
	
	
	
}
