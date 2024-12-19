package el;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookiesave")
public class CookieSaveServelet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 객체 생성
		Cookie c = new Cookie("name", "tomcat");
		//유효기간 설정(선택적) 안하면 브라우저 종료시 삭제됨
		c.setMaxAge(24*60*60);
		//클라이언트로 쿠키 전송
		response.addCookie(c);
		
		response.addCookie(new Cookie("age",URLEncoder.encode("20살","utf-8")));//한글 인코딩
		response.addCookie(new Cookie("pw","1234"));
	}

}
