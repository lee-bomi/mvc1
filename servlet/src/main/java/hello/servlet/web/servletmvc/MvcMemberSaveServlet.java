package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 파라미터 받고
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        //2. 서비스로직 호출하고
        Member member = new Member(username, age);
        memberRepository.save(member);

        //3. Model에 데이터를 보관해서
        request.setAttribute("member", member);

        //4. view로 던져서 마무리
        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);  //컨트롤러->뷰로 이동
        dispatcher.forward(request, response);  //서버내부에서 호출
    }
}
