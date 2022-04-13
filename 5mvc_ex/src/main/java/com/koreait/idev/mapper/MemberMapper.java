package com.koreait.idev.mapper;

import java.util.List;
import java.util.Map;

import com.koreait.idev.model.Member;

public interface MemberMapper {
	int getCount();
	List<Member> selectAll();
	Member selectByMno(int mno);
	Member login(Map<String, String> map);
	int checkEmail(String mail);
	int addMember(Member member);
	int updateMember(Member member);
}
