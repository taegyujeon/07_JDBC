package edu.kh.bookList.model.exception;

public class BookAddException extends RuntimeException{
	public BookAddException(){
		
		super("도서 추가 중 어딘가 문제가 있음");
		
	}
	
	public BookAddException(String message) {
		super(message);
	}

	
}

