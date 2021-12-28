package kr.or.iei.board.model.vo;

import java.sql.Date;

public class Board {

	private int boardNo;
	private String writer;
	private String subject;
	private String content;
	private Date regDate;
	private String boardType;
	private char end_YN;
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", writer=" + writer + ", subject=" + subject + ", content=" + content
				+ ", regDate=" + regDate + ", boardType=" + boardType + ", end_YN=" + end_YN + "]";
	}

	public Board(int boardNo, String writer, String subject, String content, Date regDate, String boardType,
			char end_YN) {
		super();
		this.boardNo = boardNo;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regDate = regDate;
		this.boardType = boardType;
		this.end_YN = end_YN;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public char getEnd_YN() {
		return end_YN;
	}
	public void setEnd_YN(char end_YN) {
		this.end_YN = end_YN;
	}
	
	
	
}
