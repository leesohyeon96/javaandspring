package com.example.javaandspring.clean_code;

public class Abstract {
    // 객체와 자료 구조
    // - 자료 추상화
}

class AbstractTest {
    public double x;
    public double y;
} // 이거보다

interface Point {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
} // 이게 훨씬 좋다 (double x, double y)를 노출하는 것보단
// (private을 써도 각 값마다 조회(get)함수와 설정(set)함수를 제공하면 구현을 외부로 노출하는 셈)
// 구현을 감추려면 결국 '추상화'가 필요함!

//구체적인 Vehicle 클래스
interface Vehicle1 { // << 이것처럼 인터페이스를 작성한다고 무조건 추상화가 아니다
    double getFuelTankCapacityInGallons(); // 가솔린의 연료 수용량 -> 변수값 읽어 반환함
    double getGallonsOfGasoline(); // 가솔린의 gallons -> 변수 값 읽어 반환함
}

//추상적인 Vehicle 클래스
interface Vehicle2 { // 얘처럼 자료를 세세히 공개하기 보다는 '추상적인 개념'으로 표현하는 것이 좋다
                    // 사용자가 '구현을 모른채 자료의 핵심을 조작'할 수 있어야 함
    double getPercentFuelRemaining(); // 연료남은거 (%)로 반환 -> 정보가 어디서 오는지 전혀 드러나지 않음
    // 이런식으로 인터페이스 내에서도 너무 많은 자료를 노출하는 메소드보다
    // '추상적인 메소드'를 만들 필요가 있음!! (ㅇㅋ)
}

    // - 위는 '객체'와 '자료 구조' 사이의 차이를 보여줌
        // - 객체 : '추상화' 뒤로 자료를 숨긴 채 '자료를 다루는 함수'만 공개하고 (지향 필요!)
        // - 자료구조 : 자료를 그대로 공개! , 별다른 함수는 제공하지 않음


    // - 디미터 법칙(= 휴리스틱)
        // - 모듈은 자신이 조작하는 객체의 속사정을 몰라야 함
        //   (즉, 객체는 조회 함수로 내부 구조를 공개하면 안 됨!)
        // - 구체적으로 "클래스 C의 메소드 f는 다음과 같은 객체의 메소드만 호출해야 함"
        //   ex) 클래스 C, f가 생성한 객체, f 인수로 넘어온 객체, C 인스턴스 변수에 저장된 객체

        // - 기차충돌
            // - final String outputDir = ctxt.getOptions().getScratchDir().getAbsoultePath();
            //   여러 객차가 한줄로 이루어진 기차처럼 보이기 때문 -> 조잡해보여서 피하는게 좋음!
            // - ex) Options opts = ctxt.getOptions();
            //       File scratchDir = opts.getScratchDir();
            //       final String outputDir = scratchDir.getAbsoloutePath();
            // 이렇게 나누는게 좋음(ㅇㅋ)
            // - 위의 코드 예제가 디미터 법칙을 위반하는가?
                // - 객체라면 내부구조를 숨겨야 해서 당연히 위반이지만
                // - 자료구조라면 당연히 내부 구조를 노출하므로 디미터 법칙이 적용되지 않음

    // - 자료구조체
        // - 흔히 DTO(data transfer Object)로 불리기도 함(ㅇㅎ!)
        // - getter, setter ㅇㅋㅇㅋ(노출하잖아)

    // - 활성 레코드
        // - 활성 레코드는 'DTO의 특수한 형태' -> 즉, '자료 구조'로 취급함

// [결론]
    // - 어떤 시스템을 구현할 때 '갹체', '자료 구조' 중에 더 적합한 것을 사용하면 된다!












