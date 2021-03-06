package com.ssafy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.MemberDto;
import com.ssafy.model.dto.Product;
import com.ssafy.model.service.LoginService;
import com.ssafy.model.service.LoginServiceImpl;

@WebServlet( "/main.do" )
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService;
	
	@Override
	public void init() throws ServletException{
		super.init();
		loginService = new LoginServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		String action = request.getParameter("action");
		System.out.println("action>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+action);
		String url="index.jsp";
		try {
			if(action != null) {
				if(action.equals("login")) {
					url = login(request,response);
				}else if(action.equals("logout")) {
					url = logout(request,response);
				}else if(action.equals("mvInsert")) {
					url = "product/insert.jsp";
				}else if(action.equals("insertProduct")) {
					url = insertProduct(request,response);
				}else if(action.equals("searchLastProduct")) {
					url = searchLastProduct(request,response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url="error/error.jsp";
		}
		
		if(url.startsWith("redirect:")) { // ????????? redirect: ??? ???????????? sendRedirect???.
			// redirect:url ????????? url?????? redirect: ??? ???????????? ??????
			response.sendRedirect(url.substring(url.indexOf(":")+1)); 
			
		}else { // ????????? redirect: ??? ???????????? ????????? ??????????????? forward??? ??????.
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private String searchLastProduct(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// 2. ???????????? ????????? ?????? ??????
					Cookie[] cookies = request.getCookies();
					String no = null;
					String name = null;
					String price = null;
					String info = null;
					if(cookies != null) {
						for (Cookie cookie : cookies) {
							if(cookie.getName().equals("productNo")) {
								no = cookie.getValue();
							}else if(cookie.getName().equals("productName")) {
								name = URLDecoder.decode(cookie.getValue(), "UTF-8");
							}else if(cookie.getName().equals("price")) {
								price = cookie.getValue();
							}else if(cookie.getName().equals("info")) {
								info = URLDecoder.decode(cookie.getValue(), "UTF-8");
							}
						}
					}
					if(no != null) { // ??????????????? ????????? ??????????????? ????????? ?????? ??????
						Product product = new Product(Integer.parseInt(no),name,Integer.parseInt(price),info);
						request.setAttribute("product", product);
					}else {
						request.setAttribute("msg", "????????? ????????? ????????????.");
					}
					return "product/insertsuccess.jsp";
	}
	
	private String insertProduct(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String info = request.getParameter("info");
		
		Cookie noCookie = new Cookie("productNo",no);
		Cookie nameCookie = new Cookie("productName",URLEncoder.encode(name,"UTF-8"));
		Cookie priceCookie = new Cookie("price",price);
		Cookie infoCookie = new Cookie("info",URLEncoder.encode(info,"UTF-8"));
		
		/* ?????? ???????????? ??????
		 * ??????	: ?????? ???????????? ????????? ??????(???)??? ?????? ??????????????? ?????? ?????? ???????????? ?????????. => ?????? ????????? ?????????
		 * 0	: ????????? ????????? ??????
		 * ??????	: ????????? ??????????????? ??????
		 */
		noCookie.setMaxAge(1000000000);
		nameCookie.setMaxAge(100000000);
		priceCookie.setMaxAge(100000000);
		infoCookie.setMaxAge(100000000);
		
		response.addCookie(noCookie);
		response.addCookie(nameCookie);
		response.addCookie(priceCookie);
		response.addCookie(infoCookie);
		
		return "index.jsp";
	}
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index.jsp";
	}
	private String login(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		String url="index.jsp";
		try {
			MemberDto userinfo = loginService.login(userid, userpwd); // ????????? ?????? ????????? ????????? ??????
			
			// ?????? ??????
			
			// 1. session??? ????????? ?????? ????????????
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userinfo);
			
			
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		return url;
	}
}
