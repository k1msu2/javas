package com.miniproject.javas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.MeminfoDAO;
import dao.WantReviewDAOImpl;
import service.FTPService;
import vo.LoginVO;
import vo.MeminfoVO;

@Controller
public class MypageController {
	@Autowired
	MeminfoDAO dao;
	@Autowired
	FTPService ftpUploader;
	@Autowired
	ServletContext context; 
	@Autowired
	WantReviewDAOImpl wrdao;
	
	@RequestMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		mav.addObject("loginVO", vo1);
		mav.setViewName("mypage");
		return mav;
	}

	@RequestMapping("/meminfomodify")
	public ModelAndView modifymeminfo(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		mav.addObject("loginVO", vo1);
		mav.setViewName("meminfomodify");
		return mav;
	}

	@RequestMapping("/meminfoupdate")
	public String meminfoupdate(MeminfoVO vo, HttpSession session) {
		System.out.println("meminfoupdate");
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		
	    boolean result = dao.update(vo);
		if (result) {
			System.out.println("수정 성공");
			String mem_photo = vo.getMem_photo();
			vo1.setMem_password(vo.getMem_password());
			vo1.setMem_email(vo.getMem_email());
			vo1.setMem_phone(vo.getMem_phone());
			vo1.setMem_address(vo.getMem_address());
			vo1.setMem_register_date(vo.getMem_register_date());
			vo1.setMem_photo(vo.getMem_photo());
			vo1.setMem_is_employer(vo.getMem_is_employer());
			MultipartFile uploadFile = vo.getUploadFile();
			System.out.println("uploadFile : "+uploadFile);
			System.out.println("name : "+uploadFile.getOriginalFilename());
			System.out.println(mem_photo);
			String fileName = vo.getMem_userid();
			byte[] content = null;
			try {
				if (!vo.getUploadFile().isEmpty()) { // ok!
					content = vo.getUploadFile().getBytes();
					String path = context.getRealPath("/") + "resources/images2/" + fileName + ".png";
					System.out.println(path);
					File f = new File(path);
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(content);
					fos.close();

					// ftp 회원 사진 업로드
					ftpUploader.uploadFile(path, fileName, "/memphoto/");
					ftpUploader.disconnect();
					vo.setMem_photo(fileName);
				} else {

				}
			}		
			catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println(vo);
			session.setAttribute("msg1", "수정되었습니다.");
			session.setAttribute("loginVO", vo1);
		} else {
			System.out.println("수정 실패");
			return "modifyError";
		}
		return "mypage";
	}
	
	@RequestMapping("/myreviews")
	public ModelAndView myreviews(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		LoginVO vo1 = (LoginVO) session.getAttribute("loginVO");
		System.out.println(vo1.getMem_is_employer());
		if(vo1.getMem_is_employer()==1) {
			mav.addObject("listReviewAll", wrdao.listAll(vo1.getMem_userid()));
		} else {
			mav.addObject("listReviewAll", wrdao.listAll(vo1.getMem_userid()));
		}
		
		mav.setViewName("myreviews");
		return mav;
	}
}
