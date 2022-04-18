package com.mycompany.idev.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.idev.mapper.MemberMapper;
import com.mycompany.idev.dto.Member;

@Controller
@RequestMapping(value = "/member")
//@SessionAttributes({"member"})
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberMapper mapper;	//dao 역할
	
	@GetMapping("/list.do")
	public String list(Model model) {			//매개변수로 선언된 Model 객체를 이용하여
											//지정된 view또는 redirect url 로 데이터를 전달
		List<Member> list = mapper.selectAll();
		model.addAttribute("list", list);	//view 에서는 el ${list}
		return "member/MemberList";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "member/MemberForm";
	}
	
	@PostMapping("/join.do")
	public String insert(Member member) {
								//폼입력된 값의 name 속성과 Member객체가 매핑되어
											//데이터가 저장됩니다.
//		response.setCharacterEncoding("UTF-8");
		logger.info("[my]"+member);
		mapper.addMember(member);									
		return "redirect:../";
	}	//회원가입 
	
	@GetMapping("/update.do")
	public String update(@SessionAttribute("member") Member member) {
		return "member/MemberUpdateForm";
	}
	
	@PostMapping("/save.do")
	public void save(Member member,Model model,HttpServletResponse response) throws IOException {
		mapper.updateMember(member);
		model.addAttribute("member", member);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String url="./update.do"; String message="회원정보 수정되었습니다.";
		out.print("<script>alert('" +message +"');location.href='"+url+"'");
		out.print("</script>");
		//return "redirect:./update.do";
	}
	
	@GetMapping("/idCheck.do")
	public String idCheck(String email,Model model) {
		int check = mapper.checkEmail(email);
		if(check==0) {
			model.addAttribute("email",email);
			model.addAttribute("msg", "는 사용가능한 이메일 입니다.");
		}else {
			model.addAttribute("email",email);
			model.addAttribute("msg","는 중복된 이메일입니다. 다른 이메일을 입력해주세요");
		}
		return "member/idCheck";
	}
	
	
	
}
