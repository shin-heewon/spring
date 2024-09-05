package com.ssg.springex.todo.service;

import com.ssg.springex.todo.dto.TodoDTO;
import com.sun.tools.javac.comp.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {

    INSTANCE; // 이 통로를 이용해야지만 서비스를 이용할 수 있도록 함

    public void register(TodoDTO dto){//하나의 글을 등록하는 기능
        System.out.println("DEBUG................"+dto);
    }

    public List<TodoDTO> getList(){//등록된 글 목록 반환하는 기능

        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i->{//10개의 TodoDTO(글)을 만들어서 리스트 객체로 반환

            TodoDTO dto = new TodoDTO();
            dto.setTno((long)i);
            dto.setTitle("Todo..."+i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());//list로 변환해 줌

        return todoDTOS;
    }


    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }



}
