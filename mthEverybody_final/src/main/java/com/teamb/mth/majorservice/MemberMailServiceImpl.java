package com.teamb.mth.majorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teamb.mth.mapper.*;
import com.teamb.mth.vo.*;

@Service
public class MemberMailServiceImpl implements MemberMailService 
{
	@Autowired
	MemberMailSQLMapper memberMailSQLMapper;
	@Autowired
	MemberSQLMapper memberSQLMapper;
	
	//인증키 설정
	@Override
	public void setKeyForJoin(MemberVO requestMemberVO, String key) 
	{
		//저장할 컬럼 값 설정
		MemberMailVO requestMemberMailVO = new MemberMailVO();
		
		String member_idx = memberSQLMapper.selectById(requestMemberVO).getMember_idx();
		requestMemberMailVO.setMember_idx(member_idx);
		requestMemberMailVO.setKey(key);
		
		memberMailSQLMapper.insertKey(requestMemberMailVO);
	}
	
	//인증키 확인
	@Override
	public boolean certifyKey(MemberMailVO requestMemberMailVO) 
	{
		MemberMailVO memberMailVO = memberMailSQLMapper.selectInDuedate(requestMemberMailVO.getMember_idx());
		
		//유효한 기간의 인증키가 존재하고 인증키가 동일하면 true 리턴
		if(memberMailVO != null && memberMailVO.getKey().equals(requestMemberMailVO.getKey()))
		{
			memberSQLMapper.updateForJoining(memberMailVO.getMember_idx());
			return true;
		}
		
		return false;
	}

	//인증완료
	@Override
	public void successCertify(String member_idx) {
		memberMailSQLMapper.updateCertifyCheckForY(member_idx);
	}

	//인증키 재전송
	@Override
	public void updateKey(String member_idx, String key) 
	{
		MemberMailVO requestMemberMailVO = new MemberMailVO();
		requestMemberMailVO.setMember_idx(member_idx);
		requestMemberMailVO.setKey(key);
		
		memberMailSQLMapper.updateKey(requestMemberMailVO);
	}
	
	//유효기간 관계없이 member_idx로 VO 가져오기
	@Override
	public MemberMailVO getMemberMailVO(String member_idx) 
	{
		return memberMailSQLMapper.selectByMemberIdx(member_idx);
	}

	//이메일 변경시 인증여부 다시 N으로 변경
	@Override
	public void resetCertifying(String member_idx) 
	{
		memberMailSQLMapper.updateCertifyCheckForN(member_idx);
	}
}
