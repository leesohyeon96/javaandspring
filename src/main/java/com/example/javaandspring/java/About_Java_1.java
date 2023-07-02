package com.example.javaandspring.java;

import java.sql.SQLOutput;

public class About_Java_1 {

    public static void main(String[] args) {

        // 3-2. 상속
        //        Child child = new Child();
        //        child.useParentsPrivate();


        // 3-3. 다형성
//        Me me2 = new Developer();
//        me2.doSomething();

        // 3-4. 캡슐화
//        Encapsulation encapsulation = new Encapsulation();
//        encapsulation.method();     // 모든 클래스에서 접근 가능
//        encapsulation.method2();    // 다른 패키지의 확장한 클래스까지 접근 가능
//        encapsulation.method3();    // 동일 패키지 내에서만 접근 가능
//        encapsulation.method4();    // 동일 클래스 내에서만 접근 가능

    }

    /*
    1. 자바란?
    - 씬 마이크로시스템즈에서 1995년 개발한 객체 지향 프로그래밍 언어
    2. 객체 지향 프로그래밍이란?
    - 실생활에서 사용하는 것을 객체라고 한다음 객체들간의 상호작용을 통해 프로그램을 만드는 것
    3. 객체 지향 프로그래밍의 4가지 특징
    - 추상화, 상속, 다형성, 캡슐화
    */

    // 3-1. 추상화 예시 -> 공통되는 부분은 모아서 클래스로 만드는 것이 추상화
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


    // 3-2. 상속 예시
    // - 객체들 간의 관계를 구축하는 방법
    // - 기반/수퍼/부모 클래스 등의 기존 클래스로부터 속성(field)/동작(method)를 상속받을 수 있음
    // - sealed로 봉인된 클래스는 상속 불가능
    static class Parent {
        private int money;
        private String face;
    }

    static class Child extends Parent {
        private void useParentsPrivate() {
            System.out.println("부모의 필드 사용하기 : " + super.money);
            // 위의 MAIN()에서 서버 가동해보기
        }
    }

    // 3-3. 다형성 예시
    // - 다형성은 한 타입의 참조변수를 통해 여러 타입의 객체를 참조할 수 있도록 만든 것을 의미함
    //   (구체적으로 상위 클래스 타입의 참조변수로 하위 클래스의 객체를 참조할 수 있도록 하는 것)
    // - '나는 친구가 될 수도 있고, 회사원이 될 수도 있고, 개발자가 될 수도 있고, 결혼해서 부모가 될 수도 있다'
    // - ex) 오버라이딩, 오버로딩
    // -> 보통 인터페이스로 하는데 클래스로 일단락한다.
    static class Me {
        void doSomething() {
            System.out.println("나는 뭔가 할 수 있음");
        }
    }

    static class Parents extends Me{
        @Override
        void doSomething() {
            System.out.println("나는 부모가 될 수 있음");
        }
    }
    
    static class Developer extends Me {
        @Override
        void doSomething() {
            System.out.println("나는 개발자가 될 수 있음");
        }
    }

    // 3-4. 캡슐화 예시
    // - 클래스 안에 있는 속성/기능들을 하나의 캡슐로 만들어 데이터를 외부로부터 보호하는 것
    // - 이유: 데이터 보호(외부로부터 클래스에 정의된 필드, 메소드 보호), 데이터 은닉(내부 메소드 숨기고, 외부에 필요한 부분만 노출)

    static class Encapsulation {
        public void method() {
            System.out.println("public method");
        }

        protected void method2() {
            System.out.println("protected method");
        }

        void method3() {
            System.out.println("default method");
        }

        private void method4() {
            System.out.println("private method");
        }
    }

}
