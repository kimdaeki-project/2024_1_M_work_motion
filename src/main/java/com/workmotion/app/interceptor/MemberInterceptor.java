package com.workmotion.app.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("member");
			if(obj != null) {
				return true; 
			}else {
				System.out.println("로그인 한 사람만 가능한 경로 입니다");
				request.setAttribute("msg","로그인이 필요한 서비스 입니다");
				request.setAttribute("page","commons/result");
				request.setAttribute("path","/member/login");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
				rd.forward(request, response);
				return false;
			}
	}

}
