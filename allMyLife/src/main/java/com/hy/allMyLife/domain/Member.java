package com.hy.allMyLife.domain;

public class Member {
	
	private String memberId;		// 회원고유값
	private String userId; 			// 회원 ID
	private String password; 		// 비밀번호
	private String userName; 		// 회원명
	private String nickname;		// 닉네임
	private String gender; 			// 성별
	private String phoneNumber; 	// 휴대전화
	private String email;			// 이메일
	private String joinDate; 		// 가입일
	private String lastConnectDate; //최근 접속일
	private String modifyDate; 		// 수정일
	private String withdrawalDate; 	//탈퇴날짜
	private String userStatus;		// 사용자 상태 > S:관리자, U:활성화, D:탈퇴
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getLastConnectDate() {
		return lastConnectDate;
	}
	public void setLastConnectDate(String lastConnectDate) {
		this.lastConnectDate = lastConnectDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getWithdrawalDate() {
		return withdrawalDate;
	}
	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}
