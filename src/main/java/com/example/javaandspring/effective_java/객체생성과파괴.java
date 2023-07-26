package com.example.javaandspring.effective_java;

public class 객체생성과파괴 {
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

    // 40페이지부터 다시 ! 
    
    // 118까지ㄱㄱ
}
