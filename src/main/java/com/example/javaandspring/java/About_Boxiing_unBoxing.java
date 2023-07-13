package com.example.javaandspring.java;

public class About_Boxiing_unBoxing {
    // 1. 박싱
        // - value types > reference types 으로 변환
    // 2. 언박싱
        // - 박싱했던 값을 원상태로 돌리는 것

    // - 박싱/언박싱을 사용해야하는 이유?
        // - int[] array = new int[2];
        //   array[0] = 1;
        //   array[1] = "hello"; -> 불가능
        //   이때, Object를 배열타입으로 지정하면 다양한 타입을 넣을 수 있음
        //   Object [] array = new object[2];
        //   array[0] = 1; array[1] = "hello";
        //   이때, 내부적으로 데이터가 배열에 들어갈 때 박싱(boxing)이 일어남
        //   그리고 출력 시 다시 언박싱(unboxing)함 -> 편리함 ㅇㅇ
        //   but, 편리하지만 메모리상 비효울적임[boxing, unboxing 할때 메모리 낭비]
            // - [boxing] value types > reference types이 될 때 stack에 있는 값을 복사해서 heap에 할당시킴
            // - [unboxing] 다시 heap에서 stack으로 가져오는 작업을 하며 heap에 garbage가 쌓이게 됨
        //   and, boxing 시 20배정도 많은 시간 소요
        //        unboxing 시 4배정도 많은 시간 소요

    // -> object 장점도 가져가며 성능적 이슈를 해결하기 위해 나온 것이 "Generic"임
}
