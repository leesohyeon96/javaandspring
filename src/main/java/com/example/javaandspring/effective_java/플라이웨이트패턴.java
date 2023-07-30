package com.example.javaandspring.effective_java;

public class 플라이웨이트패턴 {
    // 생성자로 객체를 계속 생성하기 보다 '정적 팩토리 메소드'를 만들어
    // 새로 생성한 인스턴스를 캐싱하여 재활용하거나
    // 인스턴스를 미리 만들어놓는 등의 방식으로 성능을 상당히 끌어올려주는 방식과 비슷한
    // '플라이웨이트패턴'

    // - 정의
        // - 어떤 클래스의 인스턴스 1개만 가지고 여러개의 '가상 인스턴스'를 제공하고 싶을 때 사용하는 패턴!
        // - new 연산자를 통한 메모리 낭비를 줄이는 방식!(ㅇㅋ)
}

