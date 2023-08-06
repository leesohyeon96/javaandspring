package com.example.javaandspring.effective_java;

import java.util.List;

public class 객체생성과파괴_2장 {

//    (32~33페이지)
//  1. 인터페이스에 정적 메소드를 선언할 수 있다
//  -> 이로인한 장점? (그전에는 선언할 수 없었음)
//    ex) java.util.Collections (인스턴스화 불가 클래스) -> 얘를 정적 펙토리 메소드를 통해 얻도록 함!? 이로인해 실제 구현 클래스가 뭔지 몰라도 개발자가 collections의 기능을 사용할 수 있음?
//
//  2. p34 또 다른 객체를 반환한다는게 구현체로 뭘 선택하든 클라이언트는 몰르고 몰라도됨 (숨길수있다는 장점?) -> 코드로 안보이니 잘모르겠네
//
//  3.  34p 서비스 제공자 프레임워크는 -> 3개으 ㅣ핵심 컴포넌트로 이뤄짐
//  => 인터페이스(구현체의 동작을 정의함) + 제공자등록API(제공자가 구현체를 등록할때 사용함) + 서비스 접근 API(클라이언트가 서비스의 인스턴스를 얻을 때 사용함)
//  —> 클라이언트는 서비스접근APi를 사용할 때 원하는 구현체의 조건을 명시가능 ㅇㅇ 이게 바로 '유연한 정적 팩토리'의 실체!
//            (+ 4번째 컴포넌트는 '서비스 제공자 인터페이스(인터페이스의 인스턴스를 생성하는 팩터리 객체를 설명해줌)'
//            -> 이게 없으면 각 구현체를 인스턴스로 만들 때 '리플랙션'을 사용해야 함)
//    ex) JDBC -> connection이 서비스 인터페이스 역할
//		       -> driverManger.registerDriver가 제공자 등록 APi역할
//		       -> DriverManager.getConnect이 서비스 접근 APi 역활
//		       -> Driver 가 서비스 제공자 인터페이스 역할
//
//            (ㅇㅎ) ㅈㅇ!
//  4. 35p 서비스 제공자 프레임워크 패턴이 있는데 여기에는 여러가지 변형이 있음!!!
//  4-1. 브리지 패턴
//   -> 구현부에서 추상층을 분리하여 각자 독립적으로 변형이 가능하고 확장이 가능하도록 함
//      즉, 기능과 구현에 대해 두 개를 별도의 클래스로 구현함
//      https://lktprogrammer.tistory.com/35 사진 참고
//      [기능부의 최상위 클래스] -> [추상층의 최상위 인터페이스]
//          ^       ^                   ^        ^
//          |       |                   |        |
//     [하위클래스1] [하위클래스2]     [하위 클래스3] [하위클래스4]
// public class Bird extends Animal
//{
//    public Bird(Hunting_Handler hunting) {
//        super(hunting);
//    }
//    public void hunt()
//    {
//        System.out.println("새의 사냥방식");
//        Find_Quarry();
//        Detected_Quarry();
//        attack();
//    }
//}
//        Animal tiger = new Tiger(new Hunting_Method2()); //이렇게 생성시에 다른 [하위클래스3 or 4]를 넣어서 만들 수 있음 ㅇㅇ
//        Animal bird = new Bird(new Hunting_Method1())

// *정적팩토리메소드 단점?
// - 1. 상속을 하려면 public protected생성자가 필요 -> 따라서 정적팩토리메소드만 제공하면 하위클래스 만들 수 없음
// - 2. 정적 팩토리 메소드는 프로그래머가 찾기 어려움 -> 생성자처럼 API 설명에 명확히 들어나지 않음 ㅇㅇ

// *정적팩토리명명방식
// - from : 매개변수 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메소드 ex) Date d = Date.from(instant);
// - of : 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메소드 ex) Set<Rank> = EnumSEt.of(JACK, QUEEN, KING);
// - valueOf : from과 of의 더 자세한 버전
// - instance 혹은 getInstance : (매개변수를 받는다면) 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스임을 보장하진 않음
// - create 혹은 newInstance : instance 혹은 getinstance와 같지만, 매번 새로운 인스턴스를 반환함을 보장 ㅇㅇ
// - getType : getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 팩토리 메소드를 정의할 때 씀, TYpe은 팩토리 메소드가 반환할 객체의 타입
//             FileStore fs = Files.getFileStore(path);
// - newType : newInstance와 같으나, "
// - type : getType과 newType의 간결한 버전

// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

// *생성자에 매개변수가 많다면 빌더를 고려하라
// - 위에서 말한 '정적 팩토리 메소드'와 '생성자'에는 똑같은 제약이 있음
//   선택적 매새변수가 많을때 적절히 대응하기 어렵다는 점
//    ex) 생성자는 일일이 시그니처에 따라 만들어야되고, 정적 팩토리 메소드의 경우는 매개변수 늘어나면 늘어날 수록 기억하기어렵고 매개변수 잘못값넣으면 엉뚱한 동작함
// - 두번째 대안 : 자바빈즈패턴(JavaBeans pattern)
//   -> 매개변수가 없는 생성자로 객체를 만든 후 세터(setter)메소드를 호출해 원하는 매개변수의 값을 설정하는 것
//   그 평소에 하는거 ㅇㅇ
    // Test test = new Test();
    // test.setXX(test2);

// 근데 이것도 set 다 할때까지 안정성 등이 없는 단점이 있어서 나온것이
// - 점층적 생성자 패턴의 안정성 + 자바 빈즈 패턴의 가독성을 겸비한 '빌더 패턴'임!

// *빌더 패턴
// - 필요한 객체를 직접 만드는 대신, 필수 매개변수만으로 생성자(or 정적 팩토리)를 호출해
//   빌더 객체를 얻음
//   빌더는 '생성할 클래스 안에 정적 멤버 클래스로 만들어 둠'
// https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EB%B9%8C%EB%8D%94Builder-%ED%8C%A8%ED%84%B4-%EB%81%9D%ED%8C%90%EC%99%95-%EC%A0%95%EB%A6%AC 참고

// 필수매개변수, 선택매개변수를
//  public class TEST {
// -> public static class Builder {
//    // 필수 매개변수
//    private final int test;
//    // 선택 매개변수
//    private final int test2 = 0;
//
//    public Builder(int test) {
//      this.test = test;
//      }
//
//    public Builder test2(int val) {
//      test2 =  cal
//      return this;
//      }
//    }
//
//    public TEST build() {
//      return new TEST(this);
//    }
//   }
//
//  private TEST(Builder builder) {
//      test = builder.test;
//      test2 = builder.test2;
//    }
// }
// - 빌더 네이밍
    // - 그냥 필드명 -> .name().~ [이게 추천됨]
    // - set붙여서 -> .setName().~
    // - with붙여서 -> .withName().~
// [결론] 생성자나 정적팩터리가 처리해야할 매개변수가 많다면 '빌더 패턴'을 선택하는게 나음+



// *직렬화 역직렬화
    // - 객체를 직렬화 : 객체 상태를 -> 바이트 스트림으로 바꿔서 '바이트 스트림을 객체의 복사본'으로 되돌릴 수 있음을 의미
    // - 역직렬화 : 직렬화된 객체 형식을 객체의 사본으로 다시 바꾸는 프로세스
    // -> [제 3자와 데이터를 교환하는 대부분의 앱에서 필수적인 부분]
    // [직렬화는 응용프로그램에서 쓰는 데이터를 '네트워크를 통해 전송하거나 DB 또는 파일에 저장가능한 형식으로 바꾸는 프로세스'
    // [역질렬화는 외부 소스에서 데이터를 읽고 이를 런타임 객체로 바꾸는 반대 프로세스]

// *싱글톤을 만드는 방식3가지중
// - 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법임!
//public enum Elvis {
//    INSTANCE;
//
//    public void leaveTheBuliding() {
//			...
//    }
//}

// *팩토리 메소드 패턴

