package board.dao;

import java.sql.*;
import java.util.*;





import board.dto.Board;



public class BoardDAO {
	private Connection con;
	private PreparedStatement psmt;
	public BoardDAO(){
		//1.JDBC 드라이버 로드
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //JSP는 예외처리 안해도 자동으로 해주지만 서블릿은 수동으로 해줘야함
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jspuserc","jsp1234");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//try,catch 예외 여부와 상관없이 무조건 실행
		
		}
	    
		
	}
		
	
	
	public int insertBoard(Board board){//글쓰기
		String sql = "insert into board values(board_seq.nextval,?,?,?,default,default,'file')";
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1, board.getName());
			psmt.setString(2, board.getTitle());
			psmt.setString(3, board.getContent());
			
			int result = psmt.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	public List<Board> selectAllBoards(){
		String sql = "select * from board order by num desc";
		
		List<Board> list = new ArrayList<Board>();
		try {
			psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				
				board.setNum(rs.getInt("num"));;
				board.setName(rs.getString("name"));
				board.setTitle(rs.getString("title"));
				board.setWdate(rs.getDate("wdate"));
				board.setHits(rs.getInt("hits"));
				
				list.add(board);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
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
