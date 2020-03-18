package com.miniproject.javas;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.WantReviewDAOImpl;
import dao.WantadDAOImpl;
import vo.JobadVO;
import vo.LoginVO;
import vo.PageVO;
import vo.WantReviewVO;
import vo.WantSearchVO;
import vo.WantadVO;

@Controller
public class WantadController {
	@Autowired
	WantadDAOImpl dao;

	@Autowired
	WantReviewDAOImpl rdao;
	
	@RequestMapping("/wantad")
	public ModelAndView wantad2(WantadVO vo, 
			WantSearchVO svo, @RequestParam(defaultValue = "1") int page) {

		ModelAndView mav = new ModelAndView();
		List<WantadVO> list = new ArrayList<>();

		PageVO pvo = dao.pagination(page, svo);
		list = dao.listAll(pvo, svo);

		mav.addObject("listAll", list);
		mav.addObject("pageVO", pvo);
		mav.addObject("searchVO", svo);

		mav.setViewName("wantad");
		return mav;
	}

	@RequestMapping("/wantad/all")
	public ModelAndView wantad(WantadVO vo) {
		ModelAndView mav = new ModelAndView();
		List<WantadVO> list = new ArrayList<>();
		list = dao.listAll();
		mav.addObject("listAll", list);
		mav.setViewName("wantad");
		System.out.println("controller: " + list);
		return mav;
	}

	@RequestMapping("/wantad/form")
	public String form(WantadVO vo) {

		return "wantadform";
	}

	@RequestMapping("/wantad/insert1")
	public ModelAndView insert(WantadVO vo) {
		// System.out.println(vo);
		dao.insert(vo);

		ModelAndView mav = new ModelAndView();
		mav.addObject("listAll", dao.listAll());
		mav.setViewName("wantad");
		return mav;
	}

	@RequestMapping("/wantad/insert2")
	public ModelAndView insert2(WantadVO vo,
			@RequestParam(defaultValue = "1") int page) {
		
	
		ModelAndView mav = new ModelAndView();
		List<WantadVO> list = new ArrayList<>();
		PageVO pvo = dao.pagination(1);
		
		if(dao.insert(vo)) {
			list = dao.listAll(pvo);
			mav.addObject("listAll", list);
			mav.addObject("pageVO", pvo);
		}else {
			System.out.println("등록 실패");
		}
		mav.setViewName("redirect:wantad");

		return mav;
	}
	
	@RequestMapping("/wantad/insert")
	public String insert3(WantadVO vo) {
		System.out.println("insert" + vo);
		
		if(dao.insert(vo)) {
			return "success";
		}else {
			return "fail";
		}	
	}
	
	@RequestMapping("/wantad/view")
	public ModelAndView read(int id) {
		ModelAndView mav = new ModelAndView();
		WantadVO vo = dao.listOne(id);
		mav.addObject("listOne", vo);
		if (vo.getPost_review_count() > 0) {
			List<WantReviewVO> list = rdao.listAll(id);
			System.out.println(list);
			mav.addObject("listReviewAll", list);
		}
		mav.setViewName("wantadView");
		return mav;
	}
	
	@RequestMapping("/wantad/modify")
	public ModelAndView modify(WantadVO vo) {
		System.out.println(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("listOne", vo);
		mav.setViewName("wantadmodify");
		return mav;
	}
	
	@RequestMapping("/wantad/update")
	public String update(WantadVO vo){
		if(dao.update(vo)){
			return "success";
		} else {
			return "fail";
		}
	}
	@RequestMapping("/wantad/delete")
	public String delete(WantadVO vo) {
		// 리뷰도 삭제하고 글도 삭제하고 해야함
		// 현재는 글 삭제만 구현
		if(dao.delete(vo.getPost_id())){
			return "success";
		} else {
			return "fail";
		}
	}
	
}
