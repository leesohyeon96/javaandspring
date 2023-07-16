package com.example.javaandspring.java;

public class About_recursive_call {
    // - 재귀호출(recursive call)
        // - 자기 자신을 호출하는 메소드를 -> 재귀 메소드
        // - StackOverFlow를 발생시킬 수 있기 때문에 조심해야 함
        // - '피보나치 수' 구할때 쓰임
        // - Stack 형식을 가짐\

    public int recursiveMethod(int intValue) {
        if(intValue <= 10) {
            return 1;
        }
        return recursiveMethod(intValue);
    }
}
