package com.example;

import java.util.ArrayList;
import java.util.List;

public interface StudentRepository  {


    void addStudent (Student student);
    void removeStudent (Student student);
    void editStudent (Student student, String firstName, String lastName, String patronymic, String passport, String phoneNumber, int id);
    List<Student> getAll();
    Student getById(Integer id);

}
