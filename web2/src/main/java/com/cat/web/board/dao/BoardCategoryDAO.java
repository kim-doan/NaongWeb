package com.cat.web.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cat.web.board.vo.BoardCategoryVO;

//DAO(Data Access Object)
@Repository //@Repository->저장소
public class BoardCategoryDAO {
	@Autowired
	private SqlSessionTemplate mybatis;	

	//글 상세 조회
	public BoardCategoryVO getBoardCategory(BoardCategoryVO vo) {
		return mybatis.selectOne("BoardDAO.getBoardCategory", vo);	
	}	
}