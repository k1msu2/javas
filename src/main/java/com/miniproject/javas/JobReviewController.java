package com.miniproject.javas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.JobReviewDAOImpl;
import vo.JobReviewVO;

@Controller
public class JobReviewController{
	@Autowired
	JobReviewDAOImpl dao;

	@ResponseBody
	@RequestMapping("/jobreview")
	public String jobreview(int post_id) throws Exception{
		return new ObjectMapper().writeValueAsString(dao.listAll(post_id));
	}

	@ResponseBody
	@RequestMapping("/jobreviewinsert")
	public String insert(JobReviewVO vo) {
		if (dao.insert(vo)) return "success";
		else return "fail";
	}

	@ResponseBody
	@RequestMapping("/jobreviewdelete")
	public String delete(int review_id) {
		if (dao.delete(review_id)) return "success";
		else return "fail";
	}
}
