package com.ssafy.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.example.member.model.dto.Member;

@Component
public class SessionInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginUser");
		if(member == null) {
			response.sendRedirect(request.getContextPath() + "/user/login?prev=" + request.getServletPath());
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
