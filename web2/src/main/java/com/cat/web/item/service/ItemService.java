package com.cat.web.item.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cat.web.item.vo.BuyItemVO;
import com.cat.web.item.vo.ItemCategoryVO;
import com.cat.web.item.vo.ItemVO;
import com.cat.web.item.vo.TendencyAnalysisVO;
import com.cat.web.member.vo.MemberVO;


public interface ItemService {
	public void insertItem(ItemVO vo) throws SQLException, IOException;
	public void updateItem(ItemVO vo);
	public void deleteItem(ItemVO vo);
	public ItemVO getItem(ItemVO vo);
	public List<ItemVO> getItemList(ItemVO vo);
	public MemberVO buyItem(ItemVO buyItem, MemberVO user);
	public String tendencyAnalysis(TendencyAnalysisVO tend) ;
	public int maxId();
	public List<ItemVO> getHitItem();
	public List<ItemVO> getNewItemList();
	public List<ItemCategoryVO> allCategory();
	public String getType(ItemVO vo);
	public List<BuyItemVO> getDetailedBuyItemList(BuyItemVO vo);
	public List<ItemVO> getItemListByType(ItemVO vo, MemberVO user);
	public List<ItemVO> getMyFavorite(MemberVO user);
}

