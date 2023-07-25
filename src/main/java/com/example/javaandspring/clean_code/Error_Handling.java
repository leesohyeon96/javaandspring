package com.example.javaandspring.clean_code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Error_Handling {
    // [오류 처리]
        // 1. 오류 코드보다 '예외를 사용해라'
            // 그냥 하나의 메소드안에서 if, else if로 처리하기 보다는
            // 에러를 처리하는 메소드, 오류를 잡아내는 메소드 나눠서 처리하도록
            // -> 깔끔하게 보이고 + 품질도 향상 시키라는 말 ㅇㅇ

        // 2. try-catch-finally 문부터 작성해라

        // 3. 미확인(unChecked) 예외를 사용해라
            // - 런타임 예외를 사용하란 말!
            // - 확인(checked) 예외가 캡슐화를 깨트림
            //   ex) 확인된 오류를 던지면 함수(반드시 처리해야함 안하면 컴파일 에러)는
            //       선언부에 throws 절을 추가해 함
            //       또는 catch 블록에서 새로운 예외를 처리하거나
            // - 결과적으로 최하위단계 ~ 최상위 단계까지 연쇄적인 수정이 필요함 ㅇㅇ
}

class ExceptionExample {
    public String test(String sectionName) throws FileNotFoundException { // 처리 일단 해논거 ㅇㅇ
        try { // 처리 일단 해논거 ㅇㅇ
            FileInputStream stream = new FileInputStream(sectionName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // FileInputStream 에서 컴파일 에러가 나는데 throws로 에러를 넘기거나,
        // try-catch문을 사용해서 꼭 처리해야 함

        return null;
    }
}
    // 4. 예외에 의미를 제공해라
        // - 예외 던질때 전후 상황을 충분히 덧붙여야 함(원인, 위치를 찾기 쉬움ㅇㅇ)
        // - throw new xxxException("당신이 이런이런이유로 잘못해서 발생햇어요");

    // 5. null을 반환하지 마라
        // - if(xx != null) {} 이거 많이 쓰면 가독성 어렵고 중간에 빼먹을 수도 있고
        //   따라서 애초에 저 코드를 작성하지 않도록 null 을 반환하지 않도록 해야함

        // - 그럼 어케함?
class Example1 {
    List<String> stringList = returnStringList();
        // - 이처럼 null을 반환하지 않도록 '빈 리스트'를 반환하는 코드를 만든다


    public List<String> returnStringList() {
        List<String> test = new ArrayList<>(); // dao에서 뭔가를 가져오는 코드가 있다고 가정
        if(test == null) { // 근데 dao에서 뭔가를 가져오는데 실패해도 이 코드 덕분에 무조건 null이 반환되지 않도록 할 수 있음!!
            return Collections.emptyList(); // 미리 정의된 읽기 전용 리스트를 반환함!
        }
        return test;
    }
    // [ㅈㅇ!]
    // - Collections.emptyList() VS new ArrayList();
        // - Collections.emptyList()
            // 1. static으로 이미 만들어진 객체 -> 따라서 cpu,메모리 추가비용 발생하지 않음!
            // 2. final로 불변 객체를 리턴 -> 따라서 객체를 받아 값을 변경(.add())해야하는 경우 적합하지 않음 ㅇㅇ
        // - new ArrayList()
            // 1. 객체를 받아 값을 변경하는 등 추가 작업이 필요한 경우 이걸 쓰는게 적합!


    // [결론] null처리를 하는 거보단 '애초에 null반환을 하지 않도록 하자!' (ㅇㅋ)
}
