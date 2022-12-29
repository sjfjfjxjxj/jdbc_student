package com.kh.jdbc.day02.member.model.vo;

public class Member {
    String memberId;
    String memberPwd;
    String memberName;
    String memberGender;
    String memberAge;
    String memberEmail;
    String memberPhone;
    String memberAddress;
    String memberHobby;
    String memberDate;
	
    
    public Member() {
		super();
	}


	public Member(String memberId, String memberPwd, String memberName, String memberGender, String memberAge,
			String memberEmail, String memberPhone, String memberAddress, String memberHobby, String memberDate) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberAge = memberAge;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberAddress = memberAddress;
		this.memberHobby = memberHobby;
		this.memberDate = memberDate;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPwd() {
		return memberPwd;
	}


	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberGender() {
		return memberGender;
	}


	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}


	public String getMemberAge() {
		return memberAge;
	}


	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public String getMemberHobby() {
		return memberHobby;
	}


	public void setMemberHobby(String memberHobby) {
		this.memberHobby = memberHobby;
	}


	public String getMemberDate() {
		return memberDate;
	}


	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}


	//@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", memberGender=" + memberGender + ", memberAge=" + memberAge + ", memberEmail=" + memberEmail
				+ ", memberPhone=" + memberPhone + ", memberAddress=" + memberAddress + ", memberHobby=" + memberHobby
				+ ", memberDate=" + memberDate + "]";
	}
    
    
	
	
    
    
    
    
}
