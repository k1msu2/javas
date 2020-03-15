package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import vo.LoginVO;

// 알바인지 확인하는 코드
// true : loginVO의 mem_is_employer == 1 아닌 경우
// false : loginVO의 mem_is_employer == 1 인 경우
@Component
public class AuthEmployeeInterceptor implements HandlerInterceptor{

	// 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		System.out.println(loginVO);
	
		if(!ObjectUtils.isEmpty(loginVO)) {
			if(loginVO.getMem_is_employer() == 1) {
				System.out.println("AuthEmployeeInterceptor fail!!");	
				System.out.println("알바 아님. 사장 접근권한 없음");
				response.sendRedirect("/javas/authfail");
				return false;
			}else {
				System.out.println("AuthEmployeeInterceptor success!!");	
				System.out.println("알바 맞음. 사장 접근권한 없음");
				return true;
			}
			
		} else {
			response.sendRedirect("/");
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
