<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서 추가</title>
</head>
<body>

    <h1>도서 추가</h1>


    <form action="add" method="POST">

        <div>
        도서 번호 : <input type="text" name="bookNo">
        </div>

        <div>
        도서 제목 : <input type="text" name="bookTitle">
        </div>

        <div>
        저자 : <input type="text" name="bookAuthor">
        </div>

        <div>
        출판사 : <input type="text" name="bookPublisher">
        </div>

        <div>
        카테고리 : <input type="text" name="category">
        </div>

        <div>
        재고수량 : <input type="text" name="stock">
        </div>

        <%-- button의 type 기본값은 submit --%>
        <button type="submit">추가 하기</button>
    </form>
    
</body>
</html>