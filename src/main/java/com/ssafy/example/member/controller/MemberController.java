package com.ssafy.example.member.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.example.member.model.dto.Member;
import com.ssafy.example.member.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/user")
@CrossOrigin("*")
@Slf4j
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public String login(@RequestParam(required = false) String prev, Model model) {
		model.addAttribute("prev", prev);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam Map<String, String> map,
			@RequestParam(name="saveid", required=false) String saveid, 
			String prev, Model model,
			HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Member loginUser = memberService.login(map);
			// 로그인 성공
			if(loginUser != null) {
				// 세션 설정
				session.setAttribute("loginUser", loginUser);		
				// 아이디 저장 쿠키 설정
				Cookie cookie = new Cookie("ssafy_id", map.get("id"));
				cookie.setPath("/book"); // 왜 북으로 설정되어있지 root context 찾아서 설정해줘야함
				if("ok".equals(saveid)) {
					cookie.setMaxAge(60 * 60 * 24);
				} else {
					cookie.setMaxAge(0);
				}
				res.addCookie(cookie);
				if(!prev.equals("")) {
					return "redirect:" + prev;
				}
				return "redirect:/";
			}
			model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			return "user/login";
		} catch (Exception e) {
			// 로그인 실패
			e.printStackTrace();
			model.addAttribute("msg", "로그인 오류");
			return "login";
		}
	}
	
	@GetMapping("/join")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute Member member, Model model) {
		memberService.addMember(member);
		return "redirect:/user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
