package com.ssg.diex1.example;

import org.springframework.stereotype.Component;

@Component
public class MornigGreet implements Greet {//Greet 구현 클래스


    @Override
    public void gretting() {
        System.out.println("좋은 아침입니다.");
    }
}
