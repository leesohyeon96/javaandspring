package com.example.javaandspring.java;

public class About_DesignPattern {
    // *디자인 패턴이란?
        // - 소프트웨어 개발에서 빈번히 발생하는 문제를 해결하기 위한 일종의 '설계 방식' 의미
        // - 이 패턴들을 통해 '코드 설계에 대한 방향성 공유' 가능
        // - 이로 인해 '코드의 유지보수와 재사용성 향상' 가능

    // *종류
        // - 생성 패턴(Creational Pattern)
            // - 객체 생성에 대한 디자인 패턴
            // - 종류
                // Singleton
                // Abstract Factory
                // Builder
                // Factory Method
                // Prototype
         // - 구조 패턴(Structural Pattern)
            // - 클래스와 객체를 조합하는 방식을 정형화한 패턴
            // - 종류
                // Adapter
                // Bridge
                // Composite
                // Decorate
                // Facade
                // Flyweight
                // Proxy
        // - 행동 패턴(Behavioral Pattern)
            // - 클래스와 객체들의 상호 작용과 책임 분산을 정리한 패턴
            // - 종류
                // Observer
                // Command
                // Interpreter
                // Iterator
                // Mediator
                // Memento
                // State
                // Strategy
                // Template Method
                // Vistor



    // 구조 패턴 - 어뎁터(Adapter)패턴
        // 정의: 호환되지 않는 인터페이스들을 연결하는 디자인 패턴
        // 특징: 기존 클래스 수정하지 않고도 특정 인터페이스에서 필요로 하는 코드에서 사용할 수 있게 해줌
        // 구성요소[4가지]
            // - 타겟: 클라이언트가 직접적으로 호출하는 interface
            // - 어뎁티: 아직 호환되지 않은 기존 클래스(or 인터페이스)
            // - 어뎁터: 타겟 interface를 구현하여 클라이언트 요청을 어뎁티로 전달하는 클래스
            // - 클라이언트: 특정 작업을 요청하는 클래스
    class Adapter {

    }
}
