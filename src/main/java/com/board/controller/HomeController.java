package com.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.dto.Member;
import com.board.service.MemberService;

public class HomeController {
	
	@Autowired
	MemberService memberService;
	//메인화면
		@RequestMapping("/home/main")
		@ResponseBody
		public String showMain(HttpSession session, Model model) {
			long loginedMemberId = 0;
			if(session.getAttribute("loginedMemberId") != null) {
				loginedMemberId =(long) session.getAttribute("loginedMemberId");
			}
			Member loginedMember = memberService.getOne(loginedMemberId);
			
			model.addAttribute("loginedMember", loginedMember);
			
			return "home/main";
		}
		
		@RequestMapping("/")
		public String showMain() {
			return "redirect:/home/main";
		}
}
