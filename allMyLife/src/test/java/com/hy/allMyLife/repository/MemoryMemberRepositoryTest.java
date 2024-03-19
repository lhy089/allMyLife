package com.hy.allMyLife.repository;

import org.junit.jupiter.api.Test;

import com.hy.allMyLife.domain.Member;

class MemoryMemberRepositoryTest {
	
	MemberRepository repository = new MemoryMemberRepository();

	@Test
	public void join() {
		Member member = new Member();
		member.setMemberId("string");

		repository.join(member);

//		Member result = repository.findById(member.getMemberId()).get();
		// System.out.println("result = " + (result == member));
		// Assertions.assertEquals(member, result); > 반대인지 확인
//		assertThat(member).isEqualTo(result); // alt + space > static import

	}

}
