package com.example;

import com.example.Student;

import java.util.List;

public interface Service {

    void addStudent(Student student);

    void removeStudent(Student student);

    void editStudent(Student student, String firstName, String lastName, String patronymic, String passport, String phoneNumber, int id); /****/

    List<Student> getAll();

    Student getById(Integer id);
}