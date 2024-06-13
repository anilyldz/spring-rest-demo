package com.anily.spring_rest_demo.rest;

import com.anily.spring_rest_demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Ryneath", "Swiftsky"));
        students.add(new Student("Danis", "Sageheart"));
        students.add(new Student("Aleturas", "Silentshade"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (isValidStudentId(studentId)){
            return students.get(studentId);
        } else {
            throw new StudentNotFoundException("Student Not Found");
        }
    }

    private boolean isValidStudentId(int studentId) {
        return studentId >= 0 && students.size() >= studentId;
    }

}