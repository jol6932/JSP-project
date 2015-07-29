package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.beans.Board;
import board.controller.CommandAction;
import board.dao.boardDao;

public class InsertAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");

		HttpSession session = request.getSession();
		MultipartRequest multi  = null;
		int sizeLimit = 10*1024;//10메가바이트
		
		String savePath = request.getRealPath("/upload");
		
		multi = new MultipartRequest(request,savePath,sizeLimit,"UTF-8",new DefaultFileRenamePolicy());
		
		String filename = multi.getFilesystemName("filename");
		String title = multi.getParameter("title");
		String writer = (String)session.getAttribute("id");
		String regdate = multi.getParameter("regdate");
		String content = multi.getParameter("content");

		Board article = new Board();
		article.setTitle(title);
		article.setWriter(writer);
		article.setRegdate(regdate);
		article.setContent(content);
		article.setFilename(filename);
		
		boardDao.getInstance().setArticle(article);
		return "insert.jsp";
	}

}
