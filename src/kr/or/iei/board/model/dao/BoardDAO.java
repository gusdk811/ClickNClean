package kr.or.iei.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.board.model.vo.Board;
import kr.or.iei.common.JDBCTemplate;

public class BoardDAO {

	public ArrayList<Board> memberNotice(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;	
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order BY BOARDNO DESC) AS NUM, BOARDNO,SUBJECT,REGDATE,BOARDTYPE FROM BOARD WHERE BOARDTYPE='user') WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("boardNo"));
				board.setSubject(rset.getString("subject"));
				board.setRegDate(rset.getDate("regDate"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
 		return list;
	}

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Board> companyNotice(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;	
		
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order BY BOARDNO DESC) AS NUM, BOARDNO,SUBJECT,REGDATE,BOARDTYPE FROM BOARD WHERE BOARDTYPE='com') WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("boardNo"));
				board.setSubject(rset.getString("subject"));
				board.setRegDate(rset.getDate("regDate"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
 		return list;
	}

	public Board boardView(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Board board = null;
		
		String query = "SELECT BOARD.SUBJECT,BOARD.REGDATE,BOARD.WRITER,BOARD.CONTENT FROM BOARD" + 
				       "LEFT JOIN MEMBER ON(BOARD.WRITER=MEMBER.USERID)" + 
				       "WHERE BOARDNO=? AND BOARD.END_YN='N'";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
                board = new Board();
				
				board.setSubject(rset.getString("subject"));
				board.setContent(rset.getString("content"));
				board.setWriter(rset.getString("writer"));
				board.setRegDate(rset.getDate("regDate"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return board;
	}

	public ArrayList<Board> selectSearchPostList(Connection conn, int currentPage, int recordCountPerPage,
			String keyword, String type) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;		
		
        String query ="";
		
		switch(type)
		{
		case "subject" : 
			query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(order BY BOARDNO DESC) AS NUM, "
					+ "BOARDNO,SUBJECT,REGDATE,BOARDTYPE FROM BOARD)"
					+ "WHERE BOARD.END_YN='N' AND (SUBJECT like ?)"
					+ ")"
					+ "WHERE NUM BETWEEN ? AND ?";;
			
				break;	
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			
			if(type.equals("subject"))
			{
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next())
			{
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("boardNo"));
				board.setSubject(rset.getString("subject"));
				board.setContent(rset.getString("content"));
				board.setWriter(rset.getString("writer"));
				board.setRegDate(rset.getDate("regDate"));
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;		
	}

	public String getSearchPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage,
			String keyword, String type) {
        int recordTotalCount = totalSearchCount(conn,keyword,type); //전체 글 개수
		

		
		int pageTotalCount = 0; // 전체 페이지 개수
		
		if((recordTotalCount % recordCountPerPage) > 0)
		{
			pageTotalCount = (recordTotalCount/recordCountPerPage) + 1;
		}else
		{
			pageTotalCount = recordTotalCount/recordCountPerPage;
		}
		
		
		int startNavi = (((currentPage-1)/naviCountPerPage)*naviCountPerPage)+1;
		int endNavi = startNavi + (naviCountPerPage-1);
		
		if(endNavi > pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1)
		{
			sb.append("<a href='/board/boardPostSearch.do?currentPage=" + (startNavi - 1) +"&keyword="+keyword+"&type="+type+"'>< Prev </a> ");
		}
		
		for(int i = startNavi; i<=endNavi;i++)
		{
			if(i==currentPage)
			{
				sb.append("<a href='/board/boardPostSearch.do?currentPage="+i+"&keyword="+keyword+"&type="+type+"'><B style='font-size:1.1em'>"+i+"</B></a> ");
			}else
			{
				sb.append("<a href='/board/boardPostSearch.do?currentPage="+i+"&keyword="+keyword+"&type="+type+"'>"+i+"</a> ");
			}
		}
		
		if(endNavi!=pageTotalCount)
		{
			sb.append("<a href='/board/boardPostSearch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"&type="+type+"'>next ></a> ");
		}
		
		return sb.toString();
	}
	
private int totalSearchCount(Connection conn, String keyword, String type) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
        String query ="";
		
		switch(type)
		{
		case "subject" : 
				query = "SELECT COUNT(*) as count FROM BOARD " + 
						"    LEFT JOIN MEMBER ON (BOARD.Writer = MEMBER.USERID) " + 
						"WHERE BOARD.END_YN='N' AND SUBJECT like ?";
				break;
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			if(type.equals("all"))
			{
				pstmt.setString(1,"%"+keyword+"%");
			}
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				count = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		
		}
		
		return count;		

	}

}
