package com.cat.web.member.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.mrhi.bsm.model.item.ItemVO;
import com.cat.web.member.service.MemberService;
import com.cat.web.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	
	/*
	 * 회원가입
	 */
	
	@RequestMapping(value="/checkID")
	@ResponseBody
	public String checkID(@ModelAttribute MemberVO vo, HttpServletRequest request) {
		System.out.println(vo.toString());
		int checkID = memberService.checkID(vo);
		return checkID + "";
	}

	@RequestMapping(value="/join")
	public String join(MemberVO vo) {
		System.out.println(vo.toString());
		memberService.insertUser(vo);
		return "join.jsp";
	}
	
	/*
	 * 로그인
	 */
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(HttpSession session) {
		session.invalidate();
		return "main.jsp";
	}
	

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginView(@ModelAttribute MemberVO vo) {
		System.out.println("로그인 화면으로 이동");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO vo, HttpSession session) {
		System.out.println(vo.toString());
		MemberVO member = memberService.LogIn(vo);
		System.out.println("member" + member.toString());
		if(member.getId() != null) {
			session.setAttribute("MemberVO2", member);
			System.out.println("로그인 성공");
		}
		return "redirect:/main.jsp";
	}
	
	/*
	 * 회원 정보
	 */
	
	@RequestMapping(value="/getMemberList")
	public String getMemberList(@ModelAttribute MemberVO vo, Model model) {
		System.out.println("회원 리스트 보기 전");		
		List<MemberVO> memberList = memberService.getUserList(vo);
		model.addAttribute("MemberList", memberList);
		System.out.println("회원 리스트 보기 성공");
		return "adminUser.jsp";
	}
	
	@RequestMapping(value="/updateInfo", method=RequestMethod.GET)
	public String updateInfo() {
		return "updateMyInfo.jsp";
	}
	
	@RequestMapping(value="/updateInfo", method=RequestMethod.POST)
	public String updateInfo(@ModelAttribute MemberVO vo, HttpSession session) {
		System.out.println(vo.toString());
		memberService.updateInfo(vo);
		MemberVO Member = memberService.getMyInfo(vo);
		session.setAttribute("MemberVO2", Member);
		return "getMyInfo";
	}
	
	@RequestMapping(value="/deleteMember")
	public String deleteMember(@ModelAttribute MemberVO vo, HttpSession session) {
		System.out.println("회원 탈퇴 전");
		memberService.deleteUser(vo);
		session.invalidate();
		System.out.println("회원 탈퇴 성공");
		return "login.jsp";
	}
	
	@RequestMapping(value="/getMyInfo")
	public String getMyInfo(HttpSession session) {
		System.out.println("내 정보 보기 전");
		MemberVO member = (MemberVO)session.getAttribute("MemberVO2");
		session.setAttribute("MemberVO2", memberService.getMyInfo(member));
		return "getMyInfo.jsp";
	}
	
//	@RequestMapping(value="/purchasingList")
//	public String purchasingList(HttpSession session) {
//		System.out.println("구매 내역 보기 전");
//		MemberVO vo = (MemberVO) session.getAttribute("MemberVO2");
//		memberService.purchasingList(vo);
//		System.out.println("구매 내역 보기 후");
//		return "login.jsp";
//	}
	
	
}
