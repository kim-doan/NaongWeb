package com.cat.web.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.web.board.dao.BoardCategoryDAO;
import com.cat.web.board.service.BoardCategoryService;
import com.cat.web.board.vo.BoardCategoryVO;
import com.cat.web.board.vo.BoardVO;

@Service("boardCategoryService")
public class BoardCategoryServiceImpl implements BoardCategoryService {
	@Autowired	
	private BoardCategoryDAO boardCategoryDAO;	

	@Override
	public BoardCategoryVO getBoardCategory(BoardVO vo) {
		BoardCategoryVO boardCategoryVO = new BoardCategoryVO();
		boardCategoryVO.setId(vo.getBcId());
		return boardCategoryDAO.getBoardCategory(boardCategoryVO);
	}
}
