package com.bigProject.RealEstate.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public abstract class BaseControllerTest {

    @Autowired

    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;
}
