package com.self.practice.reflections;

public class TestClass {

    private String name;
    private int id;

    private final String youCantChangeMe="Try me chaning";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
