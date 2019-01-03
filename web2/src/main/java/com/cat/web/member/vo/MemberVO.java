package com.cat.web.member.vo;

import java.util.*;

import com.cat.web.item.vo.BuyItemVO;

public class MemberVO {
	private int no;
	private String id;
	private String password;
	private String name;
	private String ssnum;
	private String email;
	private String phone;
	private int admin;
	private String address;
	private String sex;
	
	private List<BuyItemVO> purchasingList;		//구매 내역
	private List<FavoriteCategoryVO> myFavoriteList = new ArrayList<FavoriteCategoryVO>();
	private Integer[] myFavoriteId;	//관심 사항
	
	private String tendencyAnalysis; // 매출분석
	
	//관리자모드 like검색 변수
	private String searchCondition;
	private String searchKeyword;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsnum() {
		return ssnum;
	}
	public void setSsnum(String ssnum) {
		this.ssnum = ssnum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", ssnum=" + ssnum + ", email="
				+ email + ", phone=" + phone + ", admin=" + admin + ", address=" + address + ", sex=" + sex + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public List<BuyItemVO> getPurchasingList() {
		return purchasingList;
	}
	public void setPurchasingList(List<BuyItemVO> purchasingList) {
		this.purchasingList = purchasingList;
	}
	public List<FavoriteCategoryVO> getMyFavoriteList() {
		return myFavoriteList;
	}
	public void setMyFavoriteList(List<FavoriteCategoryVO> myFavoriteList) {
		this.myFavoriteList = myFavoriteList;
	}
	public String getTendencyAnalysis() {
		return tendencyAnalysis;
	}
	public void setTendencyAnalysis(String tendencyAnalysis) {
		this.tendencyAnalysis = tendencyAnalysis;
	}
	public Integer[] getMyFavoriteId() {
		return myFavoriteId;
	}
	public void setMyFavoriteId(Integer[] myFavoriteId) {
		this.myFavoriteId = myFavoriteId;
	}
}
