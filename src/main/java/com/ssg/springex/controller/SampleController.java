package com.ssg.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {
    @GetMapping("/hello")//어노테이션 이용해서 메소드 이름에 상관없이 get 메소드임을 표시!
    public void hello(){
        log.info("hello~~~~~~~~~spring web  MVC~~~~~~~");
    }

    @GetMapping("ex1")
    public void ex1(String name, int age){
        log.info("ex1..........");
        log.info("ex1에서 처리한 이름 "+name);
        log.info("ex1에서 처리한 나이 "+age);
    }

    @GetMapping("ex2")
    public void ex2(@RequestParam(name="name", defaultValue = "AAA")String name, @RequestParam(name="age", defaultValue = "20") int age){
        log.info("ex2..........");
        log.info("ex2에서 처리한 이름 "+name);
        log.info("ex2에서 처리한 나이 "+age);

    }


    @GetMapping("ex3")
    public void ex3(LocalDate dueDate){
        log.info("ex3..........");
        log.info("ex3에서 처리한 dueDate "+dueDate);
    }


}
