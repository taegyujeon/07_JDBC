<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${param.keyword} 검색 결과</title>

    <script src="script.js"></script>

</head>
<body>

    <h1>${param.keyword} 검색 결과</h1>
    <%-- empty : 비어있거나 null인 경우 true 반환 --%>
    <c:if test="${empty bookList}" >
        <h3>검색 결과가 없습니다</h3>
    </c:if>

    <%-- not empty : 비어 있지 않거나, null이 아닌 경우 true --%>
    <c:if test="${not empty bookList}" >

        <table border="1">
            <thead>
                <tr>
                    <th>도서 번호</th>
                    <th>도서 제목</th>
                    <th>저자</th>
                    <th>출판사</th>
                    <th>카테고리</th>
                    <th>재고수량</th>
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
                    </tr>
                
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
</body>
</html>