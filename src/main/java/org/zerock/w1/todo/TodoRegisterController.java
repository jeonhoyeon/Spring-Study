package org.zerock.w1.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력 화면을 볼 수 있도록 구성");

        //GET방식으로 호출되는 경우 등록 화면을 보는 구조이므로 requestDispatcher를 이용해 JSP를 보도록 작성
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동 ");

        //브라우저가 호출해야 하는 주소
        //브라우저를 아예 다른 주소로 이동시켜 사용자가 반복적인 POST 요청을 보내는 것을 막을 수 있음
        resp.sendRedirect("/todo/list");
    }
}
