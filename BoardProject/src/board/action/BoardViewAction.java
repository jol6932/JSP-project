package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		
		BoardDAO dao = new BoardDAO();
		
		Board board = dao.selectOnBoardByNum(Integer.parseInt(num));//int형을 String으로 가지고 왔기 때문에 형변환
		//selectonboardbynum 에서 리턴해준 값을 board로 받아줌
		
		dao.updateHits(Integer.parseInt(num));
		
		request.setAttribute("board", board);
		String url = "./board/view.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);//해당 페이지로 이동
		dispatcher.forward(request, response);

	}

}
