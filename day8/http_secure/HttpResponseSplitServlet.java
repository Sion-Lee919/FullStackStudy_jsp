package secure;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/httpresponsesplit")
public class HttpResponseSplitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//응답분할인젝션 필터링. 비어있는 줄 나오면 그 이후는 무시
		System.out.println(name.indexOf("\r\n\r\n"));
		String filteredName = name.substring(0,name.indexOf("\r\n\r\n"));
		
		
		Cookie cookie = new Cookie("cookiename",URLEncoder.encode(filteredName,"utf-8"));
		cookie.setMaxAge(1000);
		response.addCookie(cookie);//
		RequestDispatcher rd = request.getRequestDispatcher("/secure/secure_http.jsp");
		rd.forward(request, response);
	}

}
