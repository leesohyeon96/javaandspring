package com.example.javaandspring.java;

public class What_is_interface {
    // 인터페이스
        // - 클래스를 이용하여 다중 상속을 할 경우 '메소드 출처의 모호성' 등 여러가지 문제가 많음
        // - 위의 문제점 + 다중상속의 이점을 포기할 수 없는 이유 등으로 인해 나온 것이 '인터페이스'

        // - 정의 : 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서
        //         다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 '추상 클래스'
        // - *추상클래스 vs 인터페이스
            // - 추상클래스는 상속을 위해 만들어진 클래스고
            //   추상메소드, 생성자, 필드, 일반 메소드도 포함 가능하지만
            // - 인터페이스는 only '추상 메소드'와 '상수'만 포함 가능하다는 차이점!

        // - 인터페이스 선언 -> 접근제어자 interface 인터페이스 이름
        // - 장점
            // -  클래스와 클래스 간의 관계를 인터페이스로 연결하면, 클래스마다 독립적인 프로그래밍이 가능함

        // - 자바8부터 default메소드(암시적 public)와 static메소드를 추가할 수 있는데
            // - 인터페이스가 여러곳에서 사용되고 있는 상황에 새로운 추상메소드를 추가하면
            //   모든 곳에서 오버라이딩(ㄷㄷ) 해야되기 떄문에 나온 것이 '구현부를 가질 수 있는' default메소드!
}

interface Test {
    default void defaultMethod() {
        System.out.println("나는 디폴트 메소드다!");
    }

    void abstractMethod();

    static void staticMethod() {
        System.out.println("나는 스태틱 메소드다!");
    }
}