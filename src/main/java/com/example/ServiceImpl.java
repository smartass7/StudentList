package com.example;

import java.util.List;

public class ServiceImpl implements Service {

    private StudentRepository studentRepository = new StudentRepositoryImpl();

    public void addStudent(Student student) {
        if(student!=null) {
            List<Student> students = studentRepository.getAll();
            if(!students.isEmpty()) {
                Student lastStudent = students.get(students.size() - 1);
                student.setId(lastStudent.getId()+1);
                studentRepository.addStudent(student);
                } else {
                studentRepository.addStudent(student);
                student.setId(0);
            }
            }
        }



    public void removeStudent(Student student) {
        if(student!=null){
            studentRepository.removeStudent(student);
        }
    }

    public void editStudent(Student student, String firstName, String lastName, String patronymic, String passport, String phoneNumber, int id){
        if(student!=null){
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPatronymic(patronymic);
        student.setPassport(passport);
        student.setPhoneNumber(phoneNumber);
        student.setId(id);}
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public Student getById(Integer id) {
        if(id!=null) {
            return studentRepository.getById(id);
        }
        return null;
    }

}
