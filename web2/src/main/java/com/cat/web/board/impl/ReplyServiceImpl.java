package com.cat.web.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.web.board.dao.ReplyDAO;
import com.cat.web.board.service.ReplyService;
import com.cat.web.board.vo.BoardVO;
import com.cat.web.board.vo.ReplyVO;

import java.util.*;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {    
    @Autowired
    ReplyDAO replyDAO;
    
    // 댓글 목록
    @Override
    public List<ReplyVO> list(BoardVO vo) {
        return replyDAO.list(vo);
    }
    // 댓글 작성
    @Override
    public void insertReply(ReplyVO vo) {
        replyDAO.insertReply(vo);
    }
    // 댓글 수정
    @Override
    public void updateReply(ReplyVO vo) {
    	replyDAO.updateReply(vo); 
    }
    // 댓글 삭제
    @Override
    public void deleteReply(ReplyVO vo) {
    	replyDAO.deleteReply(vo);
    }
	@Override
	public void deleteReplyList(BoardVO vo) {
		replyDAO.deleteReplyList(vo);
	}
	@Override
	public ReplyVO getReply(ReplyVO vo) {
		return 	replyDAO.getReply(vo);
	}       
}
