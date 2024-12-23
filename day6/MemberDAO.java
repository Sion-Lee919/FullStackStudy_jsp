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

public class MemberDAO {
	//회원가입
	public String insertMenber(MemberDTO dto) {
		String msg="";
		Connection con = null;
		try {

		/*Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
				*/
			Context context = new InitialContext();//context.xml 파일 설정내용 객체
			Context env = (Context)context.lookup("java:/comp/env");//연관설정 가져오는 접두어
			DataSource ds = (DataSource)env.lookup("jdbc/mydb");//미리 con 몇개 생성
			con = ds.getConnection();
		System.out.println("db 연결 성공");
		//dto.getId() member 테이블 중복검사
		String selectSQL = "select id from members where id=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setString(1, dto.getId());
	 	ResultSet rs = pt2.executeQuery();
		//members id pk (1개/0개/n개(x))
	 	if(rs.next()) {
	 		//중복
	 		msg = ("중복된 아이디입니다. 다른 아이디를 입력하세요");
	 	}
	 	else {
	 		//중복x
			String insertSQL = "insert into members values(?,?,?,?,?,sysdate)";
			PreparedStatement pt = con.prepareStatement(insertSQL);
			pt.setString(1,dto.getId());
			pt.setString(2,dto.getName());
			pt.setInt(3,dto.getPw());
			pt.setString(4,dto.getPhone());
			pt.setString(5,dto.getEmail());
			int rows = pt.executeUpdate();
			msg = rows+"명의 회원가입 성공했습니다.";
	 	}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}
		/*catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}*/
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
		return msg;
	}
	
	//회원 정보 수정
	/*public String UpdateMenber(MemberDTO dto) {
		String msg="";
		Connection con = null;
		try {

		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = "select id from members where id=?";
		PreparedStatement pt1 = con.prepareStatement(selectSQL);
		pt1.setString(1, dto.getId());
	 	ResultSet rs = pt1.executeQuery();
	 	if(!rs.next()) {
	 		msg = ("아이디가 일치하지 않습니다. 다시입력하세요");
	 		return msg;
	 	}
	 	else {
	 		msg = (" 아이디가 일치합니다");
	 	}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}catch(SQLException e) {
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
		return msg;
	}*/
	
	public String UpdateMenber(MemberDTO dto) {
		String sql = "update members set name=?, phone=?, email=? where id=?";
		String msg="";
		Connection con=null;
		try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection
					(DBInfo.url,DBInfo.account,DBInfo.password);
			System.out.println("db 연결 성공");
			//회원 존재여부+ 암호여부
			PreparedStatement pt2 = con.prepareStatement(sql);
			pt2.setString(1, dto.getName());
			pt2.setString(2, dto.getPhone());
			pt2.setString(3, dto.getEmail());
			pt2.setString(4, dto.getId());
			pt2.executeUpdate();
		 	msg = "update성공";
			
			con.close(); 
			System.out.println("db연걸 해제 성공");
			}catch(ClassNotFoundException e) {
				System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
				System.out.println( "module-info.java 미설정 확인하세요");
			}catch(SQLException e) {
				System.out.println("db 연결 실패-연결 정보를 확인하세요");
				e.printStackTrace();
				msg="update실패";
			}finally {
				try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db연걸 해제 성공");
					}
				}catch(Exception e) {}
			}
			return msg;
		}		
				
	
	//회원 탈퇴
	public String DeleteMenber(String id,int pw) {
		String msg="";
		Connection con = null;
		try {
	
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
		System.out.println("db 연결 성공");
		//회원 존재여부+ 암호여부
		String selectSQL = "select id, pw from members where id=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setString(1, id);
	 	ResultSet rs = pt2.executeQuery();

	 	if(rs.next()) {
	 		if(pw == rs.getInt("pw")) {
	 			String deleteSQL = "delete from members where id=?";
	 			PreparedStatement pt = con.prepareStatement(deleteSQL);
	 			pt.setString(1, id);
	 			pt.executeUpdate();
	 			msg = "성공적으로 탈퇴처리되었습니다.";
	 		}
	 		else {
	 			msg="입력하신 암호는 회원님의 암호와 다릅니다.";
	 		}
	 	}	
	 	else {
			msg = "가입된 회원이 아닙니다.";
	 	}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}catch(SQLException e) {
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
		return msg;
	}
	
	//내 정보 조회
	public MemberDTO getMember(String id,int pw) {
		MemberDTO dto = null;
		Connection con = null;
		try {
	
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
		System.out.println("db 연결 성공");
		//회원 존재여부+ 암호여부
		String selectSQL = "select id, name,pw,phone,email,to_char(regdate,'yyyy\"년도\"mm\"월\"dd\"일\"') regdate from members where id=?";
		PreparedStatement pt1 = con.prepareStatement(selectSQL);
		pt1.setString(1, id);
	 	ResultSet rs = pt1.executeQuery();

	 	if(rs.next()) {
	 		if(pw == rs.getInt("pw")) {
	 			dto = new MemberDTO();
	 			dto.setId(rs.getString("id"));
	 			dto.setName( rs.getString("name"));
	 			dto.setPw( rs.getInt("pw"));
	 			dto.setPhone (rs.getString("phone"));
	 			dto.setEmail (rs.getString("email"));
	 			dto.setRegdate(rs.getString("regdate"));	 			
	 		}
	 		else {
	 			dto = new MemberDTO();
	 			dto.setId(rs.getString("id"));
	 		}
	 	}	
	 	//else { dto는 이미 null이여서 쓸 필요가 없음
	 	//}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}catch(SQLException e) {
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

	//회원리스트 조회 페이지
	public int getTotalCount() {
		int cm=0;
		Connection con = null;
		try {
	
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url,DBInfo.account,DBInfo.password);
		System.out.println("db 연결 성공");
		//회원 존재여부+ 암호여부
		String selectSQL = "select count(*) cm from members";
		PreparedStatement pt1 = con.prepareStatement(selectSQL);
	 	ResultSet rs = pt1.executeQuery();
	 	
	 	if(rs.next()) {
	 		cm= rs.getInt("cm");
	 		
	 		}
		con.close(); 
		System.out.println("db연걸 해제 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버 이름 혹은 classpath잘못되었을 수 있습니다.");
			System.out.println( "module-info.java 미설정 확인하세요");
		}catch(SQLException e) {
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
		return cm ;
	}
	
	//회원리스트 조회
	public ArrayList<MemberDTO> getMembers(int pagenumber, int count) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = 
		"select id, name, phone, email, regdate "
		+ "	from(select rownum r,  imsi.* "
		+ " from (select * from members order by regdate desc) imsi)" 
		+ " where r between ? and ?";
		
		int start = (pagenumber-1)*count + 1;
		int end = pagenumber * count;

		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1,  start);
		pt2.setInt(2,  end);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
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

	}//getMembers(int, int) end	


	
	
	//검색조회
	public ArrayList<MemberDTO> getMembers(String[] items, String word){
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

			Connection con = null;
			try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection
					(DBInfo.url, DBInfo.account, DBInfo.password);
			System.out.println("db 연결 성공");
			
			String selectSQL = "select * from members where "+items[0]+ " like ?";
			for (int i = 1; i < items.length; i++) {
				selectSQL += " or "+items[i]+" like ?"; //공백 정확하게 주기
			}
			System.out.println(selectSQL);
			
			PreparedStatement pt2 = con.prepareStatement(selectSQL);
			for (int i = 1; i <= items.length; i++) {
				pt2.setString(i, "%"+word+"%");
			}
			ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
			
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

		}//getMembers(int, int) end		
	
}//class end