    // - Supplier<T> 인터페이스가 팩터리의 완벽한 예
    // https://bcp0109.tistory.com/367 참고
    // - 생성 패턴 중 하나로 '객체를 생성할 때 어떤 클래스의 인스턴스를 만들 지 서브 클래스에서 결정'하게 하는 것

// * 스택 클래스는 왜 메모리 누수에 취약한걸까?
    // - 스택이 자기 메모리를 직접 관리하기 때문
    // - elements 배열로 저장소 풀을 만들어 원소들을 관리함
    //   배열의 활성영역에 속한 원소들이 사용되고 비할성 영역은 쓰이지 않음
    //   (문제는 가비지 컬렉터는 이걸 알길이 없다는 것 -> 그래서 프로그래머가 비활성 객체가 더 이상 쓸모없다는 걸 알려야 함)
// * 캐시도 메모리 누수를 일으키는 주범임
    // - 객체 참조를 캐시에 넣고 나서 그 뒤로 한참을 그냥 나두면 메모리 누수가 됨
    // - 대비 : WeakHashMap을 사용해 캐시를 만듬 - 다 쓴 엔터리를 그 즉시 자동으로 제거됨(단 이 상황에만 유용함)
// * 리스너 or 콜백도 메모리 누수의 주범임
    // - 클라이언트가 콜백만 등록하고 명확히 해지하지 않는 경우
    //   콜백은 계속 쌓여감 -> 이럴 때 콜백을 '약한 참조'로 저장하면 CG가 즉시 수거해 감
    //   EX) WeakHashMap에 키로 저장하면 됨




// * finalizer, cleaner 사용을 피해라
    // - finalizer는 java9이후에 deprecated됫고 그 이유는
    //   finalizer와 cleaner(finalizer 대체로 나온 것)는 즉시 수행된다는 보장이 없기 때문(얼마나 신속히 수행할지는 GC알고리즘에 따라 달림)
    //   한편 cleaner는 자신을 수행할 스래드를 제어할 수 있따는 면에서 조금 나음
    //   ex) 데아터베이스 같은 공유 자원의 영구 락 해제를 맡긴다면 분산 시스템 전체가 서서히 멈춤
    // - finalizer 동작 중 발생한 예외는 무시됨

