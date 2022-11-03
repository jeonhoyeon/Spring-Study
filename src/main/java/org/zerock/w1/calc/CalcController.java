package org.zerock.w1.calc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//urlPatterns 속성값이 /calc/makeResult로 지정되어 있으므로 브라우저에서 <form>태그의 submit 경로를 수정할 필요가 있다.
@WebServlet(name="calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getParameter() 메소드를 이용해 쿼리 스트링으로 전달되는 num1, num2 파라미터 처리
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf("num1: %s", num1);
        System.out.printf("num2: %s", num2);

        resp.sendRedirect("/index");
    }
}
