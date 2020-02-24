package com.miniproject.javas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.JobadDAO;
import vo.JobadVO;

@Controller
public class JobadController {
	@Autowired JobadDAO dao;
	//게시판 리스트 출력하는 메서드
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public ModelAndView listAll(Integer pgNum) {
		//curPage로 아무것도 전달 안되면 page=1
		int page = 1;
		if(pgNum!=null) {
			page = pgNum;
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewlist", dao.listAll(page));
		mav.setViewName("Jobad");
		return mav;
	}
	//게시판 글 하나를 출력하는 메서드
	@RequestMapping(value = "/listOne", method = RequestMethod.GET)
	public ModelAndView listOne(int post_id) {
		ModelAndView mav = new ModelAndView();
		JobadVO vo = dao.listOne(post_id);
		vo.setPost_id(vo.getPost_id()+1);
		dao.update(vo);
		mav.addObject("view", vo);
		//다른 페이지로 넘어간다.
		mav.setViewName("OneJobad");
		return mav;
	}
	//작성자의 작성 글을 출력하는 메서드, 현재 페이지도 전달한다.
	@RequestMapping(value = "/listWriter", method = RequestMethod.GET)
	public ModelAndView listWriter(String writer,Integer pgNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewlist", dao.listWriter(writer,pgNum));
		mav.setViewName("Jobad");
		return mav;
	}
	//검색 타입에 따라 글을 출력하는 메서드, 현재 페이지도 전달한다.
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(String searchType,String key,Integer pgNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("viewlist",dao.search(searchType,key,pgNum));
		mav.setViewName("Jobad");
		return mav;
	}
	//id값으로 게시판 글을 삭제하는 메서드
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(int post_id,Integer pgNum) {
		ModelAndView mav = new ModelAndView();
		dao.delete(post_id);
		mav.addObject("viewlist", dao.listAll(pgNum));
		mav.setViewName("Jobad");
		return mav;
	}
	//작성자가 입력한 내용으로 새 글을 작성하는 메서드
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(JobadVO vo,Integer pgNum) {
		ModelAndView mav = new ModelAndView();
		dao.insert(vo);
		mav.addObject("viewlist",dao.listAll(pgNum));
		mav.setViewName("Jobad");
		return mav;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("view")JobadVO vo,Integer pgNum) {
		ModelAndView mav = new ModelAndView();
		dao.update(vo);
		mav.addObject("viewlist",dao.listAll(pgNum));
		mav.setViewName("Jobad");
		return mav;
	}
}
