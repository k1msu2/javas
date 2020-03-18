package com.miniproject.javas;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.JobadDAO2;
import vo.JobadVO;
import vo.LoginVO;

@Controller
public class JobadController {
	@Autowired JobadDAO2 dao;
	@RequestMapping(value="/jobad",method=RequestMethod.GET)
	public ModelAndView doGet(
	@RequestParam(value="action",required=false)String action,
	@RequestParam(defaultValue="1")int pgNum,
	@RequestParam(value="mem_username",required=false)String mem_username,
	@RequestParam(value="key",required=false)String key,
	@RequestParam(value="searchType",required=false)String searchType,
	@RequestParam(defaultValue="0")int post_id,
	HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<JobadVO> list;
		int count = 0;
		String linkStr = "";
		if(action==null) {
			list = dao.listAll(pgNum);
			session.setAttribute("pgNum", pgNum);
			System.out.println("pgNum : "+pgNum);
			mav.addObject("msg","구인 게시판");
			if(list!=null && list.size()!=0) {
				mav.addObject("list",list);
			}
			count = dao.getCount();
		}
		else if(action.equals("sort")) {
			list = dao.listSort(key, pgNum);
			mav.addObject("msg","구인 리스트("+key+"정렬)");
			if(list!=null && list.size()!=0) {
				mav.addObject("list",list);
			}
			count = dao.getCount();
			linkStr = "&action=sort&key="+key;
		}
		else if(action.equals("listone")) {
			JobadVO vo = dao.listOne(post_id);
			if(vo!=null) {
				session.setAttribute("vo", vo);
				mav.addObject("msg","구인 내용");
				mav.addObject("vo",vo);
			}
		}
		else if(action.equals("listWriter")) {
			list = dao.listWriter(mem_username, pgNum);
			mav.addObject("msg","구인 게시판");
			if(list!=null && list.size()!=0) {
				mav.addObject("list",list);
				count = dao.getCount(mem_username);
				linkStr = "&action=listwriter&mem_username="+mem_username;
				
			}
		}
		else if(action.equals("search")) {
			list = dao.search(key, searchType, pgNum);
			if(list!=null && list.size()!=0) {
				mav.addObject("msg",key+"을(를) 포함하는 글 리스트");
				mav.addObject("list",list);
				count = dao.getCount(key, searchType);
				linkStr = "&searchType="+searchType+"&key="+key+"&action=search";
			}
			else {
				mav.addObject("snull",key+"을 포함하는 검색글이 없습니다.");
			}
		}
		else if(action.equals("delete")) {
			dao.delete(post_id);
			System.out.println("action : "+action);
			mav.setViewName("redirect:http://localhost:8000/javas/jobad?pgNum="+session.getAttribute("pgNum"));
			return mav;
		}
		
		mav.addObject("totalCount",count);
		mav.addObject("pagelist",new JobadDAO2().getPageLinkList(pgNum, linkStr, count));
		mav.addObject("pgNum",pgNum);
		mav.setViewName("jobadView");
		return mav;
	}
	@RequestMapping(value= {"/jobad"},method=RequestMethod.POST)
	public String doPost(@RequestParam("action")String action,
	@RequestParam(defaultValue="0")int post_id,
	@ModelAttribute("vo")JobadVO vo,
	HttpSession session) {
		LoginVO vo1 = (LoginVO)session.getAttribute("loginVO");
		vo.setMem_userid(vo1.getMem_userid());
		vo.setMem_username(vo1.getMem_username());
		if(action.equals("insert")) {
			dao.insert(vo);
		}
		else if(action.equals("update")) {
			dao.update(vo);
		}
		return "redirect:http://localhost:8000/javas/jobad?pgNum="+session.getAttribute("pgNum");
	}
	
	@RequestMapping({"jobadinsert"})
	public String one() {
		return "jobadinsertForm";
	}
	
	@RequestMapping({"jobadupdate"})
	public String two() {
		return "jobadUpdateForm";
	}
	
}
