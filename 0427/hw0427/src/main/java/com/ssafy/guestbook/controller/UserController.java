package com.ssafy.guestbook.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam Map<String, String>map, Model model, HttpSession session, HttpServletResponse response) {
		try {
			MemberDto member = memberService.login(map);
			if(member != null) {
				session.setAttribute("userinfo", member);
				
				Cookie cookie = new Cookie("ssafy_id", member.getUserid());
				cookie.setPath("/");
				if("saveok".equals(map.get("idsave"))) { // 만약 id 저장한다면
					// 40년 동안 저장
					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
				}else {
					// 쿠키 삭제
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
			}else {
				model.addAttribute("msg", "아이디 비밀번호를 확인하세요!");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		// Spring은 기본적으로 forward로 가기 때문에 model에다 담은 정보를 보낼 수 있다.
		// 하지만 redirect: 은 redirect로 페이지 이동하는 것이기 때문에 model에 있는 정보를 다 버리고 간다.
		return "redirect:/";
	}
}
