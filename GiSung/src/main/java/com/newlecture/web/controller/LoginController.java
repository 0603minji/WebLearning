package com.newlecture.web.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/login")
@MultipartConfig(
        maxFileSize = 100 * 1024 * 1024,
        maxRequestSize = 200 * 1024 * 1024)
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String id = request.getParameter("password");


        request.getRequestDispatcher("/WEB-INF/view/exam/login.jsp")
                .forward(request, response);
    }








}
