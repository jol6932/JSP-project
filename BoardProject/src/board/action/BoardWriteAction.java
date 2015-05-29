package board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("textarea");
		
		Board board = new Board();
		
		board.setName(name);
		board.setTitle(subject);
		board.setContent(content);
		BoardDAO dao = new BoardDAO();
		
		int result = dao.insertBoard(board);
		
		if(result!=0){
			String url = "list.board";
			response.sendRedirect(url);//컨트롤러를 통해서 list로 가야함
		}

	}

}
