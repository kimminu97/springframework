package com.koreait.idev.controller;

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

import com.koreait.idev.mapper.ScheduleMapper;
import com.koreait.idev.model.Member;
import com.koreait.idev.model.Schedule;

@Controller
@RequestMapping("schedule/")
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	ScheduleMapper mapper; // dao 역할, 의존관계 주입

	@GetMapping("/new.do")
	public String newdo(@SessionAttribute(value = "member", required = false) Member member, Model model) {
		// 로그인 상태가 아닐때 : 400 오류 member가 없어서
		// -> sessionAttribute 에 대해 필수적인값 false로 설정
		// 현재 로그인한 사용자의 스케쥴 리스트 가져와서 출력
		// mapper메소드 전 오류인지 확인
		logger.info("get이전");
		// mno오류
		// session에 저장된(로그인) member 가져오는지 확인
		logger.info("member가져오기" + member);
		List<Schedule> list = mapper.getSchedules(member.getMno());
		// mapper메소드 후 오류인지 확인
		logger.info("get이후");

		model.addAttribute("list", list);
		return "schedule/schedule";
	}

	@GetMapping("/save.do")
	public String save(Schedule sch, Model model) {
		logger.info("[my]" + sch.getSdate() + " " + sch.getStime());
		String dt = sch.getSdate() + " " + sch.getStime();
		sch.setSdate(dt);
		mapper.insert(sch);

		return "redirect:new.do";
	}

	@GetMapping("/delete.do")
	public void delete(int idx, @SessionAttribute(value = "member", required = false) Member member,
			HttpServletResponse response) throws IOException {
		String message;
		// 로그인상태가 아닐때는 member는 null
		if (member != null && mapper.checkMno(idx) == member.getMno()) { // mno비교하기
			message = "삭제 하였습니다.";
			mapper.delete(idx);
		} else {
			message = "삭제 오류입니다.";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String url = "./new.do";
		out.print("<script>alert('" + message + "');location.href='" + url + "'");
		out.print("</script>");
	}

}
