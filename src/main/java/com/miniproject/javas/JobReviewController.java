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

import dao.JobReviewDAOImpl;
import vo.JobReviewVO;
import vo.LoginVO;

@Controller
public class JobReviewController{
	@Autowired
	JobReviewDAOImpl dao;
	@RequestMapping(value="/jobreview1")
	public ModelAndView doGet(@RequestParam(value="action",required=false)String action,
	@RequestParam(defaultValue="1")int curPage,
	@RequestParam(defaultValue="0")int post_id,
	@RequestParam(defaultValue="0")int review_id,
	HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List<JobReviewVO> list = null;
		int count = 0;
		String linkStr = "";
		if(action==null) {
			list = dao.listAll(post_id,curPage);
			session.setAttribute("pgNum",curPage);
			if(list!=null && list.size()!=0) {
				mav.addObject("list",list);
			}
			count = dao.getCount();
		}
		else if(action.equals("delete")) {
			dao.delete(review_id);
			mav.setViewName("redirect:http://localhost:8000/javas/jobreview?pgNum="+session.getAttribute("curPage"));
			return mav;
		}
		mav.addObject("totalCount",count);
		mav.addObject("pagelist",new JobReviewDAOImpl().getPageLinkList(curPage, linkStr, count));
		mav.addObject("pgNum",curPage);
		mav.setViewName("jobreviewView");
		return mav;
	}
	@RequestMapping(value="/jobreview2")
	public String doPost(@RequestParam("action")String action,
	@RequestParam(value="review_id",defaultValue="0")int review_id,
	@ModelAttribute("vo")JobReviewVO vo,
	HttpSession session) {
		LoginVO vo1 = (LoginVO)session.getAttribute("loginVO");
		vo.setReview_userid(vo1.getMem_userid());
		if(action.equals("insert")) {
			dao.insert(vo);
		}
		else if(action.equals("update")) {
			dao.update(vo);
		}
		return "redirect:http://localhost:8000/javas/jobreview?pgNum="+session.getAttribute("curPage");
	}
}
