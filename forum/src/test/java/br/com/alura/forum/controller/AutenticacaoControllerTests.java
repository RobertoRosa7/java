package br.com.alura.forum.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutenticacaoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnBadRequest() throws Exception {
        URI uri = new URI("/auth");
        String body = "{\"email\": \"invalid@gmail.com\", \"senha\":\"1234\"}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

//    @Test
//    public void shouldReturnUser() throws Exception {
//        URI uri = new URI("/auth");
//        String password = new BCryptPasswordEncoder().encode("1234");
//        String body = String.format("{\"email\": \"aluno@gmail.com\", \"senha\":\"%s\"}", password);
//
//        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(body).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().is(200));
//    }
}
