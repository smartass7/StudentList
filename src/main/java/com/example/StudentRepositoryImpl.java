package com.example;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> students = new ArrayList<Student>();

    public StudentRepositoryImpl() {

        Student student1 = new Student();
        student1.setFirstName("Виталий");
        student1.setPatronymic("Витальевич");
        student1.setLastName("Сыров");
        student1.setPassport("8080524585");
        student1.setPhoneNumber("+7999854589");
        students.add(student1);

    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void editStudent(Student student, String firstName, String lastName, String patronymic, String passport, String phoneNumber, int id) {
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPatronymic(patronymic);
        student.setPassport(passport);
        student.setPhoneNumber(phoneNumber);
        student.setId(id);
    }


    public List<Student> getAll() {
        return students;
    }

    public Student getById(Integer id) {
        for (int i=0; i <= students.size(); i++ ){
            if (students.get(i).getId()==id){
            return students.get(i);
            }
        }
        return null;
    }
}
