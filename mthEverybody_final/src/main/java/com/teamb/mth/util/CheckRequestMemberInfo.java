package com.teamb.mth.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import com.teamb.mth.vo.MemberVO;

public class CheckRequestMemberInfo 
{
	private MemberVO requestMemberVO;
	
	public CheckRequestMemberInfo(MemberVO requestMemberVO)
	{
		this.requestMemberVO = requestMemberVO;
	}
	
	//회원가입할 때 확인
	public boolean checkJoinMemberVO() throws UnsupportedEncodingException
	{
		//입력받은 값
		String member_id = requestMemberVO.getMember_id();
		String member_pw = requestMemberVO.getMember_pw();
		String member_nick = requestMemberVO.getMember_nick();
		String member_email = requestMemberVO.getMember_email();
		
		//NULL check
		if(member_id == null || member_pw == null || member_nick == null || member_email == null) { return false; }
		
		//정규표현식
		Pattern idVaildPattern = Pattern.compile("^[a-zA-Z0-9]{5,12}$");
		Pattern nickUnvaildPattern = Pattern.compile("^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣|0-9]{3,12}$");
		Pattern emailValidPattern = Pattern.compile("^[a-z0-9A-Z_-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$");
		
		//UTF-8 기준 byte 크기
		byte[] idBytes = member_id.getBytes("utf-8");
		byte[] nickBytes = member_nick.getBytes("utf-8");
		byte[] emailBytes = member_email.getBytes("utf-8");
		
		//ID: 5자 이상 12자 이내 영소문자+숫자 조합만 가능(공백X), DB size: 20(13) bytes(delMember때문에 7bytes 불가용)
		if(member_id.indexOf(' ') != -1) { return false; }
		if(idVaildPattern.matcher(member_id).find() == false) { return false; }
		if(idBytes.length > 13) { return false; }
		
		//PW: 8자 이상 15자 이내 문자(공백X), , DB size: 50 bytes (암호화해서 들어감)
		if(member_pw.indexOf(' ') != -1) { return false; }
		if(member_pw.length() > 15 || member_pw.length() < 8) { return false; }
		
		//NICK: 3자 이상 12자 이내 영문자+숫자+한글 조합만(공백X), DB size: 40 bytes
		if(member_nick.indexOf(' ') != -1) { return false; }
		if(nickUnvaildPattern.matcher(member_nick).find() == false) { return false; }
		if(nickBytes.length > 40) { return false; }
		
		//Email 형식체크(공백X), DB size: 50(43) bytes(delMember때문에 7bytes 불가용)
		if(member_email.indexOf(' ') != -1) { return false; }
		if(emailValidPattern.matcher(member_email).find() == false) { return false; }
		if(emailBytes.length > 43) { return false; }
		
		return true;
	}
	
	//회원정보 수정
	public boolean checkInfoForUpdate() throws UnsupportedEncodingException
	{
		String member_code = requestMemberVO.getMember_code();
		String member_nick = requestMemberVO.getMember_nick();
		String member_phone = requestMemberVO.getMember_phone();
		
		if(member_nick == null) { return false; }
		
		Pattern nickUnvaildPattern = Pattern.compile("^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣|0-9]{3,15}$");
		Pattern phoneVaildPattern = Pattern.compile("^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$");

		byte[] nickBytes = member_nick.getBytes("utf-8");
		
		//NICK: 3자 이상 12자 이내 문자(공백X, 특수문자X)
		if(member_nick.indexOf(' ') != -1) { return false; }
		if(nickUnvaildPattern.matcher(member_nick).find() == false) { return false; }
		if(nickBytes.length > 40) { return false; }
		
		//판매자, 관리자일때
		if(member_code.equals("SELLER") || member_code.equals("ADMIN"))
		{
			if(member_phone == null) { return false; }
			
			//PHONE: 010|011|016~9 - 숫자{3,4} - 숫자{4} 만 가능
			if(member_phone.indexOf(' ') != -1) { return false; }
			if(phoneVaildPattern.matcher(member_phone).find() == false) { return false; }
		}
		
		return true;
	}
	
	//아이디 확인
	public boolean checkOnlyId() throws UnsupportedEncodingException
	{
		String member_id = requestMemberVO.getMember_id();

		if(member_id == null) { return false; }
		
		Pattern idVaildPattern = Pattern.compile("^[a-zA-Z0-9]{5,12}$");
		byte[] idBytes = member_id.getBytes("utf-8");
		
		if(member_id.indexOf(' ') != -1) { return false; }
		if(idVaildPattern.matcher(member_id).find() == false) { return false; }
		if(idBytes.length > 13) { return false; }

		return true;
	}
	
	//이메일 변경시 확인
	public boolean checkOnlyEmail() throws UnsupportedEncodingException
	{
		String member_email = requestMemberVO.getMember_email();
		
		if(member_email == null) { return false; }
		Pattern emailValidPattern = Pattern.compile("^[a-z0-9A-Z_-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$");
		byte[] emailBytes = member_email.getBytes("utf-8");
		
		//Email 형식체크(공백X), DB size: 50(43) bytes(delMember때문에 7bytes 불가용)
		if(member_email.indexOf(' ') != -1) { return false; }
		if(emailValidPattern.matcher(member_email).find() == false) { return false; }
		if(emailBytes.length > 43) { return false; }
		
		return true;
	}

	//비밀번호 변경시 확인
	public boolean checkOnlyPassword()
	{
		String member_pw = requestMemberVO.getMember_pw();
		if(member_pw == null) { return false; }
		
		//PW: 8자 이상 15자 이내 문자(공백X)
		if(member_pw.indexOf(' ') != -1) { return false; }
		if(member_pw.length() > 15 || member_pw.length() < 8) { return false; }
		
		return true;
	}
	
	//판매자회원 신청 확인
	public boolean checkReqSellerInfo() throws UnsupportedEncodingException
	{
		String member_name = requestMemberVO.getMember_name();
		String member_phone = requestMemberVO.getMember_phone();
		String member_companynum = requestMemberVO.getMember_companynum();
		
		//NULL check
		if(member_name == null || member_phone == null || member_companynum == null) { return false; }
		
		Pattern nameVaildPattern = Pattern.compile("^[가-힣]{2,8}$");
		Pattern phoneVaildPattern = Pattern.compile("^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$");
		Pattern companynumVaildPattern = Pattern.compile("^[0-9]{10}$");
		
		byte[] nameBytes = member_name.getBytes("utf-8");
		byte[] companynumBytes = member_companynum.getBytes("utf-8");
		
		//NAME: 2자 이상 8자 이내 한글만 가능(공백X), DB size: 25 bytes
		if(member_name.indexOf(' ') != -1) { return false; }
		if(nameVaildPattern.matcher(member_name).find() == false) { return false; }
		if(nameBytes.length > 25) { return false; }
		
		//PHONE: 010|011|016~9 - 숫자{3,4} - 숫자{4} 만 가능
		if(member_phone.indexOf(' ') != -1) { return false; }
		if(phoneVaildPattern.matcher(member_phone).find() == false) { return false; }
		
		//Companynum(사업자등록번호): 10자 숫자, DB size: 10 bytes
		if(member_companynum.indexOf(' ') != -1) { return false; }
		if(companynumVaildPattern.matcher(member_companynum).find() == false) { return false; }
		if(companynumBytes.length > 10) { return false; }
		
		return true;
	}
}
