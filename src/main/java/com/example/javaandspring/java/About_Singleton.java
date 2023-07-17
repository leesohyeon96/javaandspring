package com.example.javaandspring.java;

class About_Singleton2 {
    // 싱글톤 패턴
        // - 단 하나의 객체만을 생성하게 강제하는 패턴
    private About_Singleton2() { // private으로 생성자 선언

    }
}

//public class Sample {
//    public static void main(String[] args) {
//        About_Singleton aboutSingleton = new About_Singleton(); // 컴파일 오류 발생
//    }
//}

    // - 그럼 어떻게 싱글톤 객체를 생성할 수 있나?
class Singleton {
    private Singleton() {

    }

    public static Singleton getInstance() {
        return new Singleton(); // 같은 클래스이므로 생성자 호출 가능
    }
}

//public class About_Singleton {
//    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
          //  getInstance라는 static 메소드를 이용해 생성할 수 있지만
          // 이 getInstance()를 계속 호출하면 싱글톤이 아님 그럼 어떻게 해야할까?
//    }
//}

class Singleton3 {
    private static Singleton3 one;
    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if(one == null) {
            one = new Singleton3();
        }
        return one; // 같은 클래스이므로 생성자 호출 가능
    }
    // 객체 존재하면 그 객체 반환하므로써 아무리 getInstance();를 해도 같은 객체가 됨 ! (ㅇㅋ)
}
