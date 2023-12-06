package com.example.demoser.service;

import com.example.demoser.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> list = new ArrayList<>();

    public StudentService() {
        list.add(new Student(1, "A", 20));
        list.add(new Student(2, "B", 20));
        list.add(new Student(3, "C", 20));
        list.add(new Student(4, "C1", 20));
        list.add(new Student(5, "C2", 20));
        list.add(new Student(6, "C3", 20));
    }

    public List<Student> findAll() {
        return list;
    }

    public void add(Student student) {
        list.add(student);
    }

    public Student findById(int id) {
        for (Student s : list
        ) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void edit(int id, Student student) {
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                list.set(i, student);
                break;
            }
        }
    }
    public List<Student> findAllName(String name) {
        List<Student> list1 = new ArrayList<>();
        for (Student s : list
        ) {
            if (s.getName().contains(name)) {
               list1.add(s);
            }
        }
        return list1;
    }

}
