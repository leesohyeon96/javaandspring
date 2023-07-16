package com.example.javaandspring.java;

public class About_private_final_static_field {
    // private final static 필드에 대해서 파헤쳐보자
    // 1. final 키뭐드는 밑에서 사용될 수 있음
        // - 변수
        // - 클래스
        // - 메소드


    // 1-1. 변수

    private final static int num; // static 변수
    private final String name; // 객체 멤버 변수

    static {
        num = 1;
    }

    public About_private_final_static_field(String name) {
        this.name = name;
    }

    // 1-2. 메소드
        // - 메소드에 final을 붙이면 override 제한
    public final void test() {
        System.out.println("final 붙인 메소드");
    }
    class Child extends About_private_final_static_field {

        public Child(String name) {
            super(name);
        }
        
        // 컴파일 에러 : final이 붙었기 때문에 오버라이딩 못함
//        @Override
//        public void test() {
//            
//        }
    }

    // 1-3. 클래스
    final class FinalClass {

    }

    // 컴파일 에러 -> final이 붙어서 상속 불가능 클래스가 됨
//    class ChildClas extends FinalClass{
//
//    }

    // ex) Integer 클래스 -> final class 임! 재정의 불가능하도록 함
}
