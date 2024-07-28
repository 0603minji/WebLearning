<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- JSTL(JavaServer Pages Standard Tag Library)은
자바 웹 개발에서 많이 사용되는 태그 라이브러리
JSP 페이지에서 자바 코드를 최소화하고
비즈니스 로직을 분리하기 위해 사용
HTML 코드와 자바 코드가 혼재되어있는 jsp 문서를 JSTL을 사용하면
HTML과 유사한 태그를 사용하여 데이터를 출력하고 제어-->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>


<body>

<section>
    <h1>성적 등록</h1>
    <%--
    method가 "post" 로 선언되어 있어
    "/exam/register" url로 post요청이 보내진다.
      --%>
    <form style="border: 1px solid black;" action="/exam/register" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="kor">국어 점수:</label>
        <input type="number" id="kor" name="kor" min="0" max="100" required><br><br>

        <label for="eng">영어 점수:</label>
        <input type="number" id="eng" name="eng" min="0" max="100" required><br><br>

        <label for="math">수학 점수:</label>
        <input type="number" id="math" name="math" min="0" max="100" required><br><br>
        <input type="submit" value="제출">
    </form>
</section>


<section>
    <h1>성적목록</h1>
    <table style="border: 1px solid black;">
        <thead>
        <tr>
            <th>이름</th>
            <th>국어</th>
            <th>영어</th>
            <th>수학</th>
            <th>총점</th>
            <th>평균</th>
            <th>학점</th>
        </tr>
        </thead>
        <tbody>
        <!--
        var : 반복 변수 / 출력 대상 list의 원소 형태
        items : 출력 대상 list
        -->
        <%--
           todo:
           1. 페이지 번호가 짝수면, 짝수 라인 노랑색
           2. 페이지 번호가 홀수면, 홀 수 라인 하늘색
           3. foreach 돌때, index를 확인해서 index도 짝수인지 확인
           --%>

<%--        for(int i = 0; i< list.size(); i++ ){--%>
        <c:forEach var="item" items="${scores}" varStatus="status">
            <c:if test="${currentPage  % 2== 0 && status.index % 2== 0}">
                <tr style="background-color: blue">
            </c:if>
            <c:if test="${currentPage % 2== 1 && status.index % 2== 1}">
                <tr style="background-color: yellow">
            </c:if>
            <td>${item.name}</td>
            <td>${item.kor}</td>
                <td>${item.eng}</td>
                <td>${item.math}</td>
                <td>${item.total}</td>
                <td><fmt:formatNumber pattern="##.##" value="${item.avg}"></fmt:formatNumber></td>
                <td>${item.grade}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav id="pager">
        <ul>
            <c:forEach var="i" begin="1" end="${endPage}">
                <li><a href="?page=${i}&c=red">${i}</a></li>
            </c:forEach>
        </ul>
    </nav>
</section>
</body>
</html>
