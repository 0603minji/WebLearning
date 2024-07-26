package com.newlecture.web.repository;

import java.io.IOException;
import java.util.List;

import com.newlecture.web.entity.Exam;

public interface Repository<T> {

	List<Exam> findAll() throws IOException;
	int save(); 
	int update();
}
