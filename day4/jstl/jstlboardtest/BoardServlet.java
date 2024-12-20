package jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/boardjstl")
public class BoardServlet extends HttpServlet {
	ArrayList<BoardDTO> boardlist;
	Map<String, String[]> category;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jspfile = "";
		String action = req.getParameter("action");
		if(action == null || action.equals("list")) {
			req.setAttribute("boardlist", boardlist);
			req.setAttribute("categorymap", category);
			jspfile="/jstl/jstlboardlist.jsp";
			//boardlist, categorymap 속성을 전달받으면 el, jstl 태그를 이용하여 <table>로 출력
		}
		
		RequestDispatcher rd =  req.getRequestDispatcher(jspfile);
		rd.forward(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		boardlist = new ArrayList();
		boardlist.add(new BoardDTO(1, "게시물1", "게시물 1의 내용입니다", "id1"));
		boardlist.add(new BoardDTO(2, "게시물2", "게시물 2의 내용입니다", "id2"));
		boardlist.add(new BoardDTO(3, "게시물3", "게시물 3의 내용입니다", "id3"));
		boardlist.add(new BoardDTO(4, "게시물4", "게시물 4의 내용입니다", "id4"));
		boardlist.add(new BoardDTO(5, "게시물5", "게시물 5의 내용입니다", "id5"));
		
		category = new HashMap();
		category.put("의류", new String[] {"남성의류", "여성의류","아동의류","유아의류","스포츠의류"});
		category.put("식품", new String[] {"냉동", "과일","축산","음료","과자"});
		category.put("가전", new String[] {"소형가전", "주방가전","오디오/비디오"});
		category.put("학용품", new String[] {"미술용품", "필기류","포장지류"});
	}

}
