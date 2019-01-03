package com.cat.web.member.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.web.util.*;
import com.cat.web.item.vo.BuyItemVO;
import com.cat.web.member.dao.MemberDAO;
import com.cat.web.member.service.MemberService;
import com.cat.web.member.vo.FavoriteCategoryVO;
import com.cat.web.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FavoriteServiceImpl favoriteServiceImpl;
	
	public MemberServiceImpl() {
		System.out.println("UserServiceImpl 생성");
	}

	@Override
	public MemberVO LogIn(MemberVO vo) {
		//암호화 작업
		securityPassword(vo);
		//로그인 되었을 시 유저
		MemberVO user = memberDAO.LogIn(vo);
		//유저 객체에 관심 사항 담아주기
		setMyFavoriteList(user);
		List<BuyItemVO> purchasingList = user.getPurchasingList();
		Collections.sort(purchasingList, new RecentCompare());
		user.setPurchasingList(purchasingList);
		return user;
	}

	@Override
	public void insertUser(MemberVO vo) {
		//암호화 작업
		securityPassword(vo);
		memberDAO.insertUser(vo);
	}

	@Override
	public int checkID(MemberVO vo) {
		return memberDAO.checkID(vo);
	}

	@Override
	public MemberVO getMyInfo(MemberVO vo) {
		MemberVO user = memberDAO.getMyInfo(vo);
		//유저 객체에 관심 사항 담아주기
		setMyFavoriteList(user);
		List<BuyItemVO> purchasingList = user.getPurchasingList();
		Collections.sort(purchasingList, new RecentCompare());
		user.setPurchasingList(purchasingList);
		return user;
	}
	
	@Override
	public void deleteUser(MemberVO vo) {
		//정보 변경 전 유저가 가지고 있는 관심 사항 삭제
		favoriteServiceImpl.deleteMyFavorite(vo.getNo());
		memberDAO.deleteUser(vo);
	}
	
	@Override
	public void updateInfo(MemberVO vo) {
		//정보 변경 전 유저가 가지고 있는 관심 사항 삭제
		favoriteServiceImpl.deleteMyFavorite(vo.getNo());
		Integer[] myFavoriteList = vo.getMyFavoriteId();
		if (myFavoriteList != null) {
			for (int myFavorite : myFavoriteList) {
				FavoriteCategoryVO fcVO = new FavoriteCategoryVO(vo.getNo(), myFavorite);
				favoriteServiceImpl.insertMyFavorite(fcVO);	//유저의 관심 사항 등록
			}			
		}
		memberDAO.updateInfo(vo);
	}

	@Override
	public List<MemberVO> getUserList(MemberVO vo) {
		return memberDAO.getUserList(vo);
	}
	
	@Override
	public List<BuyItemVO> purchasingList(MemberVO vo) {
		return memberDAO.purchasingList(vo);
	}
	
	//비밀 번호 암호화 작업
	public void securityPassword(MemberVO vo) {
		SecurityUtil security = new SecurityUtil();
		String password = security.encryptSHA256(vo.getPassword());
		vo.setPassword(password);
	}
	
	//유저 객체에 관심 사항 담아주기
	public void setMyFavoriteList(MemberVO vo) {
		//유저의 관심 사항 가져오기
		List<FavoriteCategoryVO> myFavoriteList = favoriteServiceImpl.getMyFavorite(vo);
		//결과를 객체의 favoriteList에 담아준다
		vo.setMyFavoriteList(myFavoriteList);
	}

	//유저의 관심상품 등록
	public MemberVO addMyFavoriteList(MemberVO vo, int itemIcId) {
		FavoriteCategoryVO fcVO = new FavoriteCategoryVO(vo.getNo(), itemIcId);
		//산 상품과 관심 상품 간 중복 검색(중복이라면 1 아니면 0)
		//중복이 아니라면 관심 상품 등록
		if (favoriteServiceImpl.checkMyFavorite(fcVO) == 0) {
			favoriteServiceImpl.insertMyFavorite(fcVO);		//유저의 관심 사항 등록
		}
		return getMyInfo(vo);
	}
	
	
	//최신순 정렬
	class RecentCompare implements Comparator<BuyItemVO> {
		@Override
		public int compare(BuyItemVO obj1, BuyItemVO obj2) {
			return obj2.getBuyTime().compareTo(obj1.getBuyTime());
		}
	}
}

