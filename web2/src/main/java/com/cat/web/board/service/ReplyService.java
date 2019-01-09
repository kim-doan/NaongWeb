package com.cat.web.board.service;

import java.util.*;

import com.cat.web.board.vo.BoardVO;
import com.cat.web.board.vo.ReplyVO;

public interface ReplyService {
    // 댓글 목록
    public List<ReplyVO> list(BoardVO vo);
    // 댓글 입력
    public void insertReply(ReplyVO vo);
    // 댓글 수정
    public void updateReply(ReplyVO vo);
    // 댓글 삭제
    public void deleteReply(ReplyVO vo);
    // 댓글 전체 삭제
    public void deleteReplyList(BoardVO vo);
    // 댓글 가져오기
	public ReplyVO getReply(ReplyVO vo);
}

