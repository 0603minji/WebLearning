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
import java.util.SortedMap;

@WebServlet("/exam/list")
@MultipartConfig(
        maxFileSize = 100 * 1024 * 1024,
        maxRequestSize = 200 * 1024 * 1024)

public class ListController extends HttpServlet {
    public static class Score implements Comparable<Score>{
        // 멤버 변수
        private String name;
        private int kor;
        private int eng;
        private int math;
        private int total;
        private double avg;
        private String grade;

        // 생성자
        /*
         TODO:
          1. 점수는 0 - 100 범위를 벗어날 수 없다. 벗어난 데이터는 모두 0 처리한다.
          2. 이름은 3글자를 넘을수 없다. 3글자를 넘으면, 3글자만 사용한다.
            ㄴ 문자열의 자르는 방법은 "박기성바보".substring(시작인덱스, 끝인덱스)
          3. 이름이 빈 문자열(길이가 0) 인 애는 제외한다.
         */
        public Score(String name, int kor, int eng, int math) {

            // 1. 점수 유효성 검사
            if (kor < 0 || kor > 100)
                kor = 0;
            if (eng < 0 || eng > 100)
                eng = 0;
            if (math < 0 || math > 100)
                math = 0;

            // 2. 이름 유효성 검사
            if (name.length() > 3)
                name = name.substring(0, 3);

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


        /**
         * 1. 리턴값이 양수이면, 내가 더 커  == 내가 뒤에 갈 거야
         * 2. 리턴값이 음수면, 내가 더 작아 == 내가 앞에 갈 거야
         */
        @Override
        public int compareTo(Score compare) {
            return compare.total - total;
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

            //  name 유효성 검사
            if (score.name.equals(""))
                continue;
            list.add(score);
        }
        return list;
    }


    /**
     * TODO: 성적 목록에 성적이 높은순으로 출력되도록 고쳐보세요.
     * ex. List를 오름차순으로 정렬하는 방법은 list.sort() 입니다.
     * 내림차순으로 정렬하는 방법을 찾아보세요.
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Score> list = getScores();
        list.sort(Score::compareTo);

        request.setAttribute("scores", list);
        request.getRequestDispatcher("/WEB-INF/view/exam/list.jsp")
                .forward(request, response);
    }
}

