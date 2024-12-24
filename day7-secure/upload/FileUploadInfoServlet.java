package upload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fileuploadinfo")
public class FileUploadInfoServlet extends HttpServlet {
	//아직 파일 업로드하는 거 아님 어떻게 돌아가는지만 확인하는 코드임
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String file = request.getParameter("uploadfile");
		
		response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.println("<HTML>");
	    out.println("<BODY>");
	    out.println("<HEAD>");
	    out.println("<TITLE>파일 업로드 테스트</TITLE>");
	    out.println("</HEAD>");
	    out.println("<BODY>");
	    out.println("<H3>파일 올리기 성공</H3>");
	    
	    out.println("<h3>업로드문서타입 :" +request.getContentType()+"<h3>");
	    out.println("<h3>업로드문서타입 :" +request.getContentLength()+"<h3>");
	    
	    out.println("<p style='color:green'>전송받은 내용 확인</p>");
	    BufferedReader br = new BufferedReader(new InputStreamReader( request.getInputStream()));
	    String line;
	    while( (line =br.readLine()) !=null){
	    	out.println(line +"<br>");
	    }
	    out.println("</Body>");
	    out.println("</html>");
	}

}
