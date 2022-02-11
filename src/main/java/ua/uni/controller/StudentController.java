package ua.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.uni.dto.StudentDto;
import ua.uni.exception.StudentNotFountException;
import ua.uni.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentDto getStudentById(@PathVariable Long id) throws StudentNotFountException {
        return studentService.getStudentById(id);
    }
}
