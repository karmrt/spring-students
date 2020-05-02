package com.kcs.students.controller;

import com.kcs.students.entity.Student;
import com.kcs.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/")
    public String index() {
        if (studentRepository.count() < 1) {
            studentRepository.save(new Student("Vardas", "Pavarde", "email@gmail.com", "88888"));
            studentRepository.save(new Student("Vardas1", "Pavarde2", "2@gmail.com", "22222"));
        }

        StringBuilder out = new StringBuilder();
        out.append("Viso studentu: ").append(studentRepository.count()).append("<br>");
        out.append("Studentai:<br>");

        Iterable<Student> students = studentRepository.findAll();
        for (Student student : students) {
            out.append(student).append("<br>");
        }

        return out.toString();
    }
}
