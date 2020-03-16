package com.miniproject.javas;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.LoginDAO;
import vo.LoginVO;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout")
	public String doPost(HttpSession session) {
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");
		if(loginVO != null) {
			session.removeAttribute("loginVO");
		}
		return "logoutsuccess";
	}
	
	@RequestMapping(value="/logout/fail")
	public String logoutfail() {
		return "logoutfail";
	}
	
	@RequestMapping(value="/logout/success")
	public String logoutsuccess() {
		return "logoutsuccess";
	}
}
