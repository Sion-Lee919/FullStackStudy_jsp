package mvc;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/boardstart")
public class BoardStartServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp="";
		int allpage=0;
		HttpSession session = request.getSession();
		if(request.getParameter("menu")==null) {
			jsp ="/mvc/boardstart.jsp";			
		}
		else {
			if(request.getParameter("menu").equals("loginform")) {
				jsp ="/mvc/loginform.jsp";
			}
			else if(request.getParameter("menu").equals("login")&& request.getMethod().equals("POST")){
				String id=  request.getParameter("id");
				int pw= Integer.parseInt(request.getParameter("pw"));
				MemberDAO dao = new MemberDAO();
				MemberDTO dto = dao.getMember(id, pw);
				if(dto!= null&&dto.getPw() != 0) {
					session.setAttribute("sessionid", dto.getId());
				}
				jsp ="/mvc/boardstart.jsp";
			}
			else if(request.getParameter("menu").equals("logout")) {
				if(session.getAttribute("sessionid")!=null) {
				session.removeAttribute("sessionid");
				}
				jsp="/mvc/boardstart.jsp";
			}
			else if(request.getParameter("menu").equals("writingform")) {
				jsp="/mvc/writeform.jsp";
			}
			else if(request.getParameter("menu").equals("write")) {
				String title = request.getParameter("title");
				String contents =request.getParameter("contents");
				int pw =Integer.parseInt(request.getParameter("pw"));
				String writer =request.getParameter("writer");
				BoardDTO dto1 =new BoardDTO();
				dto1.setTitle(title);
				dto1.setContents(contents);
				dto1.setPw(pw);
				dto1.setWriter(writer);
				BoardDAO dao1 = new BoardDAO();
				dao1.insertBoard(dto1);
				response.sendRedirect("http://localhost:8070/jsptest/boardstart");
				return;
			}
			else if(request.getParameter("menu").equals("boardlist")) {
				int page = Integer.parseInt( request.getParameter("page"));
				int count =5;
				BoardDAO dao2 = new BoardDAO();
				allpage=dao2.getTotalBoardCount();
				ArrayList<BoardDTO> list = dao2.getBoardList(page, count);
				request.setAttribute("allpage", allpage);
				request.setAttribute("count", count);
				request.setAttribute("boardlist", list);
				jsp="/mvc/boardlist.jsp";
			}
			else if(request.getParameter("menu").equals("boardstart")) {
				jsp="/mvc/boardstart.jsp";
			}
			else if(request.getParameter("menu").equals("boarddetail")) {
				int seq = Integer.parseInt( request.getParameter("seq"));
				BoardDAO dao3 = new BoardDAO();
				BoardDTO viewcount = dao3.getDetail(seq);
				request.setAttribute("boarddetail", viewcount);
				jsp="/mvc/boarddetail.jsp";
			}
			else if(request.getParameter("menu").equals("boarddelete")) {
				int seq = Integer.parseInt( request.getParameter("seq"));
				BoardDAO dao4 = new BoardDAO();
				dao4.deleteBoard(seq);
				
				int page = 1;
				int count =5;
				allpage=dao4.getTotalBoardCount();
				ArrayList<BoardDTO> list = dao4.getBoardList(page, count);
				request.setAttribute("allpage", allpage);
				request.setAttribute("count", count);
				request.setAttribute("boardlist", list);
				jsp="/mvc/boardlist.jsp";
			}
			else if(request.getParameter("menu").equals("boardupdate")) {
				int seq = Integer.parseInt( request.getParameter("seq"));
				String title =request.getParameter("title");
				String contents =request.getParameter("contents");
				BoardDTO dto5 = new BoardDTO();
				dto5.setNumber(seq);
				dto5.setTitle(title);
				dto5.setContents(contents);
				BoardDAO dao5 = new BoardDAO();
				dao5.updateBoard(dto5);
				
				int page = 1;
				int count =5;
				allpage=dao5.getTotalBoardCount();
				ArrayList<BoardDTO> list = dao5.getBoardList(page, count);
				request.setAttribute("allpage", allpage);
				request.setAttribute("count", count);
				request.setAttribute("boardlist", list);
				jsp="/mvc/boardlist.jsp";
			}
		}//첫 else
		RequestDispatcher rd= request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}//service

}//class