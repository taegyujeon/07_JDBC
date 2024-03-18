package edu.kh.bookList.model.exception;

public class BookAddException {
	public BookAddException(){
		
		super("도서 추가(ADD) 중 예외 발생(제약 조건 위배)");
		
	}
	
	public BookAddException(String message) {
		super(message);
	}
	
}

