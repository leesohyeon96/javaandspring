package com.example.javaandspring.java;

public class What_is_JVM {

    // 1. JVM이란?
    // - java virtual machine 의 줄임말
    // - java를 실행시키기 위한 가상 기계(=컴퓨터)
    // -> java는 OS에 종속적이지 않은데 이걸 도와주는 것이 JVM이고 JVM은 OS상 위에서 동작함

    // 1-1. 컴파일
    // - java 소스코드는 CPU가 인식하지 못한다. 그래서 뭔가를 해줘야 하는데 그것이 컴파일이고
    //   이때, java는 JVM이라는 가상머신을 거쳐서 OS에 도달하기 때문에 OS가 인식할 수 있는 기계어로
    //        바로 컴파일 되는 것이 아니라 JVM이 인식할 수 있는 Java bytecode(.class)로 변환됨!(ㅇㅎ)
    // - 즉, java compiler가 .java -> .class 파일로 변환시킴
    // - 그리고 이 변환된 bytecode를 JVM이 OS가 이해할 수 있도록 해석해줌

    // 1-2. Java Compiler
    // - 자바 컴파일러는 JDK를 설치하면 javac.exe 라는 실행파일 형태로 설치됨
    // - 구체적으로, JDK의 'bin폴더'에 javac.exe로 존재함
    // - 자바 컴파일러의 'javac'라는 명령어를 사용하면 .class 파일을 생성할 수 있음

    // 1-3. 바이트코드(byte code)란?
    // - 가상 컴퓨터(VM)에 돌아가는 실행 프로그램을 위한 이진 표기법(ㅈㅇ)
    // - 자바 컴파일러에 의해 변환된 코드의 명령어 크기가 -> 1 byte 라서 '자바 바이트 코드'라고 불리고 있음
    // - 이 바이트 코드는 다시 '실시간 번역기' or 'JIT(Just-In-Time) 컴파일러'에 의해 '바이너리(binary)코드'로 변환됨(ㅈㅇ)

    // 1-3-1. JIT란?
    // - 런타임 시 바이트 코드를 -> 원시 시스템 코드로 컴파일하여 java 어플리케이션의 성능을 향상시키는 런타임 환경의 컴포넌트
    // - JVM에는 JIT(컴파일러?) 라는 것이 있고 함수로 자주 호출되면 JIT 호출 임계치를 넘는데 이때 jvm cache에 들어가서 호출 속도가 빨라지게 됨
    //-> 그래서 static 객체의 경우 생성자를 생성하지 않고 private 형태로 생성하는 걸지두..? (함숯형태..?)
    //[확실 ㄴㄴ

    // 1-4. JVM의 메모리 구조
    
    // 2. JDK란?

    // 3. 자바가 동작하는 원리(= 자바 프로그램 실행과정)


    // 4. stack, heap, static
}
