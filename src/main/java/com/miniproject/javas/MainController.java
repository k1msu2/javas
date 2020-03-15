package com.miniproject.javas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping({"/","main"})
	public String first() {
		return "main";
	}
}
