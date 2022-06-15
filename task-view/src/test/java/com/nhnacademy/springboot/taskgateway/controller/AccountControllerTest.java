package com.nhnacademy.springboot.taskgateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springboot.taskgateway.enumm.State;
import com.nhnacademy.springboot.taskgateway.request.AccountRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class AccountControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void registerForm() throws Exception {
        this.mvc.perform(get("/account/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth/joinForm"));
    }

    @Test
    void doRegister() throws Exception {
        AccountRegisterRequest body = new AccountRegisterRequest();
        String requestBody = new ObjectMapper().writeValueAsString(body);

        this.mvc.perform(post("/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().is3xxRedirection())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

   // @Test
//    void accountList() throws Exception{
//        this.mvc.perform(get("/account/list/JOIN/1")
//                        .cookie())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(view().name("participant/accountList"));
//    }
}