package board.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.beans.Board;
import board.controller.CommandAction;
import board.dao.boardDao;

public class ListAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		int page = 0;
		if(request.getParameter("page")!=null){//넘어온 파라미터가 있다면
			
			page = Integer.parseInt(request.getParameter("page"));
		}//파라미터를 int형으로 형변환한뒤 변수에 대입
		ArrayList<Board> articleList = boardDao.getInstance().getArticleList(page);
		//Dao에 삽입
		request.setAttribute("articleList", articleList);//리스트를 뷰에 포워드
		request.setAttribute("page", page);

		return "list.jsp";
	}
}


