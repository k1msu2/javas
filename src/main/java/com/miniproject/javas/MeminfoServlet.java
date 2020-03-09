package com.miniproject.javas;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MeminfoDAO;
import vo.MeminfoVO;

@WebServlet("/meminfo")
public class MeminfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//GET 방식으로 delete 구현. 맞는지는 잘 모르겠습니다.
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			String action = request.getParameter("action");
			String memUserid = request.getParameter("memUserid");
			MeminfoDAO dao = new MeminfoDAO();
			
			if (action != null) {
			if(action.equals("delete")) {
				dao.delete(memUserid);
			}} else {
				List<MeminfoVO> list = dao.listAll();
				for (MeminfoVO vo : list) {
					System.out.println(vo.getMem_userid());
					System.out.println(vo.getMem_password());
					System.out.println(vo.getMem_username());
					System.out.println(vo.getMem_email());
					System.out.println(vo.getMem_birthday());
					System.out.println(vo.getMem_sex());
					System.out.println(vo.getMem_phone());
					System.out.println(vo.getMem_address());
					System.out.println(vo.getMem_register_date());
					System.out.println(vo.getMem_photo());
					System.out.println(vo.getMem_is_employer());
				}
				request.setAttribute("list", list);
			}
			request.setAttribute("list", dao.listAll());
			request.getRequestDispatcher("/meminfo.jsp").forward(request, response);	
		}
		
		//POST 방식으로 insert와 update 구현. 맞는지는 잘 모르겠습니다.
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			String action = request.getParameter("action");
			String mem_userid = request.getParameter("mem_userid");
			String mem_password = request.getParameter("mem_password");
			String mem_username = request.getParameter("mem_username");
			String mem_email = request.getParameter("mem_email");
			String mem_birthday = request.getParameter("mem_birthday");
			String mem_sex = request.getParameter("mem_sex");
			String mem_phone = request.getParameter("mem_phone");
			String mem_address = request.getParameter("mem_address");
			String mem_register_date = request.getParameter("mem_register_date");
			String mem_photo = request.getParameter("mem_photo");
			int mem_is_employer = Integer.parseInt(request.getParameter("mem_is_employer").trim());
		    MeminfoDAO dao = new MeminfoDAO();
		    MeminfoVO vo = new MeminfoVO();
		    vo.setMem_userid(mem_userid);
		    vo.setMem_password(mem_password);
		    vo.setMem_username(mem_username);
		    vo.setMem_email(mem_email);
		    vo.setMem_birthday(mem_birthday);
		    vo.setMem_sex(mem_sex);
		    vo.setMem_phone(mem_phone);
		    vo.setMem_address(mem_address);
		    vo.setMem_register_date(mem_register_date);
		    vo.setMem_phone(mem_phone);
		    vo.setMem_is_employer(mem_is_employer);
		    
		    if(action.equals("insert")) {
		    	boolean result = dao.insert(vo);
		    	System.out.println(vo);
		    } else if(action.equals("update")) {
		    	vo.setMem_userid(request.getParameter("mem_userid"));
		    	boolean result = dao.update(vo);
		    }
			request.setAttribute("list", dao.listAll());
			request.getRequestDispatcher("/meminfo.jsp").forward(request, response);
		}
}
 
	



