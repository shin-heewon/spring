package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
class TodoServiceTest {
    private TodoService todoService;
    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }


    @Test
    void register() throws Exception{
        TodoDTO todoDTO = TodoDTO.builder().
        title("JDBC Test register").dueDate(LocalDate.now()).build();

        log.info(todoDTO);//테스트 코드의 Log4j2 설정 확인 할 수 있다.
        todoService.register(todoDTO);
    }
}