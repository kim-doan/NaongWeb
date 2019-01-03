package com.cat.web.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cat.web.member.vo.FavoriteCategoryVO;
import com.cat.web.member.vo.MemberVO;

import java.util.*;

@Repository
public class FavoriteDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//관심 사항 등록
	public void insertMyFavorite(FavoriteCategoryVO vo) {
		mybatis.insert("MemberDAO.insertMyFavorite", vo);
	}

	//관심 사항 삭제
	public void deleteMyFavorite(FavoriteCategoryVO vo) {	
		mybatis.delete("MemberDAO.deleteMyFavorite", vo);	
	}

	//관심 사항 중복 검사
	public int checkMyFavorite(FavoriteCategoryVO vo) {
		return mybatis.selectOne("MemberDAO.checkMyFavorite", vo);	
	}

	//관심 사항 보기
	public List<FavoriteCategoryVO> getMyFavorite(MemberVO vo) {
		return mybatis.selectList("MemberDAO.getMyFavorite", vo);
	}
	
}
