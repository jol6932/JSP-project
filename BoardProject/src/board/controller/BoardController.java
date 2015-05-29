package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.*;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(contextPath.length());
		
		
		/*System.out.println(contextPath);
		System.out.println(uri);
		System.out.println("command = "+command);*/
		if(command.equals("/writeForm.board")){//글쓰기 폼
			Action action = new BoardWriteFormAction();
			action.execute(request, response);//동적 바인딩:부모형 객체로 선언 되어 있지만 알맞는 메소드를 찾아서 알아서 실행시킴
		}
		
		if(command.equals("/write.board")){//글쓰기
			System.out.println("write");
			Action action = new BoardWriteAction();
			action.execute(request, response);
			
		}
		
		if(command.equals("/list.board")){//리스트
			System.out.println("list");
			Action action = new BoardListAction();
			action.execute(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request,response);
	}

}
