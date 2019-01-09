package com.cat.web.board.vo;

import java.util.*;

public class ReplyVO {
    private int id;					// 댓글 번호
    private int parentId;			// 게시글 번호
    private String replyer;			// 댓글 작성자
    private int replyerId;			// 댓글작성자번호
    private String replytext;		// 댓글 내용
    private Date regDate;			// 댓글 작성일자
    private Date updatedate;		// 댓글 수정일자
	
    // Getter/Setter
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public int getReplyerId() {
		return replyerId;
	}
	public void setReplyerId(int replyerId) {
		this.replyerId = replyerId;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [id=" + id + ", parentId=" + parentId + ", replyer=" + replyer + ", replyerId=" + replyerId
				+ ", replytext=" + replytext + ", regdate=" + regDate + ", updatedate=" + updatedate + "]";
	}	    
}
