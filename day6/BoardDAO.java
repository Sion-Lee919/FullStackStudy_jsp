package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	public void insertBoard(BoardDTO dto) {
		//String list="";
		Connection con = null;
		try {
		Context context = new InitialContext();
		Context env = (Context)context.lookup("java:/comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");
		con = ds.getConnection();
			String a = "select max(seq)+1 from board";
			PreparedStatement max1 = con.prepareStatement(a);
			ResultSet rs = max1.executeQuery();
			int max=0;
			if(rs.next()) {
				if(rs.getInt(1) == 0) {
					max=1;}
				else {
				max=rs.getInt(1);}	
			}
			String insertSQL = "insert into board VALUES (?, ?,?,?,?,?, sysdate)";
			PreparedStatement pt = con.prepareStatement(insertSQL);
			pt.setInt(1,max);
			pt.setString(2,dto.getTitle());
			pt.setString(3,dto.getContents());
			pt.setString(4,dto.getWriter());
			pt.setInt(5,dto.getPw());
			pt.setInt(6,dto.getViewcount());
			pt.executeUpdate();
			
			
		con.close(); 
		}
		catch(NamingException e) {
			System.out.println("context.xml 데이터베이스설정 미작성");}
		catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
			if(!con.isClosed()) {
				con.close();
				System.out.println("finally - db연걸 해제 성공");
				}
			}catch(Exception e) {}
		}
		//return list;
	}
	
	
	public int getTotalBoardCount() {
		int cm=0;
		Connection con = null;
		try {
		Context context = new InitialContext();
		Context env = (Context)context.lookup("java:/comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");
		con = ds.getConnection();
	
		String selectSQL = "select count(*) cm from board";
		PreparedStatement pt1 = con.prepareStatement(selectSQL);
	 	ResultSet rs = pt1.executeQuery();
	 	
	 	if(rs.next()) {
	 		cm= rs.getInt("cm");
	 		
	 		}
		con.close(); 
		}
		catch(NamingException e) {
			System.out.println("context.xml 데이터베이스설정 미작성");}
		catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
			if(!con.isClosed()) {
				con.close();
				System.out.println("finally - db연걸 해제 성공");
				}
			}catch(Exception e) {}
		}
		return cm;
	}
	
	
	public ArrayList<BoardDTO> getBoardList(int page, int count) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		Connection con = null;
		try {
			Context context = new InitialContext();
			Context env = (Context)context.lookup("java:/comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/mydb");
			con = ds.getConnection();
		
		String selectSQL = 
				"select * "
				+"from (select rownum r, imsi.* "
				+"from (select * from board order by writingtime desc) imsi "
				+") "
				+"where r between ? and ?";
		int start = (page-1)*count + 1;
		int end = page * count;

		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1,  start);
		pt2.setInt(2,  end);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNumber(rs.getInt("seq"));
			dto.setTitle (rs.getString("title"));
			//dto.setContents(rs.getString("contents"));
			dto.setWriter(rs.getString("writer"));
			dto.setViewcount(rs.getInt("viewcount"));
			list.add(dto);
		}
		con.close();
		}
		catch(NamingException e) {
			System.out.println("context.xml 데이터베이스설정 미작성");}
		catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
			if(!con.isClosed()) {
				con.close();
				System.out.println("finally - db연걸 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;

	}//getMembers(int, int) end	
	
	
	public BoardDTO getDetail(int seq) {
	BoardDTO dto = null;
	Connection con = null;
	try {
		Context context = new InitialContext();
		Context env = (Context)context.lookup("java:/comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");
		con = ds.getConnection();
	con.setAutoCommit(false);
	
		
	String selectSQL = "UPDATE board set viewcount =viewcount+1 where seq=?";
	PreparedStatement pt1 = con.prepareStatement(selectSQL);
	pt1.setInt(1,seq);
	pt1.executeUpdate();
	
	String selectSQL1 = "select * from board where seq=?";
	pt1 = con.prepareStatement(selectSQL1);
	pt1.setInt(1, seq);
 	ResultSet rs = pt1.executeQuery();
 	
 	if(rs.next()) {
 		dto = new BoardDTO();
		dto.setNumber(rs.getInt("seq"));
		dto.setTitle (rs.getString("title"));
		dto.setContents(rs.getString("contents"));
		dto.setWriter(rs.getString("writer"));
		dto.setViewcount(rs.getInt("viewcount"));
		dto.setWritingtime(rs.getString("writingtime"));
		dto.setPw(rs.getInt("pw"));
 	}
 	con.commit();
	con.close();
	}
	catch(NamingException e) {
		System.out.println("context.xml 데이터베이스설정 미작성");}
	catch(SQLException e) {
		System.out.println("db 연결 실패-연결 정보를 확인하세요");
		e.printStackTrace();
	}finally {
		try {
		if(!con.isClosed()) {
			con.close();
			System.out.println("finally - db연걸 해제 성공");
			}
		}catch(Exception e) {}
	}
	return dto;
	}
	
	
	
	public void deleteBoard(int seq) {
		Connection con = null;
		try {
			Context context = new InitialContext();
			Context env = (Context)context.lookup("java:/comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/mydb");
			con = ds.getConnection();
			con.setAutoCommit(false);
		String selectSQL = "select seq from board where seq=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1, seq);
	 	ResultSet rs = pt2.executeQuery();

	 	if(rs.next()) {
	 			String deleteSQL = "delete from board where seq=?";
	 			PreparedStatement pt = con.prepareStatement(deleteSQL);
	 			pt.setInt(1, seq);
	 			pt.executeUpdate();
	 		}
	 	con.commit();
		con.close();
		}
		catch(NamingException e) {
			System.out.println("context.xml 데이터베이스설정 미작성");}
		catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();
		}finally {
			try {
			if(!con.isClosed()) {
				con.close();
				System.out.println("finally - db연걸 해제 성공");
				}
			}catch(Exception e) {}
		}
	}
	
	
	
	public void updateBoard(BoardDTO dto) {
			String sql = "update board set title=?, contents=?, writingtime=sysdate where seq=?";
			Connection con=null;
			try {
				Context context = new InitialContext();
				Context env = (Context)context.lookup("java:/comp/env");
				DataSource ds = (DataSource)env.lookup("jdbc/mydb");
				con = ds.getConnection();
			//	con.setAutoCommit(false);
				PreparedStatement pt2 = con.prepareStatement(sql);
				pt2.setString(1,dto.getTitle());
				pt2.setString(2,dto.getContents());
				pt2.setString(3,dto.getWritingtime());
				//con.commit();
				con.close(); 
			}
			catch(NamingException e) {
				System.out.println("context.xml 데이터베이스설정 미작성");}
			catch(SQLException e) {
				System.out.println("db 연결 실패-연결 정보를 확인하세요");
				e.printStackTrace();
			}finally {
				try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db연걸 해제 성공");
					}
				}catch(Exception e) {}
			}
			
			}		
}
