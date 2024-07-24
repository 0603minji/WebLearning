<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav>
	<h1>로또 복권 프로그램 메뉴</h1>
	<ul>
		<li><a href="gen-manual">1. 수동 발권</a></li>
		<li><a href="gen-auto">2. 자동 발권</a></li>
		<li><a href="print">3. 발권 번호 조회</a></li>
	</ul>
</nav>


	<hr>
	허재완
	<hr>
	   <h1>[로또 복권 프로그램]</h1>
   <section>


      <form method="post">
         <fieldset>
            <ul>
               <li>1. 수동 발권</li>
               <li>2. 자동 발권</li>
               <li>3. 발권번호 조회</li>
               <li>4. 종료</li>
            </ul>
            <div>
               <label>메뉴</label> <input name="menu">
            </div>
         </fieldset>
         <button>메뉴 입력</button>
      </form>
   </section>
   
   <hr>
   	시니
   <hr>
	   <form action="" method="GET">
	            <h1>[로또 복권 프로그램]</h1>
	<input type="submit" name="genManual" value="1. 수동 발권">
	<input type="submit" name="genAuto" value="2. 자동 발권">
	<input type="submit" name="print" value="3. 발권 번호 조회">
	<input type="submit" name="exit" value="4. 종료">
	</form>
	
	<hr>
	 최윤성
	<hr>
	
	포기

   
</body>
</html>