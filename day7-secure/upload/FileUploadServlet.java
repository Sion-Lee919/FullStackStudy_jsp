package upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

@WebServlet("/upload")
@MultipartConfig(location = "C:\\ezwel\\upload\\", maxFileSize = 1024 * 1024 *5, maxRequestSize =1024 * 1024 *5 *5 )//1024= 1kb 1024*1024=1mb //1024 * 1024 *5 파일 하나당 5메가 제한
public class FileUploadServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//해킹방지 외부경로로 저장. 업로드한 파일 저장 경로. 만약 경로가 없으면 자동 생성
		String path ="C:\\ezwel\\upload\\";
		File isDir = new File(path);
		if(!isDir.isDirectory()) {
			isDir.mkdir();
		}
		
		
		
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			if(part.getContentType() != null) {
				String fileName = part.getSubmittedFileName();//zoom방.txt
				fileName = fileName.toLowerCase();
				if(fileName.endsWith(".pdf") || fileName.endsWith(".docx") //해킹방지 화이트리스트. 확장자 제한
					|| fileName.endsWith(".hwp") || fileName.endsWith(".xls") 
					|| fileName.endsWith(".txt") || fileName.endsWith(".png") 
					|| fileName.endsWith(".jpg") || fileName.endsWith(".gif"))
				{

				fileName = //해킹방지 난수생성
						fileName.substring(0, fileName.indexOf("."))//zoom방
						+ "_"+ UUID.randomUUID().toString().substring(0,10)//문자난수 //System.currentTimeMillis() 숫자난수
						+fileName.substring(fileName.indexOf("."));//.txt
				out.println("<br>"+ part.getContentType());
				out.println("<br>"+ part.getSize());
				out.println("<br>"+ part.getHeader("content-disposition"));
				part.write(fileName);
				}
			}
			else {
				String partName = part.getName();
				String fileValue = request.getParameter(partName);
				out.println("<br>"+partName + " : " +fileValue);
			}
		}
		out.close();
	}

}
