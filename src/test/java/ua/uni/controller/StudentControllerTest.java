package ua.uni.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ua.uni.dto.StudentDto;
import ua.uni.service.StudentService;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    StudentService studentSrvice;

    StudentDto st1 = new StudentDto(1L , "a");
    StudentDto st2 = new StudentDto(2L , "b");
    StudentDto st3 = new StudentDto(3L , "c");

    @Test
    void shouldReturnAllStudentsInResponse() throws Exception {
        List<StudentDto> mockStudents = List.of(st1, st2, st3);
        Mockito.when(studentSrvice.getAllStudents()).thenReturn(mockStudents);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/students")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].email", is("a")))
                .andExpect(jsonPath("$[1].email", is("b")))
                .andExpect(jsonPath("$[2].email", is("c")));
    }

    @Test
    void shouldReturnAllStudentsFromService() {
        List<StudentDto> mockStudents = List.of(st1, st2, st3);

        Mockito.when(studentSrvice.getAllStudents()).thenReturn(mockStudents);

        assertEquals(studentSrvice.getAllStudents(), mockStudents);
    }
}