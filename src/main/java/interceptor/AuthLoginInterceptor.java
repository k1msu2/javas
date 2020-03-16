package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import vo.LoginVO;

// 로그인 한 사람만 확인 할 수 있는 페이지에 접근하려고 할 떄 로그인 상태 확인 
// false : loginVO 객체가 비어 있을 때 로그인 할 것인지 확인
// true : loginVO 객체가 있을 때 요청했던 페이지로 리다이렉트
@Component
public class AuthLoginInterceptor implements HandlerInterceptor{

	// 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		System.out.println(loginVO);
			
		if(!ObjectUtils.isEmpty(loginVO)) {
			System.out.println("AuthLoginInterceptor success");	
			return true;
		} else {
			System.out.println("AuthLoginInterceptor fail redirect to /javas/authloginfail");	
			response.sendRedirect("/javas/authloginfail");
			return false;
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
