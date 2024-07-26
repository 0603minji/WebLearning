package com.newlecture;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.newlecture.annotations.Transient;
import com.newlecture.web.entity.Exam;

public class CSVParser {
	public static String toCSV(Exam exam)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {

		StringBuilder builder = new StringBuilder();

		Class cls = exam.getClass();
		Method[] methods = cls.getDeclaredMethods();
		
		System.out.println("=====================");
		for(Method m : methods) {
			String name = m.getName();
			if(name.startsWith("get")){
				if(m.getAnnotation(Transient.class)==null)
					System.out.println(name);
			}
		}
//		
//		
//		String className = "com.newlecture.web.entity.Exam";
//
//		Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
//
//		Class clazz = exam.getClass();
//		Method[] methods = clazz.getDeclaredMethods();
//		String frontText = "get";
//
//		for (Method m : methods) {
//			if (m.getName().startsWith(frontText))
//				System.out.println(m.getName());
//		}
		System.out.println("=====================");
		return builder.toString();
	}

}
