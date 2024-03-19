package com.hy.allMyLife.repository;

import java.util.Optional;

import com.hy.allMyLife.domain.Member;

public interface MemberRepository {
	
	// 가입하기
	Member join(Member member);
	
	// 아이디찾기(이메일인증)
	Optional<Member> findIdByEmail();
	
	// 아이디찾기(가입저보)
	Optional<Member> findIdByUserInfo();
	
	// 비밀번호재발급(이메일인증)
	Optional<Member> findPwdByEmail();
		
	// 비밀번호 재발급(가입저보)
	Optional<Member> findPwdByUserInfo();
	
	// 로그인
	void login(Member memeber);
}
