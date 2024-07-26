package com.newlecture.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("exam/listcontroller")

//서블릿에서 multipart/form-data 형식의 요청을 처리할 수 있도록 지정
@MultipartConfig(
		maxFileSize = 100*1024*1024,
		maxRequestSize = 200*1024*1024)
public class ExamListController extends HttpServlet {
	private ExamService service;

	public ExamListController() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		// 응답 콘텐츠 타입을 설정
		response.setContentType("text/html; UTF-8");

		// 클라이언트에게 HTML 문서를 반환하는 기본적인 서블릿 예제
		// 서블릿에서 HTTP 응답을 클라이언트에 전송할 때 사용
		// response 객체는 서블릿이 클라이언트에게 응답을 작성하는 데 사용되는 HttpServletResponse 객체
		// getWriter() 메서드 호출하여 PrintWriter를 얻은 후,응답 본문에 데이터를 작성
		PrintWriter out = response.getWriter();

		String color;

		// [ request ]
		// HttpServletRequest 객체
		// 클라이언트(브라우저)가 보낸 HTTP 요청 정보
		// [ getParameterValues(String name)]
		// 요청 파라미터 이름에 해당하는 모든 값을 배열로 반환하는 메서드
		// "c": 클라이언트가 제출한 데이터에서 name 속성이 "c"인 파라미터의 값을 배열로 반환
		String[] colors = request.getParameterValues("c");
		System.out.println(colors);

		int page = 1;
		// [ getParameter(String name)
		// 요청 파라미터의 이름(name)으로 값을 반환하는 메서드
		String page_ = request.getParameter("p");

		if (page_ != null)
			page = Integer.parseInt(page_);

		List<Exam> list = service.getList(page);
		System.out.println(list);

		// 가져온 리스트를 request 객체에 저장하여 JSP 페이지 등에서 사용할 수 있도록
		request.setAttribute("list", list);
		// 요청을 다른 서블릿, JSP, 또는 HTML 파일로 전달할 때 사용
		request.getRequestDispatcher("/WEB-INF/view/exam/listview.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 클라이언트가 전송한 파일이나 데이터 중 name="img"인 파트를 가져옴
		// 파일 업로드를 처리할 때 사용되는 코드
		// 클라이언트가 전송한 파일을 Part 객체로 가져옴
		// [ multipart/form-data ]
		// HTTP 프로토콜의 POST 요청을 통해 데이터를 서버로 전송할 때 사용
		// [ Part 인터페이스 ]
		// multipart/form-data 형식의 HTTP 요청에서 파트를 다루기 위한 API
		
		// [ getSubmittedFileName ]
		// Part로 업로드된 파일의 원래 파일 이름을 가져오기 위해 사용
		// 파일 업로드와 같은 큰 데이터 전송에 사용
		
		// [ getPart ]
		// HTTP multipart/form-data 요청으로 전송된 파일요청에서 파일 부분을 가져옴
		Part imgPart = request.getPart("img");
		String imgName = imgPart.getSubmittedFileName();

		// 클라이언트가 업로드한 파일의 내용을 InputStream을 통해 읽기 위한 것
		// Java에서 데이터를 읽기 위한 추상 클래스
		// 파일, 네트워크 소켓 등 다른 입력 소스에서 바이트 스트림을 읽는 데 사용
		// 파일이나 다른 데이터 소스에서 데이터를 바이트 단위로 읽음
		// Part 객체에서 파일의 내용을 읽기 위한 InputStream
		InputStream is = imgPart.getInputStream();

		// [ getServletContext() ]
		//현재 요청이 처리되고 있는 서블릿의 ServletContext 객체를 반환
		// [ ServletContext ]
		//웹 애플리케이션의 전체적인 환경을 나타냄 
		//애플리케이션의 전역 설정에 접근할 수 있는 방법을 제공
		
		// [ getRealPath(String path) ] 
		//웹 애플리케이션의 루트 디렉토리를 기준으로 주어진 경로의 절대 경로를 반환 
		//상대 경로를 파일 시스템의 절대 경로로 변환
		String realPath = request.getServletContext().getRealPath("/notice/upload");
		System.out.println(realPath);

		
		// [ File 클래스 ]
		//Java에서 파일 및 디렉토리를 다루기 위한 클래스
		//java.io 패키지에 포함
		//파일 시스템 내의 파일이나 디렉토리를 나타냄
		File pathFile = new File(realPath);
		// [ pathFile.exists() ]
		//File 객체가 나타내는 파일 또는 디렉토리가 실제로 존재하는지 확인
		if (!pathFile.exists())
		// [ pathFile.mkdirs() ]
		//경로에 있는 디렉토리를 생성
			pathFile.mkdirs();

		String path = realPath + File.separator + imgName;
		FileOutputStream fos = new FileOutputStream(path);

		byte[] buffer = new byte[1024];
		for (int size = 0; (size = is.read(buffer)) != -1;)
			fos.write(buffer, 0, size);

		System.out.println(imgName);

	}

}
