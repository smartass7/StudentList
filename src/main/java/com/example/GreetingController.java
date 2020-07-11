package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

    private Service service = new ServiceImpl();


    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getStudentList(Model model) {
        List<Student> students = service.getAll();
        model.addAttribute("studentList", students);
        return "greeting";
    }

    @RequestMapping(value = "/add-new-student", method = RequestMethod.POST)
    /**Добавление нового студента**/
    public String addNewStudent(@RequestParam(value = "firstName") String firstName,
                                @RequestParam(value = "lastName") String lastName,
                                @RequestParam(value = "patronymic") String patronymic,
                                @RequestParam(value = "passport") String passport,
                                @RequestParam(value = "phoneNumber") String phoneNumber) {
        Student newStudent = new Student();
        newStudent.setFirstName(firstName);
        newStudent.setLastName(lastName);
        newStudent.setPatronymic(patronymic);
        newStudent.setPassport(passport);
        newStudent.setPhoneNumber(phoneNumber);
        service.addStudent(newStudent);
        return "redirect:/greeting";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    /**Удаление студента**/
    public String delete(@PathVariable Integer id) {
        Student studentToRemove = service.getById(id);
        service.removeStudent(studentToRemove);
        return "redirect:/greeting";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    /**Вызов формы изменения данных студента**/
    public String addNewOrderPage(@PathVariable Integer id, Model model) {
        Student studentToEdit = service.getById(id);
        model.addAttribute("firstName", studentToEdit.getFirstName());
        model.addAttribute("lastName", studentToEdit.getLastName());
        model.addAttribute("patronymic", studentToEdit.getPatronymic());
        model.addAttribute("passport", studentToEdit.getPassport());
        model.addAttribute("phoneNumber", studentToEdit.getPhoneNumber());
        return "/edit";
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.GET)
    /**Сохранить изменения**/
    public String save(@PathVariable Integer id,
                       @RequestParam(value = "firstName") String firstName,
                       @RequestParam(value = "lastName") String lastName,
                       @RequestParam(value = "patronymic") String patronymic,
                       @RequestParam(value = "passport") String passport,
                       @RequestParam(value = "phoneNumber") String phoneNumber) {
        Student studentToEdit = service.getById(id);
        studentToEdit.setPhoneNumber(phoneNumber);
        studentToEdit.setPassport(passport);
        studentToEdit.setPatronymic(patronymic);
        studentToEdit.setFirstName(firstName);
        studentToEdit.setLastName(lastName);
        //studentToEdit.setId(id);
        return "redirect:/greeting";
    }

}
