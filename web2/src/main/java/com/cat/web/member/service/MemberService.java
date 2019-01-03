package com.cat.web.member.service;

import java.util.List;

import com.cat.web.item.vo.BuyItemVO;
import com.cat.web.member.vo.MemberVO;

public interface MemberService {
	//회원 등록
	public void insertUser(MemberVO vo);
	//ID 중복검사
	public int checkID(MemberVO vo);
	//회원 로그인
	public MemberVO LogIn(MemberVO vo);
	//회원 정보 보기
	public MemberVO getMyInfo(MemberVO vo);
	//회원 정보 수정
	public void updateInfo(MemberVO vo);
	//회원 탈퇴
	public void deleteUser(MemberVO vo);
	//회원 정보 리스트 받아오기
	public List<MemberVO> getUserList(MemberVO vo);
	//구매 내역
	public List<BuyItemVO> purchasingList(MemberVO vo);
}
