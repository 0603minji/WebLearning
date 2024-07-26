<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>성적목록${name}</h1>
		<table>
			<caption>성적출력</caption>
			<thead>
				<tr>
					<th>이름</th>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>총점</td>
					<td>평균</td>
					<td>학점</td>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="exam" items="${list}">
					<tr>
						<!-- <a href="detail">: HTML에서 하이퍼링크를 생성하는
				<a> : html에서 하이퍼링크를 생성하는 태그 
				href="detail" : 이 링크가 "detail" 페이지로 이동한다는 것 -->
						<th><a href="detail">${exam.name}</a></th>
						<td>${exam.kor}</td>
						<td>${exam.eng}</td>
						<td>${exam.math}</td>
						<td>${exam.total}</td>
						<td><fmt:formatNumber pattern="##.##" value="${exam.avg}"></fmt:formatNumber></td>
						<td>${exam.grade}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<nav id="pager">
		<ul>
			<li><a href="list?p=1&c=red&c=blue">1</a></li>
			<li><a href="?p=2&c=blue&c=red">2</a></li>
			<li><a href="?p=3&c=green">3</a></li>
			<li><a href="?p=4&c=red">4</a></li>
			<li><a href="?p=5&c=red">5</a></li>
		</ul>
	</nav>

	<section>
		<form>
			<fieldset>
				<legend>페이지 입력</legend>
				<label>page</label><input name="p">
			</fieldset>
			<fieldset>
				<legend>좋아하는 색상</legend>
				<lable> <input name="c" type="checkbox">빨강</lable>
				<lable> <input name="c" type="checkbox">파랑</lable>
			</fieldset>
			<div>
				<input type="submit" value="전송">
				<button>전송</button>
			</div>
		</form>
	</section>

	<section>
		<form method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>파일업로드</legend>
				<label>파일선택<input name="img" style="display: none;" type="file"></label>
				<button>업로드</button>
			</fieldset>
		</form>
	</section>
	
	<section>
	<div>
	<img src="/javaprj/notice/upload/puppy.jpeg">
	</div>
	<div>
	<a download href = "/javaprj/notice/upload/puppy.jpeg">download</a>
	</div>
	</section>
	
	

	<div>1</div>
	<div>1</div>
	<div>1</div>
	<div>1</div>
	<div>1</div>
</body>
</html>