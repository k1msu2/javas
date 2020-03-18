package com.miniproject.javas;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.MeminfoDAO;
import dao.WantReviewDAOImpl;
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

	@RequestMapping("/meminfoupdate")
	public String meminfoupdate(MeminfoVO vo, HttpSession session) {

		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		
	    boolean result = dao.update(vo);
		if (result) {
			System.out.println("수정 성공");
			vo1.setMem_password(vo.getMem_password());
			vo1.setMem_email(vo.getMem_email());
			vo1.setMem_phone(vo.getMem_phone());
			vo1.setMem_address(vo.getMem_address());
			vo1.setMem_register_date(vo.getMem_register_date());
			vo1.setMem_photo(vo.getMem_photo());
			vo1.setMem_is_employer(vo.getMem_is_employer());
			System.out.println(vo);
			session.setAttribute("msg1", "수정되었습니다.");
			session.setAttribute("loginVO", vo1);
		} else {
			System.out.println("수정 실패");
			return "modifyError";
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
