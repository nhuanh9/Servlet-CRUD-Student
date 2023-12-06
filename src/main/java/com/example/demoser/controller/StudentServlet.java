package com.example.demoser.controller;

import com.example.demoser.model.Student;
import com.example.demoser.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "students", value = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        String key = request.getParameter("key");
        if (key != null) {
            request.setAttribute("ds", studentService.findAllName(key));
        } else {
            request.setAttribute("ds", studentService.findAll());
        }
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/edit.jsp");
        Student student = studentService.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("s", student);
        dispatcher.forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double score = Double.parseDouble(request.getParameter("score"));
        String name = request.getParameter("name");
        studentService.edit(id, new Student(id, name, score));
        response.sendRedirect("/students");
    }

    private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double score = Double.parseDouble(request.getParameter("score"));
        String name = request.getParameter("name");
        studentService.add(new Student(id, name, score));
        response.sendRedirect("/students");
    }
}

// /students => list.jsp
// /students?act=create => create.jsp
// /students?act=edit => edit.jsp