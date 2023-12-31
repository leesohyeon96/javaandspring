package com.example.javaandspring.effective_java;

public class 모든객체의_공통메소드_3장 {
    // * Object
        // - final이 아닌 메소드(equals, hashCode, toString, clone, finalize)는 모두 재정의를 염두에 두고 설계된 것
        //   즉, 재정의 시 지켜야 하는 일반 규약이 명확히 정의되어 있음
        // -> 이를 잘못 구현하면 HashMap과 HashSet등을 오작동하게 만들 수 있음


    // * equals
        // - 재정의하지 않는 것이 중요
        // - [아래 상황에서는 재정의 하지 않도록 한다]
            // - 각 인스턴스가 본질적으로 고유함 ex) Thread
            // - 인스턴스의 '논리적 동치성'을 검사할 일이 없음
            // - 상위 클래스에서 재정의 한 equals가 하위 클래스에 딱 들어맞는 경우
            //   대부분의 Set 구현체는 AbstractSet이 구현한 equals를 상속받아 씀
            //   List구현체들은 -> AbstractList로부터
            //   Map구현체들은 -> AbstractMap으로부터 상속받아 그대로 씀
            // - 클래스가 private이거나 package-private이면 equals메소드를 호출할 일이 없음
            //   실수로라도 호출안하게 하기 위해선 이렇게 해야함
            //  ex) @Override public boolean equals(Object o) { throw new AssertionError(); }

        // - 재정의 할때는?
            // - 상위 클래스의 equals가 논리적 동치성을 비교하도록 재정의되지 않았을 때
            // ex) 주로 값 클래스 -> Integer, String
            // - but, 값 클래스라고 해도 같은 인스턴스가 2개 이상 만들어지지 않음이 보장된 경우
            //   equals를 재정의하지 않아도 됨! ex) Enum

        // - Object 명세에 적힌 equals 메소드를 재정의 할때의 일반 규약
            // - equals메소드는 동치관계를 구현하며 다음을 만족
                // - 반사성 : null이 아닌 모든 참조 값 x에 대해, x.equals(x)는 true
                // - 대칭성 : null아닌 모든 참조 값 x,y에 대해 x.equals(y)가 true면 y.equals(x)도 true다
                // - 추이성 : null아닌 몯느 참조 값 x,y,z에 대해 x.equals(y)가 true고 y.equals(z)도 true면 x.equals(z)도 true다
                // - 일관성 : null아닌 모든 참조 값 x,y에 대해 x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환함
                // - null 아님 : null이 아닌 모든 참조 값 x에 대해 x.equals(null)은 false임
        // - equals 메소드 구현 방법 [단계적]
            // 1. == 연산자를 사용해 입력이 자기 자신의 참조인지 확인 -> 단순한 성능 최적화
            // 2. instanceof 연산자로 입력이 올바른 타입인 지 확인 -> 그렇지 않으면 false반환
            //    이걸로 null 검사도 할 수 있음 ㅇㅇ
            // 3. 입력을 올바른 타입으로 형변환 -> 2번의 단계로 이 단계는 100% 성공
            // 4. 입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는 지 하나씩 검사함 -> 모든 필드가 일치하면 true, 하나라도 다르면 false
            // (float, double을 제외한 기본 타입 필드는 ==로 비교, 참조타입필드는 equals 메소드로 비교)
            // float, double의 경우는 '부동 소수값'을 다뤄야하기때문 !

        // - equals의 성능
            // - 어떤 필드를 먼저 비교하느냐가 성능을 좌우하는데
            //   '다를 가능성이 더 크거나' && '비교하는 비용이 싼' 필드를 먼저 비교
        // - equals의 입력타입은 무조건 (Object o) 여야 함 !
        // [결론] 꼭 필요한 경우가 아니면 equals를 재정의하지 말자! 정 안되면 ㅋ다섯가지 규약을 확실히 지켜가며 비교해야 함





    // * hashCode
        // - equals를 재정의한 클래스 모두에서 hashCode도 재정의 해야 함!


}
