package com.miniproject.javas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.WantReviewDAOImpl;
import vo.WantReviewVO;

@Controller
public class WantReviewController {
	@Autowired
	WantReviewDAOImpl dao;
	
	@RequestMapping("/wantreview")
	public ModelAndView wantreview(WantReviewVO vo) {
		
		ModelAndView mav = new ModelAndView();
		List<WantReviewVO> list = new ArrayList<>();
		
		mav.addObject("listReviewAll", list);
		mav.setViewName("readwantad");
		return mav;
		
	}
	
	@RequestMapping("/wantreviewinsert")
	public ModelAndView insert(WantReviewVO vo) {
		System.out.println(vo);
		//dao.insert(vo);
		ModelAndView mav = new ModelAndView();
		//mav.addObject("listReviewAll", dao.listAll());
		//mav.setViewName("readwantad");
		return mav;
	}
	
}
