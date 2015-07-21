package board.dao;

import java.sql.*;
import java.util.*;

import board.beans.*;


public class boardDao extends CommonDao{

	public static boardDao getInstance(){
		boardDao _instance = new boardDao();
		_instance.SetDB();
		return _instance;
	}

	@SuppressWarnings("unchecked")
	
	public ArrayList<Board> getArticleList(int page) throws SQLException{
	
		ArrayList<Board> articleList = new ArrayList<Board>();
		articleList = (ArrayList<Board>)GetDB().queryForList("getArticleList", null,page,10);
												//쿼리를 식별할 수 있는 id/쿼리에 넘기는 파라미터/가져올 페이지번호/가져올 데이터 로우의 갯수
		

		return articleList;
	}
	public void setArticleCount(Board article) throws SQLException{
		GetDB().update("setArticleCount", article);
	}
	public Board getArticle(int idx) throws SQLException{
		return (Board)GetDB().queryForObject("getArticle", idx);
	}
	public void setArticle(Board article) throws SQLException{
		GetDB().insert("insertArticle", article);
	}
}
