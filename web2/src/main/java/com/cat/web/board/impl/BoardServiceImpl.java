package com.cat.web.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.web.board.dao.BoardDAO;
import com.cat.web.board.service.BoardService;
import com.cat.web.board.vo.BoardVO;

import java.util.*;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	
	
	public BoardServiceImpl() {
		System.out.println("BoardServiceImpl Bean 생성 중입니다...");
	}

	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {		
		BoardVO boardVO = boardDAO.getBoard(vo);
		System.out.println(vo.isModify());
		if (!vo.isModify() & !vo.isReplyModify()) {
			boardVO.incReadCnt();
			boardDAO.updateCounter(boardVO);
		}
		return boardVO;
	}
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
	@Override
	public List<Integer> getBoardPageList(BoardVO vo) {
		int totalBoardCount = boardDAO.getBoardCount(vo);
		System.out.println(totalBoardCount);
		List<Integer> boardPageList = new ArrayList<Integer>();
		for (int i = 0; i < (totalBoardCount - 1) / 10 + 1; i ++) {
			boardPageList.add(i+1);
		}
		return boardPageList;
	}
}
