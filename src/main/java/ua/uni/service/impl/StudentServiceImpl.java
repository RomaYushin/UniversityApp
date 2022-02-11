package ua.uni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.uni.dto.StudentDto;
import ua.uni.exception.StudentNotFountException;
import ua.uni.repository.StudentRepo;
import ua.uni.repository.entity.Student;
import ua.uni.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long studentId) throws StudentNotFountException {
        return studentRepo
                .findById(studentId)
                .map(this::convertToDto)
                .orElseThrow(() -> new StudentNotFountException("User with id: "+ studentId +" not found"));
    }

    private StudentDto convertToDto(Student student) {
        return new StudentDto(student.getId(), student.getEmail());
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteStudent() {
        throw new UnsupportedOperationException();
    }
}
