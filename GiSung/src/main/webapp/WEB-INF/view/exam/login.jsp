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
<script>
	function loginButton() {
		// get 요청을 보낼때,
		url("https://nid.naver.com/nidlogin.login")
				.httpMethod("Get")
				.param ("id", "기성짱짱")
				.param ("pw", "1234")
				.send();
		// https://nid.naver.com/nidlogin.login?id="기성짱짱"&password="1234"


		url("https://nid.naver.com/nidlogin.login")
				.httpMethod("POST")
				.param ("id", "기성짱짱")
				.param ("pw", "1234")
				.send();

	}
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<button onclick="loginButton()">
		로그인
	</button>
</body>
</html>
