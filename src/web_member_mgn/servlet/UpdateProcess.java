package web_member_mgn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_member_mgn.dto.Member;
import web_member_mgn.service.MemberService;

@WebServlet("/updateProcess")
public class UpdateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = getMember(request);
		service.modifyMember(member);
		request.getRequestDispatcher("memberList").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private Member getMember(HttpServletRequest request) throws ServletException, IOException {
		Member member = null;
		try {
			String id = request.getParameter("id").trim();
			String name = request.getParameter("name").trim();
			int age = Integer.parseInt(request.getParameter("age").trim());
			String gender = request.getParameter("gender").trim();
			String email = request.getParameter("email").trim();
			member = new Member(id, name, age, gender, email);
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return member;
		
	}

}
