package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import vo.LoginVO;

// 로그아웃 요청시, 기존 세션에 loginVO 가 있는지 확인
// false : loginVO 객체가 없을 경우
// true : loginVO 객체가 있을 경우 
@Component
public class LogoutInterceptor implements HandlerInterceptor{

	// 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		System.out.println(loginVO);
		
		if(ObjectUtils.isEmpty(loginVO)) {
			System.out.println("LogoutInterceptor fail redirect to /javas/logoutfail");
			response.sendRedirect("/javas/logout/fail");
			return false;
		} else {
			System.out.println("LogoutInterceptor success!!");
			return true;
		}
	}

	// 클라이언트의 요청을 처리한 뒤 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// 클라이언트의 요청을 마치고 클라이언트에서 뷰를 통해 응답 전송 후 실행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
