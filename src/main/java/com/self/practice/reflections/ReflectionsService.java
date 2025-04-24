package com.self.practice.reflections;

import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReflectionsService {

    public List<String> getInfo(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<String> list = new ArrayList<String>();
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        // Create a new instance
        TestClass testClass= (TestClass) constructor.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                if(field.getName().equals("youCantChangeMe")){
                    field.setAccessible(true);
                    field.set(testClass,"I can change your value");
                    list.add(field.getName());
                    list.add((String) field.get(testClass));
                }

            }
            return list;
    }

}
