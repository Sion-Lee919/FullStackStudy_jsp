package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String userid = request.getParameter("userid");
		int seq=-1;
		if(request.getParameter("seq") != null) {
		seq = Integer.parseInt(request.getParameter("seq"));}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ArrayList<BoardDTO> boardlist = new ArrayList(); 
		boardlist.add(new BoardDTO(1, "게시물1", "게시물 1의 내용입니다", "id1")); 
		boardlist.add(new BoardDTO(2, "게시물2", "게시물 2의 내용입니다", "id2")); 
		boardlist.add(new BoardDTO(3, "게시물3", "게시물 3의 내용입니다", "id3")); 
		boardlist.add(new BoardDTO(4, "게시물4", "게시물 4의 내용입니다", "id4")); 
		boardlist.add(new BoardDTO(5, "게시물5", "게시물 5의 내용입니다", "id5")); 
		
		HttpSession session = request.getSession();
		if(("list").equals(action)) {
		request.setAttribute("boardlist", boardlist);
		
		RequestDispatcher dis = request.getRequestDispatcher("/board/boardlist.jsp");
		dis.forward(request, response);
		
		}
		else if(("write").equals(action) && ("testid").equals(userid)) {
			session.setAttribute("userid",userid);
			RequestDispatcher dis = request.getRequestDispatcher("/board/boardwriteform.jsp");
			dis.forward(request, response);
		}
		else if(("detail").equals(action) && seq != -1) {
			BoardDTO a = boardlist.get(seq-1);
			request.setAttribute("list", a);
			RequestDispatcher dis = request.getRequestDispatcher("/board/boarddetail.jsp");
			dis.forward(request, response);
		}
		else {
			out.println( "<h3> 값을 정확하게 입력하세요 </h3>");
		}
		
	}

}
