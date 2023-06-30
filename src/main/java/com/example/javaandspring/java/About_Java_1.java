package com.example.javaandspring.java;

public class About_Java_1 {

    public static void main(String[] args) {

    }

    /*
    1. 자바란?
    - 씬 마이크로시스템즈에서 1995년 개발한 객체 지향 프로그래밍 언어
    2. 객체 지향 프로그래밍이란?
    - 실생활에서 사용하는 것을 객체라고 한다음 객체들간의 상호작용을 통해 프로그램을 만드는 것
    3. 객체 지향 프로그래밍의 4가지 특징
    - 추상화, 상속, 다형성, 캡슐화
    */

    // 추상화 예시 -> 공통되는 부분은 모아서 클래스로 만드는 것이 추상화
    static class dog {
        public void bark() {
            System.out.println("개가 짖는다 멍멍");
        }
    }

    static class bark {
        public void bark() {
            System.out.println("고양이가 짖는다 미야옹");
        }
    }

    // 위의 dog, bark의 객체들은 공통된 메소드를 가지고 있기 때문에 추상화(공통점: 동물임)를 한 객체를 만들어 extends(확장)하기로 한다
    // interface로 만들거나, abstract class로 만든다
    static abstract class animal {
        public void bark() {}
    }
    
    static class abstractDog extends animal {
        @Override
        public void bark() {
            System.out.println("추상화가 적용된 개가 짖는다 추멍추멍");
        }
    }

    static class abstractCat extends animal {
        @Override
        public void bark() {
            System.out.println("추상화가 적용된 고양이가 짖는다 추먕추먕");
        }
    }


    // 상속 예시

    // 다형성 예시

    // 캡슐화 예시

}
