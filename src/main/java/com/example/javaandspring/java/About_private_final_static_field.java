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


    // 2. static
        // - 클래스를 만들고 객체를 생성하면 해당 객체마다 변수를 저장하기 위한 메모리가 별도로 할당됨
        // - 이때, 이 변수가 값이 항상 변하지 않는다면 static 을 사용해
        //   자바가 메모리 할당을 딱 한번만 하게 되어 메모리 낭비를 막을 수 있음

    class StaticClass {
        static String notChange = "안변한다";
    }

     class Sample {
         public static void main(String[] args) {
//             StaticClass staticClass = new StaticClass();
         }
     }

        // - static을 사용하면 '같은 곳의 메모리 주소'만을 바라보기 때문에 static 변수의 값을 공유하게 됨
    class Count {
        static int count = 0; // static을 안붙이면 count 변수가 공유되지 않지만(서로 다른 메모리를 가리키고 있어서) static을 붙이면 값이 공유되어 count값이 2가 되어 출력됨
        Count() {
            count++;
        }
    }

    class Sample2 {
        public static void main(String[] args) {
//            Count c1 = new Count();
//            Count c2 = new Count();
        }
    }

        // - static 메소드는 클래스를 이용하여 호출
        // - static 메소드 안에서는 '객체 변수 접근' 불가능
        class Count2 {
            static int count = 0; // static을 안붙이면 count 변수가 공유되지 않지만(서로 다른 메모리를 가리키고 있어서) static을 붙이면 값이 공유되어 count값이 2가 되어 출력됨
            int count2 = 0;
            Count2() {
                count++;
            }

            public static int getCount() {
//                System.out.println(count2); // 컴파일 에러
                return count; // static 메소드 내에서 static 변수는 접근 가능, 객체 변수는 접근 불가능
            }
        }
        // - 보통 static메소드는 유틸리티성 메소드를 작성할 때 많이 사용됨

ㄷ
    // - staitc import문이란?
        // - JDK1.5부터 추가된 기능임
        // - import문을 사용하면 '클래스의 패키지명'을 생략할 수 있는 것과 같이
        //   static import문을 사용하면 static 멤버를 호출할 때 클래스명을 생략할 수 있음
        //   but, 남용하면 독이 될 수 있음 -> 마치 현재 클래스의 멤버인 것처럼 사용할 수 있기 때문에 혼동을 줄 수 있음
}
