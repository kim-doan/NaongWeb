package com.cat.web.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cat.web.item.vo.BuyItemVO;
import com.cat.web.member.vo.FavoriteCategoryVO;
import com.cat.web.member.vo.MemberVO;;


@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mapper;
	
	//회원 가입
	public void insertUser(MemberVO vo) {
		mapper.insert("MemberDAO.insertUser", vo);
	}
	
	//회원 정보 변경
	public void updateInfo(MemberVO vo) {
		mapper.update("MemberDAO.updateInfo", vo);
	}

	//회원 관리 회원 삭제
	public void deleteUser(MemberVO vo) {	
		mapper.delete("MemberDAO.deleteUser", vo);	
	}

	//ID중복검사 확인 메소드
	public int checkID(MemberVO vo) {
		return mapper.selectOne("MemberDAO.checkID", vo);	
	}
	
	//로그인 확인
	public MemberVO LogIn(MemberVO vo) {
		return mapper.selectOne("MemberDAO.LogIn", vo);
	}
	
	//회원 정보 리스트 가져오기
	public List<MemberVO> getUserList(MemberVO vo) {
		System.out.println(mapper.selectList("MemberDAO.getUserList", vo));
		return mapper.selectList("MemberDAO.getUserList", vo);		
	}

	//회원 정보 보기
	public MemberVO getMyInfo(MemberVO vo) {
		return mapper.selectOne("MemberDAO.getMyInfo", vo);
	}
	
	//관심 사항 등록
	public void insertMyFavorite(FavoriteCategoryVO vo) {
		mapper.insert("MemberDAO.insertMyFavorite", vo);
	}

	//관심 사항 삭제
	public void deleteMyFavorite(FavoriteCategoryVO vo) {	
		mapper.delete("MemberDAO.deleteMyFavorite", vo);	
	}

	//관심 사항 중복 검사
	public int checkMyFavorite(FavoriteCategoryVO vo) {
		return mapper.selectOne("MemberDAO.checkMyFavorite", vo);	
	}

	//관심 사항 보기
	public List<FavoriteCategoryVO> getMyFavorite(MemberVO vo) {
		return mapper.selectList("MemberDAO.getMyFavorite", vo);
	}
	
	//아이디 찾기
	public static String FindID(MemberVO vo) {
		String id = null;
		String seleteSql = "select * from \"Member\" where name = ? and phone = ?;";	
		return id;
	}
	
	//비밀 번호 찾기
	public static boolean FindPassword(MemberVO vo) {
		boolean logCK = false;
		String seleteSql = "select * from \"Member\" where no = ? and phone = ?;";
		return logCK;
	}

	//비밀번호 변경
	public static void updatePassword(String id, String password) {
		String updateSql = "update \"Member\" set password = ? where no = ?;";
	}
	
	//구매 내역 보기
	public List<BuyItemVO> purchasingList(MemberVO vo) {
		return mapper.selectList("getPurchasingList", vo);
	}
}
