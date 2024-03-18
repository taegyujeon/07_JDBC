<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>전체 도서 조회</title>
</head>
<body>

<h1>전제 도서 조회</h1>

	<table border="1">
	
		<thead>
			<tr>
				<th>도서 번호</th>
				<th>도서 제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>카테고리</th>
				<th>재고수량</th>

				<th>수정 버튼</th>
				<th>삭제 버튼</th>
			</tr>
		</thead>
		
		
		<tbody>
			<c:forEach items="${bookList}" var="book" varStatus="vs">
				
				<tr>
					<td>${book.bookNo}</td>
					
					<td>${book.bookTitle}</td>
					
					<td>${book.bookAuthor}</td>

					<td>${book.bookPublisher}</td>
					
                    <td>${book.category}</td>
					
                    <td>${book.stock}</td>

					<th>
						<button type="button" class="update-btn">수정</button>
					</th>

					<th>
						<button type="button" class="delete-btn">삭제</button>
					</th>
				</tr>
			
			</c:forEach>
		</tbody>
	
	
	</table>
    
</body>
</html>