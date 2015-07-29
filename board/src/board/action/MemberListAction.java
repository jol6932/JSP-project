package board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.MemberDao;
import board.member.Member;

/**
 * Servlet implementation class MemberListAction
 */
@WebServlet("/MemberList")
public class MemberListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		MemberDao dao = new MemberDao();
		int viewpage = Integer.parseInt(request.getParameter("apage"));
		
		
		int startnum = ((viewpage-1)*5)+1;
		int endnum = viewpage*5;
		
		
		List<Member> list = dao.viewMembers(startnum,endnum);
		
		request.setAttribute("list", list);
		

		String url = "memberlist.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		
		dis.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
