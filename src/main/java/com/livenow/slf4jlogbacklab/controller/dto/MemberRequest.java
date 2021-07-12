package com.livenow.slf4jlogbacklab.controller.dto;

import com.livenow.slf4jlogbacklab.domain.Member;

public class MemberRequest {

    private String name;
    private int age;

    protected MemberRequest() {
    }

    public MemberRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Member toEntity() {
        return new Member(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
