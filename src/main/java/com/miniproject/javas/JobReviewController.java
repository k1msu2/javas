package com.miniproject.javas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.JobReviewDAOImpl;
import vo.JobReviewVO;

@Controller
public class JobReviewController{
	@Autowired
	JobReviewDAOImpl dao;
	@ResponseBody
	@RequestMapping("/jobreview")
	public String jobreview(int post_id) throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(dao.listAll(post_id));
	}
	@ResponseBody
	@RequestMapping("/jobreview{action}")
	public String insert(JobReviewVO vo,@PathVariable("action") String action,
			@RequestParam(value="review_id",defaultValue="0")int review_id,
			@RequestParam(value="post_id",defaultValue="0")int post_id){
		if(action.equals("insert")) {
			dao.insert(vo);
		}
		else if(action.equals("update")) {
			dao.update(vo);
		}
		else if(action.equals("delete")) {
			dao.delete(review_id);
		}
		return "redirect:http://localhost:8000/javas/jobad?action=listone&post_id="+post_id;
	}
	/*
	@ResponseBody
	@RequestMapping("/jobreviewupdate")
	public String update(JobReviewVO vo) {
		if(dao.update(vo)) {
			return "success";
		}
		else {
			return "fail";
		}
	}
	@ResponseBody
	@RequestMapping("/jobreviewdelete")
	public String delete(int review_id) {
		System.out.println("delete!! : "+review_id);
		if(dao.delete(review_id)) {
			return "success";
		}
		else {
			return "fail";
		}
	}
	*/
}
