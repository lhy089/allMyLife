package com.hy.allMyLife.repository;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.hy.allMyLife.domain.Member;

public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<String, Member> store = new HashMap<String, Member>();

	@Override
	public Member join(Member member) {
		String memberSequence = "M" + getRamdomSeq(8) ;
		store.put(memberSequence, member);
		return member;
	}

	@Override
	public Optional<Member> findIdByEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findIdByUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findPwdByEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Member> findPwdByUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void login(Member memeber) {
		// TODO Auto-generated method stub
		
	}
	
	public static String getRamdomSeq(int num) { 
		char[] charSet = new char[] {'0','1','2','3','4','5','6','7','8','9'}; 
		StringBuffer sb = new StringBuffer(); 
		SecureRandom sr = new SecureRandom(); 
		sr.setSeed(new Date().getTime()); 
		int idx = 0; 
		int len = charSet.length; 
		for (int i=0; i<num; i++) {
			idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다. 
			sb.append(charSet[idx]); 
		} 
		return "M" + sb.toString(); 
	}

}
