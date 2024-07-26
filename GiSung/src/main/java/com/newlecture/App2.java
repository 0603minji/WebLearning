package com.newlecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Exam;

public class App2 {

	// Object 클래스는 자바 모든 클래스의 부모
	// class App2 extends Object
	public static void main(String[] args) {
		
		// HasMap ================================================
		{
			// 어떤 자료형의 값이 와도 되도록 설정하려면 : Object
			Map<String, Object> map = new HashMap();
			map.put("id", 1);
			map.put("title", "hi! hello!");
			map.put("writerId", 3);
			map.put("content", "nothig! empty!");
			
			String title = (String)map.get("title");
			
			for(String key : map.keySet())
				System.out.println(key);
			
			for(Object val : map.values())
				System.out.println(val);
			
			
			for(Map.Entry<String, Object> entry : map.entrySet())
				System.out.printf("key : %s, val : %s\n", entry.getKey(), entry.getValue());
		}

		// List ==================================================================================
		{
			// 구조체 : ArrayList()
			// Generics 사용 : <Integer>
			List<Integer> list = new ArrayList<>();
			list.add(3);
			list.add(3);
			list.add(4);
			list.add(3);

			int size = list.size();
			System.out.println(size);
			// get(n) : list에 있는 n번째를 꺼냄
			int num = list.get(0);
		}

		
		// HashSet =============================================
		{
			// 오토 박싱
			Exam exam = new Exam("hong", 1, 1, 1);
			Exam exam1 = new Exam("ha", 2, 2, 2);

			
			Set<Exam> set = new HashSet<>();

			set.add(exam);
			set.add(exam1);
			set.add(new Exam("x", 3, 3, 3));
			set.add(new Exam("y", 4, 4, 4));

			int size = set.size();
			System.out.println(size);

			Iterator it = set.iterator();
			while (it.hasNext())
				System.out.println(it.next());
		}

		// 향상된 for문 : 주로 배열이나 컬렉션을 순회할 때 사용
		// 기존의 for문보다 코드를 간결하게 작성할 수 있는 장점

//		for (변수선언 : 반복대상)
//		변수선언 : 반복하는 동안 사용할 변수를 선언
//		반복대상 : 배열이나 컬렉션		

//		[ Iterator ]
//		컬렉션에 저장된 요소를 읽어올때 사용하는 인터페이스
//		List, Set, Map (컬렉션 클래스들)은 Iterator를 구현하여 컬렉션 내의 요소들을 반복적으로 접근 가능
//		주요 메서드
//			-	boolean hasNext(): 다음 요소가 있으면 true 반환
//			-	E next(): 다음 요소 반환
//			-	void remove(): 최근 반환된 요소를 삭제
//							   반드시 next() 메서드 호출 이후에 호출

		// contains(n) : set이 n을 가지고 있는지 t/f
		// boolean hasNum = set.contains(3);

		
		
	}

}
