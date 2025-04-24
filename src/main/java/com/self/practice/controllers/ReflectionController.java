package com.self.practice.controllers;

import com.self.practice.reflections.ReflectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class ReflectionController {

    @Autowired
    ReflectionsService reflectionsService;

    @GetMapping("/api/reflections")
    public List<String> reflections() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        return reflectionsService.getInfo("com.self.practice.practice.reflections.TestClass");
    }
}
