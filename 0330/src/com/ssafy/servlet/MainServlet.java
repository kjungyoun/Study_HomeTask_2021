package com.ssafy.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dto.MemberDto;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String act = request.getParameter("act");
		
		if("login".equals(act)) {
			login(request,response);
		}else if("logout".equals(act)) {
			logout(request,response);
		}else if("join".equals(act)) {
			response.sendRedirect(root+"/user/join.jsp");
		}else if("register".equals(act)) {
			register(request,response);	
		}else if("registerprod".equals(act)) {
			registerProd(request,response);
		}
	}

	
	private void registerProd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("prodid");
		String name = request.getParameter("prodname");
		String price = request.getParameter("price");
		String desc = request.getParameter("desc");
		
		Cookie cookie = new Cookie("id", id);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60 * 60 *24 * 365);
		response.addCookie(cookie);
		cookie = new Cookie("name", name);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60 * 60 *24 * 365);
		response.addCookie(cookie);
		cookie = new Cookie("price", price);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60 * 60 *24 * 365);
		response.addCookie(cookie);
		cookie = new Cookie("desc", desc);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60 * 60 *24 * 365);
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath()+"/user/logined.jsp");
		
	}


	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String root = request.getContextPath();
		String id = request.getParameter("userid");
		String pwd = request.getParameter("userpwd");
		HttpSession session = request.getSession();
		session.removeAttribute("userinfo");;
		MemberDto member = new MemberDto();
		member.setId(id);
		member.setPwd(pwd);
		session.setAttribute("userinfo", member);
		
		response.sendRedirect(root+"/index.jsp");
		
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String root = request.getContextPath();
		session.removeAttribute("logininfo");
		response.sendRedirect(root+"/index.jsp");
		
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("userpwd");
		String root = request.getContextPath();
		
		// session 설정
		HttpSession session = request.getSession();
		MemberDto info = (MemberDto) session.getAttribute("userinfo");
		String path = "/index.jsp";
		if(info == null) {
			request.setAttribute("msg", "아이디가 존재하지 않습니다. 회원가입을 해주세요!");
			request.getRequestDispatcher(path).forward(request, response);
		}
		else if(!id.equals(info.getId())) {
			request.setAttribute("msg", "아이디가 틀렸습니다. 다시 확인해주세요!");
			request.getRequestDispatcher(path).forward(request, response);
		}else if(!pwd.equals(info.getPwd())) {
			request.setAttribute("msg", "비밀번호가 다릅니다. 다시 확인해주세요!");
			RequestDispatcher disp =  request.getRequestDispatcher(path);
			disp.forward(request, response);
		}else { // 로그인 성공
			MemberDto member = new MemberDto();
			member.setId(id);
			member.setPwd(pwd);
			session.setAttribute("logininfo", member);
			response.sendRedirect(root+"/user/logined.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
