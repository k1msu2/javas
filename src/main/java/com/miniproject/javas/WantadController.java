package com.miniproject.javas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.WantReviewDAOImpl;
import dao.WantadDAOImpl;
import service.FTPService;
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
	@Autowired 
	FTPService ftpdownloader;
	@Autowired ServletContext context; 
	
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
	
	@ResponseBody
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
		String hostFolder = "\\memphoto\\";
		//String localDir = "C:\\Users\\student\\Documents\\webcache\\";
		String localDir = "C:\\Users\\KIMSUI\\Documents\\1_Study\\webcache\\";
		String resourceDir = context.getRealPath("/") + "resources\\images2\\";
		String fileName = "";
		
		File folder = new File(resourceDir);
		File[] listOfFiles = folder.listFiles();
		//System.out.println("listOfFiles: " + listOfFiles.toString());
		WantadVO vo = dao.listOne(id);		
		fileName = vo.getMem_userid();
		boolean flag = false;
		
		for (int i = 0; i < listOfFiles.length; i++) {
			System.out.println("listOfFiles: " + listOfFiles[i]);
			if (listOfFiles[i].getName().equals(fileName+".png")) {
				flag = true;
			}
		}
		
		if (!flag) {
			try {
				ftpdownloader.downloadFile(hostFolder, fileName, localDir);
				ftpdownloader.fileCopyToResource(resourceDir, localDir, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (vo.getPost_review_count() > 0) {
			List<WantReviewVO> list = rdao.listAll(id);
			System.out.println(list);
			mav.addObject("listReviewAll", list);
		}
	
		mav.addObject("listOne", vo);	
		mav.setViewName("wantadView");
		return mav;
	}
	
	@RequestMapping("/wantad/modify")
	public ModelAndView modify(int id) {
		WantadVO vo = dao.listOne(id);
		System.out.println(vo);
		ModelAndView mav = new ModelAndView();
		mav.addObject("listOne", vo);
		mav.setViewName("wantadmodify");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("/wantad/update")
	public String update(WantadVO vo){
		System.out.println("update   " + vo);
		if(dao.update(vo)){
			return "success";
		} else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("/wantad/deletepost")
	public String delete(int id) {
		// 리뷰도 삭제하고 글도 삭제하고 해야함
		// 현재는 글 삭제만 구현
		// 글만 삭제했을 경우
		// integrity constraint (JAVAS.FK_WANTREVIEW_POST_ID_WANTAD_P) violated - child record found 
		String result = "fail";
		if(rdao.delete(id)){
			result = "success";
		} else {
			result = "fail";
		}
		
		if(dao.delete(id)) {
			result = "success";
		}else {
			result = "fail";
		}

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/wantad/json",produces="applicaiton/json; charset=UTF-8")
	public String wantadjson() throws JsonProcessingException {
		String res = new ObjectMapper().writeValueAsString(dao.listAllLocation());
		System.out.println(res);
		return new ObjectMapper().writeValueAsString(dao.listAllLocation());
	}
}
