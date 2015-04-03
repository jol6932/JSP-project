package exam.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");//이걸해줘야 한글도 되고 br태그 혼용도 가능
		PrintWriter out = response.getWriter();
		String name = request.getParameter("A");//jsp에 input태그안에 name="여기"랑 이름이 같아야 함
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String color = request.getParameter("mycolor");
		String mail = request.getParameter("mail");
		String date = request.getParameter("date");
		String select = request.getParameter("select");
		String txt = request.getParameter("text");
		
		String[] hb = request.getParameterValues("hb");//체크박스는 몇개가 선택될지 모르니까 배열로 받아내야함
		out.println(name+"<br>");
		out.println(passwd+"<br>");
		out.println(gender+"<br>");
		out.println("<font color='"+color+"'>"+color+"</font><br>");
		out.println(mail+"<br>");
		out.println(date+"<br>");
		out.println(select+"<br>");
		out.println(txt+"<br>");
		
		if(hb == null)
			out.println("선택안했음요"+"<br>");
		else{
			out.print(hb.length + "개 선택"+"<br>");
			for(int i=0;i<hb.length;i++)
			{
				out.print(hb[i]+"<br>");
			}
			out.close();//out이 끝나면 꺼줘야함
		}
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
