package com.newlecture.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/exam/register")
public class ExamRegisterController extends HttpServlet {

    /**
     * 입력폼 입력 이후, 호출되는 컨트롤러
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int korean = Integer.parseInt(request.getParameter("kor"));
        int english = Integer.parseInt(request.getParameter("eng"));
        int math = Integer.parseInt(request.getParameter("math"));
        System.out.println(name + " : " + korean + " : " + english + " : " + math);

        /*
         todo:
          1.파일 함수 만들어서 "C:/Users/gisung/Desktop/민지자바웹/scores.csv" 경로에 학생 성적을 써보세요.
          * hint.
             1. 객체 생성을 new Score({이름}, {국어}, {영어}, {수학}); 을 이용하세요
             2. Score 객체 내에, scv 형태의 문자열로 반환하는 toCSVString() 함수를 만들어 보세요
                ㄴ return 값은 "{이름},{국어},{영어},{수학}" 무자열을 반환합니다.
         */

        ListController.Score newScore = new ListController.Score(name, korean, english, math);

        newScore.toCSVString();


        request.getRequestDispatcher("/WEB-INF/view/exam/list.jsp")
                .forward(request, response);
    }
}
