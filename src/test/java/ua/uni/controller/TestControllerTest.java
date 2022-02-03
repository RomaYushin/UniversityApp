package ua.uni.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnStaticMessage() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/test")
                .contentType(MediaType.TEXT_PLAIN);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Server is ok"));
    }
}