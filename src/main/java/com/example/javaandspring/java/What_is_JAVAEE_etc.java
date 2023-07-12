package com.example.javaandspring.java;

public class What_is_JAVAEE_etc {
    // - 모든 자바 플랫폼들은 [JVM + API(Application Programing Interface)]로 구성되있음
    //   각각의 자바 플랫폼에서는 JVM, API를 제공함으로써 타겟 플랫폼상에서 동작되도록 작성된 어플리케이션들이 자바 프로그래밍 언어의 장점
    //   들을 그대로 갖출 수 있게 함
    //   *API : 쉽게말하면 '개발에 도움되는 함수들을 모아둔 곳'
    // - ** 자바 프로그래밍 언어에는 '4가지 플랫폼'이 존재함

    // 1. Java SE
        // SE(Standard Edition)
        // - 가장 대중적인 '자바 플랫폼'
        // - 흔히 '자바 언어'라고 하는 대부분의 패키지가 포함된 에디션
        // - ex) java.lang.* | java.util.* | java.awt.* | java.io.* | javax.rmi.* | javax.net.* 등
        // - Java SE의 API는 자바 프로그래밍 언어의 핵심기능들을 제공
            // - 기초적인 타입 | 네트워킹 | 보안 | 데이터베이스 처리 | 그래픽사용자 인터페이스 개발 | XML 파싱
        // - 가상머신, 개발도구, 배포기술, 부가 클래스 라이브러리, 툴킷 등 제공
    // 2. Java EE
        // - EE(Enterprise Edition)
        // - Java SE 플랫폼을 기반으로 그 위에 탑재됨
        // - 웹 프로그래밍에 필요한 기능을 다수 포함
            // - ex) JSP, Servlet, JSON, JDBC, JNDI, JTA, EJB, REST 반응형 클라이언트 API, 웹소켓 등
        // - 대규모, 다계층, 확장성, 신뢰성, 보안, 네트워킹 API, 환경 등을 제공
    // 3. Java ME
        // - ME(Micro Edition)
        // - 모바일폰과 같은 자바 프로그래밍 언어 기반의 어플리케이션이 보다 '조그만 가상 머신으로 동작'시킬 수 있는 기능과 API 제공
        // - Java EE처럼 Java SE를 기반으로 그 위에 탑재됨
        // - Java EE 서비스의 클라이언트 역할을 하기도 함
    // 4. Java FX
        // - 경량 사용자 인터페이스 API를 사용하여 리치 인터넷 어플리케이션을 만들 때 사용됨
        // - 하드웨어 수준에서 가속 기능을 사용할 수 있는 그래픽/미디어엔진을 갖추고 있어
        //   클라이언트의 성능에 신경을 써야하는 분야에서 사용됨
        // - Java EE처럼 클라이언트 역할을 하기도 함

    // [결론]
    // - Java EE = Java SE + API(lib 디렉토리에 포함되어 있는 Jar 파일들)
}
