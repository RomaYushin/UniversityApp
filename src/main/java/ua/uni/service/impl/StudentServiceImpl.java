package ua.uni.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.uni.dto.StudentDto;
import ua.uni.repository.StudentRepo;
import ua.uni.repository.entity.Student;
import ua.uni.service.StudentSrvice;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentSrvice {

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

    private StudentDto convertToDto(Student student) {
        return new StudentDto(student.getId(), student.getEmail());
    }
}
