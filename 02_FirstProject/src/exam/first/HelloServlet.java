package exam.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")			//URL mapping
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//변수들이 서버로 넘어갈때 인코딩방식을 바꿔서 한글이 나오도록 설정
		//클라이언트에서 변수를 받아서 서블릿에서 인코딩할때 UTF-8로 하겠다는 의미
		response.setContentType("text/html; charset=UTF-8");
		//서블릿에서 클라이언트로 내려 보낼때 html타입,UTF-8 로 인코딩해서 내려보낸다는 의미"text/html (대분류/소분류")
		
		PrintWriter out = response.getWriter();//out 이랑 out.print 에 out이랑 같음
		
		String name = request.getParameter("name"); //request에 파라미터로 넘어오는 애들 클라이언트에서 넘어오는 값 받는 소스
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");//시험에 나옴
		//out.print("<html>");
		out.print("이름 : "+name+"<br>");//
		out.print("아이디 : "+id+"<br>");
		out.print("비밀번호 : "+pwd+"<br>");
		//out.print("</html>");
		out.print("hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");//변수들이 서버로 넘어갈때 인코딩방식을 바꿔서 한글이 나오도록 설정
		response.setContentType("text/html; charset=UTF-8");//출력될때 한글이 안나오는거랑 html태그가 적용안되는걸 설정해줌
		PrintWriter out = response.getWriter();//out 이랑 out.print 에 out이랑 같음
		String name = request.getParameter("name"); //request에 파라미터로 넘어오는 애들
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");//시험에 나옴
		
		//out.print("<html>");
		out.print("이름 : "+name+"<br>");//
		out.print("아이디 : "+id+"<br>");
		out.print("비밀번호 : "+pwd+"<br>");
		//out.print("</html>");
		out.println("Bonjour");
	}

}
