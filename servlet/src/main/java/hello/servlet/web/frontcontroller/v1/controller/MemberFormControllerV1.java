package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MemberFormControllerV1 implements ControllerV1 {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";    //WAS에서 컨트롤러를 통해야만 WEB-INF하위의 파일을 실행가능, 그냥 JSP파일을 실행하려면 WEB-INF가 아닌파일에 둬야함
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);//컨트롤러에서 뷰로 이동할때 사용메서드
        dispatcher.forward(request, response);   //서블릿에서 jsp호출가능(메서드처럼 서버내부에서 호출하여 다른서블릿이나 jsp를 실행)
    }
}
