package ua.uni.service.impl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ua.uni.dto.StudentDto;
import ua.uni.repository.StudentRepo;
import ua.uni.repository.entity.Student;
import ua.uni.service.StudentService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(StudentServiceImpl.class)
class StudentServiceImplTest {
    
    @MockBean
    StudentRepo studentRepo;

    @Autowired
    StudentService studentService;
    
    @Test
    void getAllStudents() {
        Student st1 = new Student();
        st1.setId(1L);
        st1.setEmail("a");

        Student st2 = new Student();
        st2.setId(2L);
        st2.setEmail("b");

        Student st3 = new Student();
        st3.setId(3L);
        st3.setEmail("c");

        StudentDto stDto1 = new StudentDto(1L, "a");
        StudentDto stDto2 = new StudentDto(2L, "b");
        StudentDto stDto3 = new StudentDto(3L, "c");

        List<Student> mockStudents = List.of(st1, st2, st3);
        List<StudentDto> mockStudentsDto = List.of(stDto1, stDto2, stDto3);

        Mockito.when(studentRepo.findAll()).thenReturn(mockStudents);

        assertTrue(Arrays.deepEquals(studentService.getAllStudents().toArray(), mockStudentsDto.toArray()));
    }
}