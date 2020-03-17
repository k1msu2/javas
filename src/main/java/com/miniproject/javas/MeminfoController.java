package com.miniproject.javas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.MeminfoDAO;
import vo.MeminfoVO;

@Controller
public class MeminfoController {
	@Autowired
	MeminfoDAO dao;
	
	@RequestMapping("/meminfo")
	public String meminfo() {
		return "meminfo";
	}
	@RequestMapping(value = "/meminfoinsert", method = RequestMethod.POST)
	public ModelAndView meminfoinsert(MeminfoVO vo, String action) {
		//System.out.println("?");
		ModelAndView mav = new ModelAndView();
		List<MeminfoVO> list = null;
		String mem_userid = vo.getMem_userid();
		String mem_password = vo.getMem_password();
		String mem_username = vo.getMem_username();
		String mem_email = vo.getMem_email();
		String mem_birthday = vo.getMem_birthday();
		String mem_sex = vo.getMem_sex();
		String mem_phone = vo.getMem_phone();
		String mem_address = vo.getMem_address();
		String mem_register_date = vo.getMem_register_date();
		String mem_photo = vo.getMem_photo();
		int mem_is_employer = vo.getMem_is_employer();
		
		System.out.println(mem_photo);
		mav.addObject("mem_userid", mem_userid);
		mav.addObject("mem_password", mem_password);
		mav.addObject("mem_username", mem_username);
		mav.addObject("mem_email", mem_email);
		mav.addObject("mem_birthday", mem_birthday);
		mav.addObject("mem_sex", mem_sex);
		mav.addObject("mem_phone", mem_phone);
		mav.addObject("mem_address", mem_address);
		mav.addObject("mem_photo", mem_photo);
		mav.addObject("mem_register_date", mem_register_date);
		mav.addObject("mem_is_employer", mem_is_employer);
		
		boolean result = dao.insert(vo);
		System.out.println(vo);
		if (result) {
			mav.addObject("msg", "회원가입 되었습니다.");
			mav.addObject("list", list);

		} else {
			mav.addObject("msg", "Error : 회원가입 실패");
			mav.addObject("list", list);
		}
		mav.addObject("list", dao.listAll());
		mav.setViewName("meminfoview");
		return mav;
	}
	
	@RequestMapping(value = "/newsdelete", method = RequestMethod.GET)
	public ModelAndView newsdelete(MeminfoVO vo, String action) {
		ModelAndView mav = new ModelAndView();
		List<MeminfoVO> list = null;
		String mem_userid = vo.getMem_userid();
	
		boolean result = dao.delete(mem_userid);
		if (result) {
			mav.addObject("msg", "탈퇴되었습니다.");
			mav.addObject("list", list);

		} else {
			mav.addObject("msg", "Error : 탈퇴 실패");
			mav.addObject("list", list);
		}
		mav.addObject("list", dao.listAll());
		mav.setViewName("meminfo");
		return mav;
	}
	
}
 
	



