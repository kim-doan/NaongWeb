package com.cat.web.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.web.member.dao.FavoriteDAO;
import com.cat.web.member.vo.FavoriteCategoryVO;
import com.cat.web.member.vo.MemberVO;

import java.util.*;

@Service("favoriteService")
public class FavoriteServiceImpl {
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	public void insertMyFavorite(FavoriteCategoryVO vo) {
		favoriteDAO.insertMyFavorite(vo);
	}

	//관심 사항 삭제
	public void deleteMyFavorite(int uId) {
		FavoriteCategoryVO vo = new FavoriteCategoryVO(uId);
		favoriteDAO.deleteMyFavorite(vo);	
	}

	//관심 사항 중복 검사
	public int checkMyFavorite(FavoriteCategoryVO vo) {
		return favoriteDAO.checkMyFavorite(vo);	
	}

	//관심 사항 보기
	public List<FavoriteCategoryVO> getMyFavorite(MemberVO vo) {
		return favoriteDAO.getMyFavorite(vo);
	}
}
