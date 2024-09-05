package com.ssg.todo;

import com.ssg.springex.todo.dao.TodoDAO;
import com.ssg.springex.todo.domain.TodoVO;
import com.ssg.springex.todo.dto.TodoDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    TodoDAO dao = new TodoDAO();

    @Test
    public void testInsert() throws Exception{
        TodoVO vo = TodoVO.builder()
                .title("Sample Title.....")
                .dueDate(LocalDate.of(2024,9,5))
                .build();

        dao.insert(vo);
    }


    @Test
    public void testList() throws Exception{
        List<TodoVO> list = dao.selectAllList();

        list.forEach(vo-> System.out.println(vo));
    }


    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;
        TodoVO vo = dao.selectOne(tno);
        System.out.println(vo);
    }


    @Test
    public void testUpdateOne() throws Exception{
        TodoVO voTest = TodoVO.builder().tno(1l).title("UpdateTest.....").dueDate(LocalDate.of(2024,9,5)).finished(true).build();
        dao.updateOne(voTest);
    }

    @Test
    public void testDeleteOne() throws Exception{
        long tno = 4l;
        dao.deleteOne(tno);
    }
}
