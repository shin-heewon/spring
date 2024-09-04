package com.ssg.springex.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="inputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet { // Http 상에서 처리하는 request, response 를 처리할 수 있는 기능을 상속받아 쓸 수 있게 됨


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        System.out.println("InputController...doGet.. processing");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/calc/input.jsp");//중간 경유지
        dispatcher.forward(req, resp);
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
}