    // - 성능 문제도 있음 550ns가 걸리지만 try-with-resources 로 하면 12ns가 걸림 ㅇㅇ
    //   clenaer도 비슷함 ㅇㅇ

    // - +) finalizer 사용한 클래스는 finalizer 공격에 노출되어 심각한 보안 문제를 일으킴
    //      대비책은 final 클래스로 만드는 것 -> 하위 클래스를 만들 수 없으니 이 공격에서 안전함

    // - cleaner는 안정망 역할, 중요하지 않은 네이티브 자원 회수용
    //   이런 경우라도 불확실성과 성능 저하에 주의해야 함

// * try-finally 보다 -> try-with-resources를 사용해라
    // - InputStream, OutputStream, java.sql.Connection등은 close메소드로 호출해 직접 닫아줘야 함
    // - 이 구조를 사용하려면 해당 자원이 AutoCloseable 인터페이스를 구현해야 함
    //   (void를 반환하는 close메소드만 하나만 덩그러니 정의한 인터페이스)

    // - 실전에서는 프로그래머에게 보여줄 예외 하나만 보존되고 여러 개의 다른 예외가 숨겨질 수도 있음
    //   이것들은 '숨겨졌다(suppressed)라는 꼬리표를 달고 스택 추적 내역에 출력됨(ㅇㅎ)
    //  +) 자바7에서의 Throwable에 추가된 getSuppressed()로 가져올 수도 있음
    // - try-with-resources에서도 catch 절을 쓸 수 있음
    // [결론] 꼭 회수해야하는 자원을 다룰 땐 try-with-resources를 사용하자

}
