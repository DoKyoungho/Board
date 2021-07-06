package com.board.service;

import java.util.Map;

import com.board.dto.Member;

public interface MemberService {

	public Map<String, Object> checkLoginIdDup(String loginId);

	public Map<String, Object> join(Map<String, Object> param);

	public Member getMatchedOne(String string, String string2);

	public Member getOne(long loginedMemberId);

}
