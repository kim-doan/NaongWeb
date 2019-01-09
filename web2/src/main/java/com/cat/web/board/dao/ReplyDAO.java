package com.cat.web.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cat.web.board.vo.BoardVO;
import com.cat.web.board.vo.ReplyVO;

import java.util.*;
@Repository
public class ReplyDAO {
    @Autowired
    SqlSessionTemplate mybatis;
    
    // 댓글 목록
    public List<ReplyVO> list(BoardVO vo) {
        return mybatis.selectList("BoardDAO.listReply", vo);
    }
    // 댓글 작성
    public void insertReply(ReplyVO vo) {
        mybatis.insert("BoardDAO.insertReply", vo);
    }
    // 댓글 수정
    public void updateReply(ReplyVO vo) {
    	mybatis.update("BoardDAO.updateReply", vo);	
    }
    // 댓글 삭제   
	public void deleteReply(ReplyVO vo) {
		mybatis.delete("BoardDAO.deleteReply", vo);		
	}
	//글과 관련된 댓글 전체 삭제
	public void deleteReplyList(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteReplyList", vo);	
	}
	public ReplyVO getReply(ReplyVO vo) {
		return mybatis.selectOne("BoardDAO.getReply", vo);
	} 	
}

