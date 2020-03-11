package com.miniproject.javas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

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

	@ResponseBody
	@RequestMapping("/wantreviewinsert")
	public String insert(WantReviewVO vo) throws Exception{

		ObjectMapper mapper = new ObjectMapper();

		if (dao.insert(vo)) {
			System.out.println("삽입 성공");
		}
		
		String jsonString = mapper.writeValueAsString(vo);
		System.out.println(jsonString);
		return jsonString;
	}

	@ResponseBody
	@RequestMapping("/wantreviewdelete")
	public String delete(int id) {
		System.out.println(id);
		if (dao.delete(id)) {
			System.out.println("삭제 성공");
		}
		return "success";
	}
}
