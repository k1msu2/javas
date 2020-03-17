package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import vo.LoginVO;

// 사장인지 확인하는 코드
// false : loginVO의 mem_is_employer == 1 아닌 경우
// true : loginVO의 mem_is_employer == 1 인 경우
@Component
public class AuthEmployerInterceptor implements HandlerInterceptor{

	// 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		System.out.println(loginVO);
			
		if(!ObjectUtils.isEmpty(loginVO)) {
			if(loginVO.getMem_is_employer() == 1) {
				System.out.println("AuthEmployerInterceptor success!");	
				System.out.println("사장 맞음. 알바생 접근 권한 없음");
				return true;
			}else {
				System.out.println("AuthEmployerInterceptor fail!");	
				System.out.println("사장 아님. 알바생은 접근 권한 없음");
				return false;
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
