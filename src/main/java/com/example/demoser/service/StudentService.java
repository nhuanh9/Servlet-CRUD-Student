package com.example.demoser.service;

import com.example.demoser.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    Connection connection = ConnectionCreator.getConnection();

    public StudentService() {
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from student");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double score = rs.getDouble("score");
                String name = rs.getString("name");
                list.add(new Student(id, name, score));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void add(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student (name, score) values (?, ?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDouble(2, student.getScore());
            int rs = preparedStatement.executeUpdate();
            System.out.println(preparedStatement);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Student> fetchDataFromDatabase(int currentPage, int recordsPerPage) {
        List<Student> list = new ArrayList<>();
        try {
            int offset = (currentPage -1 ) * recordsPerPage;
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from student LIMIT ? OFFSET ?");
            preparedStatement.setInt(1, recordsPerPage);
            preparedStatement.setInt(2, offset);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                double score = rs.getDouble("score");
                String name = rs.getString("name");
                list.add(new Student(id, name, score));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

//    public Student findById(int id) {
//    }
//
//    public void edit(int id, Student student) {
//    }
//    public List<Student> findAllName(String name) {
//    }

}
