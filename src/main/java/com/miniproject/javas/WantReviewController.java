package com.miniproject.javas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.WantReviewDAOImpl;
import vo.WantReviewVO;

@Controller
public class WantReviewController{
	@Autowired
	WantReviewDAOImpl dao;

	@ResponseBody
	@RequestMapping(value="/wantreview",produces="applicaiton/json; charset=UTF-8")
	public String wantreview(int post_id) throws Exception{
		return new ObjectMapper().writeValueAsString(dao.listAll(post_id));
	}

	@ResponseBody
	@RequestMapping(value="/wantreviewinsert",produces="applicaiton/json; charset=UTF-8")
	public String insert(WantReviewVO vo) {
		if (dao.insert(vo)) return "success";
		else return "fail";
	}

	@ResponseBody
	@RequestMapping(value="/wantreviewdelete",produces="applicaiton/json; charset=UTF-8")
	public String delete(int review_id) {
		if (dao.delete(review_id)) return "success";
		else return "fail";
	}
}
