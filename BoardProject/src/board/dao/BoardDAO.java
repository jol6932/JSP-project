package board.dao;

import java.util.List;

import board.dto.Board;



public class BoardDAO {
	public BoardDAO(){
		
	}
	
	public int insertBoard(Board board){
		return 0;
	}
	public List<Board> selectAllBoards(){
		return null;
	}
	public Board selectOnBoardByNum(int num)
	{
		return null;
	}
	public void updateHits(int num){
		
	}
	public int updateBoard(Board board){
		return 0;
	}
	public int deletdBoard(int num){
		return num;
	}

}
