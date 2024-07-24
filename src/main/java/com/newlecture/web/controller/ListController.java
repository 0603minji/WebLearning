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
import java.util.List;

@WebServlet("/exam/list")
@MultipartConfig(
        maxFileSize = 100 * 1024 * 1024,
        maxRequestSize = 200 * 1024 * 1024)
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; UTF-8");
        PrintWriter out = resp.getWriter();
        List<Exam> list = List.of(
                new Exam("민지", 100, 100, 100),
                new Exam("기성", 100, 100, 100)
        );
        System.out.println(list);
//		----------------------------------------------------

        req.setAttribute("list", list);
//		// /exam/list -> forward -> /WEB-INF/view/exam/list.jsp
        req.getRequestDispatcher("/WEB-INF/view/exam/list.jsp").forward(req, resp);
        // resp.sendRedirect("list.jsp");
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
