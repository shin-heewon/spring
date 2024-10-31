package com.ssg.springex.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary //SampleDAO를 구현하는 객체 중 어는 것을 실행할 지 우선 순위 부여
@Repository
@Qualifier("basic")
public class SampleDAOImpl implements SampleDAO{ //SampleDAOImpl 에는 @Repository를 이용해서 해당 클래스의 인스턴스(객체)를 스프링의 빈(객체)으로 처리되도록 한다.

}
