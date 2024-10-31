package com.ssg.springex.mapper;

import org.apache.ibatis.annotations.Select;
//TimeMapper는 데이터베이스의 현재 시각을 문자열로 처리하도록 구성하도록 구성
public interface TimeMapper { // 매퍼 인터페이스

    @Select("select now()")// 세미콜론 찍지 않음!!
    String getTIme();


}
