package com.newlecture.web.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.newlecture.web.controller.*;
import com.newlecture.web.entity.*;
import com.newlecture.web.repository.FileExamRepository;

public class ExamService {

	private FileExamRepository repository = new FileExamRepository();

	public List<Exam> getList() throws IOException {
		return getList(1);
	}

	
	
	public List<Exam> getList(int page) throws IOException {

		List<Exam> list = repository.findAll();
		return list;
	}
}
