package com.ssg.diex1.example;

import org.springframework.stereotype.Component;

@Component
public class EveningGreet implements Greet {//Greet 구현 클래스


    @Override
    public void gretting() {
        System.out.println("편안한 저녁시간 되세요.");
    }
}
