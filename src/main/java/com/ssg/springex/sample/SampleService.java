package com.ssg.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString

@RequiredArgsConstructor //생성자 주입 방식으로 변경

public class SampleService {

//    @Autowired
//    private SampleDAO sampleDAO;

    @Qualifier("basic")
    private final SampleDAO sampleDAO; // 아래 20~22번 코드와 같은 의미이다.

//SampleService(SampleDAO sampleDAO){
//    this.sampleDAO = sampleDAO;
//}

}
