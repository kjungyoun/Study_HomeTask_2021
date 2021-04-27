package com.ssafy.guestbook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.guestbook.model.GuestBookDto;
import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.GuestBookService;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/article")
public class GuestBookController {
	
	private static final Logger logger = LoggerFactory.getLogger(GuestBookController.class);
	
	@Autowired
	private GuestBookService guestBookService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "guestbook/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(GuestBookDto guestBookDto, Model model, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		if(memberDto != null) {
			logger.debug("만약 로그인 상태라면...");
			guestBookDto.setUserid(memberDto.getUserid());
			try {
				guestBookService.writeArticle(guestBookDto);
				return "guestbook/writesuccess";
			}catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "글작성 중 오류 발생!!!");
				return "error/error";
			}
		}else {
			model.addAttribute("msg", "로그인 후 사용 가능합니다.");
			return "error/error";
		}
	}
	
	@GetMapping("/list")
	// pg=1&key=&word=
	// 파라미터에 dto를 넣으면 해당 dto에 전달받은 인자를 자동으로 넣어줌
	// 하지만 pg, key, word를 담는 dto가 존재하지 않기 때문에 map에 담은 것이다.
	public String list(@RequestParam Map<String,String>map, Model model) {
		String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "10");
		System.out.println("========="+map.get("pg"));
		try {
			List<GuestBookDto>list = guestBookService.listArticle(map);
			PageNavigation page = guestBookService.makePageNavigation(map);
			model.addAttribute("articles", list);
			model.addAttribute("navigation", page);
			return "guestbook/list";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글 리스트를 가져오는 중 오류 발생!!!");
			return "error/error";
		}
		
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("articleno") int articleno, Model model) {
		try {
			GuestBookDto guestBookDto = guestBookService.getArticle(articleno);
			model.addAttribute("article", guestBookDto);
			return "guestbook/modify";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글 조회하는 도중 오류 발생!!!");
			return "error/error";
		}
	}
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(GuestBookDto guestBookDto, Model model, HttpSession session) {
		MemberDto member = (MemberDto) session.getAttribute("userinfo");
		if(member != null) {
			try {
				guestBookService.modifyArticle(guestBookDto);
				return "guestbook/writesuccess";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "글 수정중 오류 발생!!!");
				return "error/error";
			}
		}else {
			model.addAttribute("msg", "로그인 후 사용 가능한 페이지 입니다.");
			return "error/error";
		}
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("articleno") int articleno, Model model){
		try {
			guestBookService.deleteArticle(articleno);
			return "redirect:list?pg=1&key=&word=";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "글 삭제 도중 오류 발생!!!!");
			return "error/error";
		}
	}
	
	
	
}
