package com.newlecture.web.controller;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/exam/list")
@MultipartConfig(
        maxFileSize = 100 * 1024 * 1024,
        maxRequestSize = 200 * 1024 * 1024)
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 리스트 생성
         * List<객체> list = new ArrayList<>();
         *
         * 2. 리스트에 값 추가
         * list.add(객체);
         */

        HashMap<String, Object> hash = new HashMap();
        hash.put("name", "gisung");
        hash.put("kor", 100);
        hash.put("eng", 100);
        hash.put("math", 100);
        hash.put("total", 100);
        hash.put("avg", 100);
        hash.put("grade", "A");

        HashMap<String, Object> hash1 = new HashMap<>();
        hash1.put("name", "minji");
        hash1.put("kor", 70);
        hash1.put("eng", 70);
        hash1.put("math", 70);
        hash1.put("total", 70);
        hash1.put("avg", 70);
        hash1.put("grade", "B");

        List<HashMap<String, Object>> hashList = new ArrayList<>();
        hashList.add(hash1);
        hashList.add(hash);

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
