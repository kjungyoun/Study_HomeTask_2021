package com.ssafy.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ssafy.guestbook.model.MemberDto;

public class ConfirmInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)throws Exception {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("userinfo");
		if(member == null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		return true;
	}
}
