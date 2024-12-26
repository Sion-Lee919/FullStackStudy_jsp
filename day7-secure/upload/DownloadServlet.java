package upload;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebServlet("/downloadlist")
public class DownloadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File f = new File("c:/ezwel/upload/");
		String[] filearray = f.list();
		
		request.setAttribute("filearray", filearray);
		RequestDispatcher rd = request.getRequestDispatcher("/upload/downloadlist.jsp");
		rd.forward(request, response);

	}
}