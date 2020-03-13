package com.miniproject.javas;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MeminfoDAO;
import dao.WantReviewDAOImpl;
import dao.WantadDAOImpl;
import vo.LoginVO;
import vo.MeminfoVO;

@Controller
public class MypageController {
	@Autowired
	MeminfoDAO dao;
	
	@Autowired
	WantReviewDAOImpl wrdao;
	
	@RequestMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		mav.addObject("loginVO", vo1);
		mav.setViewName("mypage");
		return mav;
	}

	@RequestMapping("/meminfomodify")
	public ModelAndView modifymeminfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		mav.addObject("loginVO", vo1);
		mav.setViewName("meminfomodify");
		return mav;
	}

	@RequestMapping("/meminfoupdate2")
	public String meminfoupdate(MeminfoVO vo) {
		if (dao.update(vo)) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		return "redirect:mypage";
	}
	
	@RequestMapping("/myreviews")
	public ModelAndView myreviews(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		System.out.println(vo1.getMem_is_employer());
		if(vo1.getMem_is_employer()==1) {
			mav.addObject("listReviewAll", wrdao.listAll(vo1.getMem_userid()));
		} else {
			mav.addObject("listReviewAll", wrdao.listAll(vo1.getMem_userid()));
		}
		
		mav.setViewName("myreviews");
		return mav;
	}
}
