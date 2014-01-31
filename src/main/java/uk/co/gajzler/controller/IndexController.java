package uk.co.gajzler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	@RequestMapping("/index")
	public String goToIndex(){
		return "index";
	}
	
	@RequestMapping("error404")
	public String error404(){
		return "error404";
	}
}
