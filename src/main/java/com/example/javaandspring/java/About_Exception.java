package com.example.javaandspring.java;

public class About_Exception {

    // *자바의 예외
    // 종류
    // 1. UnCheckedException(=RuntimeException)
        // - (컴파일러가 에러처리를 확인하지 않음)에러 처리를 강제하지 않는 '실행(runtime)중에 발생할 수 있는 예외'
        // - ex) ArrayIndexOutOfBoundsException, NullpointerException
        // **에러처리를 강제하지 않는 이유?
        // - 단순히 배열을 만들 때 int[] list = {1,2,3}; 할때도 try/catch문으로 묶어야 되기 때문
        // - !! 롤백됨
    // 2. CheckedException
        // - RuntimeException이외의 모든 Exception의 하위클래스들
        // - 반드시 예외처리를 해야함 -> throw하던지, try/catch하던지 
        // - ex) FileNotFoundException, ClassNotFoundException, IOException, SQLException 등
        // - !! 롤백되지 않고 트랜잭션이 커밋까지 완료됨
    // 3. Error(에러)
        // - 시스템이 비정상적인 상황이 발생할 경우 발생
        // - ex) 메모리 부족, 스택오버플로우
        // - 에러는 개발자가 예측하기 어렵고, 처리할 수 있는 방법x


    // - try/catch 처리
        // - Java SE7 부터는 '|' 기호를 사용하여 하나의 catch 블록ㅇ서 여러 타입의 예외를 동시에 처리 가능
        // ex) catch(IOException | SQLException e) {
        // - 위처럼 둘 이상의 예외 타입을 동시처리하는 catch 블록에서는 매개변수로 전달받은 예외객체는 묵시적으로 'final 제어자'를
        //   가지게 되어 catch 블록 내에서 해당 매개변수에는 어떠한 값도 대입할 수 없음

    // - Throwable 클래스
        // - 모든 예외의 조상이 되는 Exception 클래스 + 모든 오류의 조상이 되는 Error 클래스의 => 부모 클래스
        // - 이 타입과 이 클래스를 상속받은 서브타입들만이 -> JVM, throw 키워드에 의해 던져질 수 있음(ㅇㅋ)
        // - 메소드 종류
            // - getMessage : 해당 throwable 객체에 대한 자세한 내용을 문자열로 반환함
            // - printStackTrace : 해당 throwable 객체와 표준 오류스트림에서 핻아 객체의 스택 트레이스를 출력함
            // - toString : 해당 throwable 객체에 대한 간략한 내용을 문자열로 반환함

}
