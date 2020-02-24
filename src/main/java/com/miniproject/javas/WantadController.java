package com.miniproject.javas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.WantadMybatisDAO;
import vo.WantadVO;

@Controller
public class WantadController {
	@Autowired
	WantadMybatisDAO dao;
	
	@RequestMapping("/wantad")
	public ModelAndView wantad(WantadVO vo, String action)
	{
		System.out.println("============wantad dao========");
		ModelAndView mav = new ModelAndView();
		List<WantadVO> list = new ArrayList<>();
		list = dao.listAll();
		mav.addObject("listAll", list);
		mav.setViewName("wantad");
		System.out.println("controller: " + list);
		
		
		return mav;
	}
	
	@RequestMapping("/wantadform")
	public String wantform(WantadVO vo) {
		return "wantadform";
	}
	

}
