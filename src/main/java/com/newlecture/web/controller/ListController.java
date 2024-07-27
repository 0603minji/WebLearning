package com.newlecture.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/exam/list")
@MultipartConfig(
        maxFileSize = 100 * 1024 * 1024,
        maxRequestSize = 200 * 1024 * 1024)
public class ListController extends HttpServlet {
    public static class Score {
        // 멤버 변수
        public String name;
        private int kor;
        private int eng;
        private int math;
        private int total;
        private double avg;
        private String grade;

        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            total = kor + eng + math;
            avg = total / 3.0;

            if (avg > 90) grade = "A";
            else if (avg > 80) grade = "B";
            else grade = "C";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKor() {
            return kor;
        }

        public void setKor(int kor) {
            this.kor = kor;
        }

        public int getEng() {
            return eng;
        }

        public void setEng(int eng) {
            this.eng = eng;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public double getAvg() {
            return avg;
        }

        public void setAvg(double avg) {
            this.avg = avg;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        // 멤버 함수
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 리스트 생성
         * List<객체> list = new ArrayList<>();
         *
         * 2. 리스트에 값 추가
         * list.add(객체);
         */
        Score score1 = new Score("gisung", 100, 100, 100);
        Score score2 = new Score("minji", 100, 100, 100);


        List<Score> hashList = new ArrayList<>();
        hashList.add(score1);
        hashList.add(score2);

        request.setAttribute("scores", hashList);
        request.getRequestDispatcher("/WEB-INF/view/exam/list.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //	Part 인터페이스
        //	getSubmittedFileName : Part로 업로드된 파일의 원래 파일 이름을 가져오기 위해 사용
        //	getPart : HTTP multipart/form-data 요청으로 전송된 파일요청에서 파일 부분을 가져옴
        //			  Part 클래스의 함수
        Part imgPart = req.getPart("img");
        String imgName = imgPart.getSubmittedFileName();
        InputStream is = imgPart.getInputStream();

        String realPath = req.getServletContext().getRealPath("/notice/upload");
        System.out.println(realPath);

        File pathFile = new File(realPath);
        if (!pathFile.exists())
            pathFile.mkdirs();

        String path = realPath + File.separator + imgName;
        FileOutputStream fos = new FileOutputStream(path);

        //	1 byte 크기의 원소를 가지는 배열 선언 buf
        byte[] buf = new byte[1024];

        //	write 함수 :
        for (int size = 0; (size = is.read(buf)) != -1; )
            fos.write(buf, 0, size);
        System.out.println(imgName);
    }
}
