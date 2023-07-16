package com.example.javaandspring.java;

public class About_private_final_static_field {
    // private final static 필드에 대해서 파헤쳐보자

    private final static int num; // static 변수
    private final String name; // 객체 멤버 변수

    static {
        num = 1;
    }

    public About_private_final_static_field(String name) {
        this.name = name;
    }
}
