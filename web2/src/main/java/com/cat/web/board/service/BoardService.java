package com.cat.web.board.service;

import java.util.*;

import com.cat.web.board.vo.BoardVO;

public interface BoardService {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	public List<Integer> getBoardPageList(BoardVO vo);
}