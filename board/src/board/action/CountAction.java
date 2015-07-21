package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.beans.Board;
import board.controller.CommandAction;
import board.dao.boardDao;

public class CountAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		Board article = boardDao.getInstance().getArticle(idx);
		int count=article.getCt();
		count++;
		article.setCt(count);
		boardDao.getInstance().setArticleCount(article);
		
		request.setAttribute("article",article);
		return "content.jsp";
	}

}
