package com.anily.spring_rest_demo.rest;

import com.anily.spring_rest_demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Ryneath", "Swiftsky");
        Student student2 = new Student("Danis", "Sageheart");
        Student student3 = new Student("Aleturas", "Silentshade");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        return students;
    }
}