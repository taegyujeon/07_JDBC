<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search By Category</title>

</head>
<body>
    <h1>Search By Category</h1>
    
    <c:if test="${not empty bookList}">
        <table border = "1">
            <thead>
                <tr>
                    <th>도서 번호</th>
                    <th>제목</th>
                    <th>저자</th>
                    <th>출판사</th>
                    <th>카테고리</th>
                    <th>재고 수량</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${bookList}">
                    <tr>
                        <td>${book.bookNo}</td>
                        <td>${book.bookTitle}</td>
                        <td>${book.bookAuthor}</td>
                        <td>${book.bookPublisher}</td>
                        <td>${book.category}</td>
                        <td>${book.stock}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <%-- 도서가 검색되지 않았을 경우 메시지 표시 --%>
    <c:if test="${empty bookList}">
        <p>검색된 도서가 왜 없을까</p>
    </c:if>
</body>
</html>