package board.beans;
/*
 Entity beans
	 -db에 저장된 데이터를 객체로 표현하기이한 ejb컴포넌트
	 -db의 내용과 일치
	 -entity beans의 한 객채는 db테이블의 하나의 row와 mapping
	 -db의 하나의 행은 여러개의 열을 가지고 있는데 각각의 attribute는 bean객체의 멤버필드에 값이 저장됨
 
 */

public class Board {
	private int idx;
	private String title;
	private String writer;
	private String regdate;
	private int ct;
	private String content;
	String filename;
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilename() {
		return filename;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCt() {
		return ct;
	}
	public void setCt(int ct) {
		this.ct = ct;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
