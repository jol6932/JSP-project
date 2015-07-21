package board.dao;

import board.db.sqlconfig.IBatisDBConnector;

import com.ibatis.sqlmap.client.SqlMapClient;

public class CommonDao {
	private SqlMapClient myDB;
	
	public void SetDB(){
		myDB = IBatisDBConnector.getSqlMapInstance();
		
		//아이바티스커넥터로부터 인스턴스를 가져오는 메서드 구현
	}
	protected SqlMapClient GetDB(){
		return myDB;
	}
}