package ua.uni.service;

import ua.uni.dto.StudentDto;
import ua.uni.exception.StudentNotFountException;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long studentId) throws StudentNotFountException;

    void updateStudent(StudentDto studentDto);

    void createStudent(StudentDto studentDto);

    void deleteStudent();


}
