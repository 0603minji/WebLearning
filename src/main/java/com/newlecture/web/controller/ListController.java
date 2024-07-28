package com.newlecture.web.controller;

import com.newlecture.web.entity.Exam;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        // 생성자
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

        // 멤버 함수
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

        @Override
        public String toString() {
            String formattedAvg = String.format("%.2f", getAvg());

            return "Score{" +
                    "name='" + name + '\'' +
                    ", kor=" + kor +
                    ", eng=" + eng +
                    ", math=" + math +
                    ", total=" + total +
                    ", avg=" + formattedAvg +
                    ", grade='" + grade + '\'' +
                    '}';
        }
    }


    public static List<Score> getScores() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("C:/Users/gisung/Desktop/민지자바웹/scores.csv");
        Scanner scan = new Scanner(fis);

        List<Score> list = new ArrayList<>();

        //scan.nextLine(); // 컬럼명 버리기

        while (scan.hasNextLine()) {
            String name;
            int kor, eng, math;
            // -----------------------------
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            // System.out.printf("tokens:", Arrays.toString(tokens));

            name = tokens[0];
            kor = Integer.parseInt(tokens[1]);
            eng = Integer.parseInt(tokens[2]);
            math = Integer.parseInt(tokens[3]);

            Score score = new Score(name, kor, eng, math);
            list.add(score);
        }
        return list;
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("scores", getScores());
        request.getRequestDispatcher("/WEB-INF/view/exam/list.jsp")
                .forward(request, response);
    }
}

