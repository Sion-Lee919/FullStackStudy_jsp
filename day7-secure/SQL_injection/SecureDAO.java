package secure;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.DBInfo;
import dto.MemberDTO;
import mvc.BoardDTO;
 
public class SecureDAO {
	public ArrayList<MemberDTO> test1(String where){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		//입력값 'or '1'='1 항상 트루가 되는 조건을 추가해서 where절을 무시하는 해킹
		String sql = "select * from members where name = '" + where + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;
	}
	public ArrayList<BoardDTO> test2(String where){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		// select title, pw from board  where title='중복글' union select id,pw from members
		//입력값 --'중복글' union select id,pw from members
		String sql = "select title, pw from board  where title=" + where;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setTitle(rs.getString("title"));
			dto.setPw(rs.getInt("pw"));

			list.add(dto);
		}
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;
	}
	public MemberDTO test3(String id, int pw) throws ClassNotFoundException, SQLException{
		MemberDTO dto = null;
		Connection con = null;
		//try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		//select * from members where id = " + id and pw
		//입력값 select * from members where id = " + id-- and pw  //--주석
		/*String sql = "select * from members where id = " + id + " and pw=" + pw;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		Statement로 만들었던 거 주석처리*/
		//PreparedStatement 가 인젝션을 더 감소시켜준다 'q1'--이 문장 자체를 문자열로 취급
		String sql = "select * from members where id = ? and pw=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setInt(2, pw);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
		}
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		//}catch(ClassNotFoundException e) {
		//	System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
		//	System.out.println("module-info.java 미설정 확인하세요 ");
		//}catch(SQLException e) {
		//	System.out.println("db 연결 실패-연결 정보를 확인하세요");
		//	e.printStackTrace();//오류발생원인 추적하여 출력
		//}finally {
		//	try {
		//		if(!con.isClosed()) {
		//			con.close();
		//			System.out.println("finally - db 연결 해제 성공");
		//		}
		//	}catch(Exception e) {}
		//}
		return dto;
	}

}
