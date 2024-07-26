package com.newlecture.web.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.controller.*;
import com.newlecture.web.entity.*;
import com.newlecture.web.repository.FileExamRepository;
import com.newlecture.web.repository.Repository;
import com.newlecture.web.repository.jdbc.JDBCExamRepository;

public class ExamService  {

	private Repository<Exam> repository;

	public ExamService(Repository<Exam> repository) {
		this.repository = repository;
	}
	
	public List<Exam> getList() throws IOException {
		return getList(1);
	}	
	
	public List<Exam> getList(int page) throws IOException {

		List<Exam> list = repository.findAll();
		return list;
	}
	
	
	
	
}
