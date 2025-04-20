package com.example.api.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.util.DummyDataGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;


@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private DummyDataGenerator generator;

    @GetMapping("")
    public String getStr() throws Exception{
        var dataList = generator.get(3);
        var mapper = new ObjectMapper();
        var jtm = new JavaTimeModule();
        mapper.registerModule(jtm);

        return mapper.writeValueAsString(dataList);
    }

    @GetMapping("/localDateFormat")
    public String getStrLocalDate() throws Exception{

        var dataList = generator.get(3);
        var mapper = new ObjectMapper();
        var jtm = new JavaTimeModule();
        jtm.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        mapper.registerModule(jtm);
        
        return mapper.writeValueAsString(dataList);
    }

    @GetMapping("/localDateTimeFormat")
    public String getStrLocalDateTime() throws Exception{

        var dataList = generator.get(3);
        var mapper = new ObjectMapper();
        var jtm = new JavaTimeModule();
        jtm.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        mapper.registerModule(jtm);
        
        return mapper.writeValueAsString(dataList);
    }

}
