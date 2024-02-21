package com.workmotion.app.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.workmotion.app.member.MemberDTO;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			Object obj = (MemberDTO)session.getAttribute("member");
			if(obj != null) {
				return true; 
			}else {
				request.setAttribute("msg","로그인이 필요한 서비스 입니다");
				request.setAttribute("path","/member/login");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
				rd.forward(request, response);
				return false;
			}
	}

}
