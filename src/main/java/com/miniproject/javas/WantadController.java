package com.miniproject.javas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.WantReviewDAOImpl;
import dao.WantadDAOImpl;
import vo.PageVO;
import vo.WantReviewVO;
import vo.WantadVO;

@Controller
public class WantadController {
	@Autowired
	WantadDAOImpl dao;

	@Autowired
	WantReviewDAOImpl rdao;

	@RequestMapping("/wantad")
	public ModelAndView wantad2(WantadVO vo, @RequestParam(defaultValue = "1") int page) {

		System.out.println("============wantad dao========");
		ModelAndView mav = new ModelAndView();
		List<WantadVO> list = new ArrayList<>();

		PageVO pvo = dao.pagination(page);
		list = dao.listAll(pvo);

		mav.addObject("listAll", list);
		mav.addObject("pageVO", pvo);

		mav.setViewName("wantad");
		return mav;
	}

	@RequestMapping("/wantadall")
	public ModelAndView wantad(WantadVO vo) {
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
	public String form(WantadVO vo) {

		return "wantadform";
	}

	@RequestMapping("/wantadinsert")
	public ModelAndView insert(WantadVO vo) {
		// System.out.println(vo);
		dao.insert(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("listAll", dao.listAll());
		mav.setViewName("/wantad");
		return mav;
	}

	@RequestMapping("/readwantad")
	public ModelAndView read(int id) {
		ModelAndView mav = new ModelAndView();
		WantadVO vo = dao.listOne(id);
		mav.addObject("listOne", vo);
		System.out.println(vo);
		if (vo.getPost_review_count() > 0) {
			List<WantReviewVO> list = rdao.listAll(id);
			System.out.println(list);
			mav.addObject("listReviewAll", list);
		}
		mav.setViewName("/readwantad");
		return mav;
	}


}
