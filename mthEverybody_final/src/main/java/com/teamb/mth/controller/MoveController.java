package com.teamb.mth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MoveController {
	
	@RequestMapping("/")
	public String move() { 
		return "redirect:/mainPage";
	}
	
	@RequestMapping("/commons/about")
	public String about() {
		return "/commons/about";
	}

	@RequestMapping("/commons/services")
	public String service() {
		return "/commons/services";
	}

	@RequestMapping("/commons/contact")
	public String contact() {
		return "/commons/contact";
	}
	
	@RequestMapping("writeReportForm")
	public String writeReportForm() {
		return "/popup/writeReportForm";
	}
	
	@RequestMapping("aroundConvenience")
	public String aroundConvenience() {
		return "/customer/aroundConvenience";
	}
	
	@RequestMapping("joinMemberForm")
	public String joinMemberForm() {
		return "/joinMemberForm";
	}

	@RequestMapping("requestSellerForm")
	public String requestSellerForm() {
		return "/customer/requestSellerForm";
	}
	
	@RequestMapping("/commons/errorpage404")
	public String errorpage404() {
		return "/commons/errorpage404";
	}
	
	@RequestMapping("/commons/errorpage500")
	public String errorpage500(Model model) 
	{
		model.addAttribute("message", "오류(500)가 발생하였습니다. 관리자에게 문의바랍니다.");
		model.addAttribute("page", "mainPage");
		
		return "/message";
	}
}
