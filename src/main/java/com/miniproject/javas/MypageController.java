package com.miniproject.javas;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vo.LoginVO;

@Controller
public class MypageController {
	@RequestMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO)session.getAttribute("loginVO");
		mav.addObject("loginVO", vo1);
		mav.setViewName("mypage");
		return mav;		
	}
}
