package com.ssg.springex.todo;

import com.ssg.springex.todo.dto.TodoDTO;
import com.ssg.springex.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("/todo/list.........call");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        req.setAttribute("dtolist", dtoList);


        req.getRequestDispatcher("/todo/list.jsp").forward(req, resp); // list.jsp로 이동할 때 req, resp 들고 이동해라~
    }



}
