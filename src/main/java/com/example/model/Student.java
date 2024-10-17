package com.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Student {

    private Long rollId;
    private String name;
    private Integer marks;

    public Student(){}

    public Student(Long rollId, String name, Integer marks) {
        this.rollId = rollId;
        this.name = name;
        this.marks = marks;
    }

    public Long getRollId() {
        return rollId;
    }

    public String getName() {
        return name;
    }

    public Integer getMarks() {
        return marks;
    }

    public void setRollId(Long rollId) {
        this.rollId = rollId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }
}
