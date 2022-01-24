package ua.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.uni.dto.StudentDto;
import ua.uni.service.StudentSrvice;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private StudentSrvice studentSrvice;

    @Autowired
    public StudentController(StudentSrvice studentSrvice) {
        this.studentSrvice = studentSrvice;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDto> getAllStudents() {
        return studentSrvice.getAllStudents();
    }
}
