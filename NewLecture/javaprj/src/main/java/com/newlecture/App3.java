package com.newlecture;

import com.newlecture.web.entity.Exam;
import java.lang.reflect.InvocationTargetException;

public class App3 {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
    	{
        Exam exam = new Exam();
        String csv = CSVParser.toCSV(exam);
        
        System.out.println(csv);
    	}
    }
}





//package com.newlecture;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.newlecture.web.entity.Exam;
//
//public class App3 {
//	public static void main(String[] args)
//			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
//			NoSuchMethodException, SecurityException, ClassNotFoundException {

//		{
//			Exam exam = new Exam();
//			CSVParser parser = new CSVParser();
//			StringBuilder builder = new StringBuilder();
//			String csv = parser.toCSV(exam);
//			System.out.println(csv);
//			
//		}

//		{
//
//			Exam exam = new Exam();
//
//			// CSVParser를 사용하여 Exam 객체를 CSV 형식으로 변환
//			String csv = CSVParser.toCSV(exam);
//
//			// 결과 출력
//			System.out.println(csv);
//		}
//
//	}
//
//}

//		{
//
//			// Exam 객체를 담을 리스트 생성
//			List<Exam> exams = new ArrayList<>();
//
//			// foreach 문을 사용하여 각 Exam 객체를 CSV 형식으로 변환하고 출력
//			for (Exam exam : exams) {
//				String csv = CSVParser.toCSV(exam);
//				System.out.println(csv);
//			}
//		}
//
//		{
//			// Exam exam = new Exam();
//			String className = "com.newlecture.web.entity.Exam";
//
//			Exam exam = (Exam) Class.forName(className).getDeclaredConstructor().newInstance();
//
//			System.out.println(exam);
//
//			Class clazz = exam.getClass();
//			//Class clazz2 = Exam.class;
//			
//			Method[] methods = clazz.getDeclaredMethods();
//
//		
//			for (Method m : methods) {
//				System.out.println(m.getName());
//			}
//			exam.setKor(30);
//			System.out.println(exam);
//		}
//
//	}

//			[ Reflection ]
//			Java에서 클래스의 메타데이터를 조회하거나 동적으로 객체를 생성하거나 메서드를 호출하는 기능 제공
//			컴파일 타임에 알 수 없는 클래스 정보에 접근 가능
//			런타임에 클래스 구조를 분석하거나 조작 가능
//
//			1. 클래스 정보 조회
//				: 클래스의 메타데이터를 조회하여 클래스 이름, 메서드, 필드, 생성자 등의 정보 얻음
//			2. 객체 생성
//				: 클래스의 이름을 문자열로 알고 있을 때, 그 클래스의 인스턴스를 동적으로 생성
//			3. 메서드 호출
//				: 특정 메서드를 동적으로 호출할 수 있습니다. 이 메서드는 메서드 이름, 파라미터 타입 등을 런타임에 결정
//			4. 필드 접근
//				: 클래스의 필드에 접근하여 값을 읽거나 수정
//			
//			[ Reflection 클래스 및 메서드 ]
//			1.	Class 클래스
//				-	클래스에 대한 메타데이터를 제공
//				-	클래스 이름, 메서드, 필드, 생성자 등을 조회
//				-	Class.forName(String className) : 클래스 이름을 문자열로 받아서 Class 객체를 반환
//				-	clazz.getDeclaredMethods() : 클래스의 모든 메서드를 배열로 반환
//				-	clazz.getDeclaredFields() : 클래스의 모든 필드를 배열로 반환
//			2.	Method 클래스: 클래스의 메서드에 대한 정보를 제공하며, 메서드를 동적으로 호출
//				-	Method.getName() : 메서드의 이름을 반환
//				-	method.invoke(Object obj, Object... args) : 메서드를 호출하고 결과를 반환
//			3.	Field 클래스: 클래스의 필드에 대한 정보를 제공하며, 필드의 값을 읽거나 쓸 수 있습니다.
//				-	Field.get(Object obj) : 객체의 필드 값을 반환
//				-	Field.set(Object obj, Object value) : 객체의 필드 값을 설정
