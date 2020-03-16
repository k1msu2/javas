package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import vo.LoginVO;

// 로그인 하려고 할 때 로그인 여부 확인
// false : 현재 세션 있음 - 로그아웃 요청
// true : 현재 세션 없음 - 정상처리
@Component
public class LoginInterceptor implements HandlerInterceptor{

	// 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		System.out.println(loginVO);
		
		if(!ObjectUtils.isEmpty(loginVO)) {
			System.out.println("LoginInterceptor fail!! redirect to /javas/login/fail");
			System.out.println("현재 세션 있음 - 로그아웃 요청");
			response.sendRedirect("/javas/login/fail");
			return false;
		} else {
			System.out.println("LoginInterceptor success!!");
			System.out.println("현재 세션 없음");
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
