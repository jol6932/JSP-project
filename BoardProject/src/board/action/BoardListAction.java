package board.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("BoardListAction");
		
		BoardDAO dao = new BoardDAO();
		
		List<Board> list = dao.selectAllBoards();
		
		request.setAttribute("list", list);//request 영역에 list 담음
		//데이터 영역 참조하는 부분
		
		String url = "./board/list.jsp"; //보여지는 부분으로 가는부분
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
