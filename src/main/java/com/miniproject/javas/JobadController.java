package com.miniproject.javas;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.JobadDAO2;
import dao.MeminfoDAO;
import service.FTPService;
import vo.JobadVO;
import vo.LoginVO;

@Controller
public class JobadController {
	@Autowired JobadDAO2 dao;
	@Autowired FTPService ftpdownloader;
	@Autowired ServletContext context; 
	@Autowired MeminfoDAO mdao;
	
	@RequestMapping(value="/jobad",method=RequestMethod.GET)
	public ModelAndView doGet(
	@RequestParam(value="action",required=false)String action,
	@RequestParam(defaultValue="1")int pgNum,
	@RequestParam(value="mem_username",required=false)String mem_username,
	@RequestParam(value="key",required=false)String key,
	@RequestParam(value="searchType",required=false)String searchType,
	@RequestParam(defaultValue="0")int post_id,
	HttpSession session){
		ModelAndView mav = new ModelAndView();
		List<JobadVO> list;
		int count = 0;
		String linkStr = "";
		if(action==null) {
			list = dao.listAll(pgNum);
			session.setAttribute("pgNum", pgNum);
			System.out.println("pgNum : "+pgNum);
			mav.addObject("msg","援ъ씤 寃뚯떆�뙋");
			if(list!=null && list.size()!=0) {
				mav.addObject("list",list);
			}
			count = dao.getCount();

	
			String hostFolder = "\\memphoto\\";
			//String localDir = "C:\\Users\\student\\Documents\\webcache\\";
			String localDir = "C:\\Users\\KIMSUI\\Documents\\1_Study\\webcache\\";
			String resourceDir = context.getRealPath("/") + "resources\\images2\\";
			System.out.println(resourceDir);
			String fileName = "";
						
			for (JobadVO vo : list) {
				//fileName = "ddochi9";
				fileName = vo.getMem_userid();
				//리소스 폴더에 없는 경우만 ftp 서버에서 다운로드
				//웹서버 동기화 용도
				// meminfo 객체의 memphoto 확인
				try {
					ftpdownloader.downloadFile(hostFolder, fileName, localDir);
					ftpdownloader.fileCopyToResource(resourceDir, localDir, fileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}			
			//ftpdownloader.disconnect(); // 프로젝트 종료시..처리아직 못함.
		}
		else if(action.equals("sort")) {
			list = dao.listSort(key, pgNum);
			mav.addObject("msg","援ъ씤 由ъ뒪�듃("+key+"�젙�젹)");
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
				mav.addObject("msg","援ъ씤 �궡�슜");
				mav.addObject("vo",vo);
			}
		}
		else if(action.equals("listWriter")) {
			list = dao.listWriter(mem_username, pgNum);
			mav.addObject("msg","援ъ씤 寃뚯떆�뙋");
			if(list!=null && list.size()!=0) {
				mav.addObject("list",list);
				count = dao.getCount(mem_username);
				linkStr = "&action=listwriter&mem_username="+mem_username;
				
			}
		}
		else if(action.equals("search")) {
			list = dao.search(key, searchType, pgNum);
			if(list!=null && list.size()!=0) {
				mav.addObject("msg",key+"�쓣(瑜�) �룷�븿�븯�뒗 湲� 由ъ뒪�듃");
				mav.addObject("list",list);
				count = dao.getCount(key, searchType);
				linkStr = "&searchType="+searchType+"&key="+key+"&action=search";
			}
			else {
				mav.addObject("snull",key+"�쓣 �룷�븿�븯�뒗 寃��깋湲��씠 �뾾�뒿�땲�떎.");
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
	
}
