package com.cat.web.board.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cat.web.board.service.BoardCategoryService;
import com.cat.web.board.service.BoardService;
import com.cat.web.board.service.ReplyService;
import com.cat.web.board.vo.BoardCategoryVO;
import com.cat.web.board.vo.BoardVO;
import com.cat.web.board.vo.ReplyVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService bService;
	@Autowired
	private BoardCategoryService BCService;
	@Autowired
	private ReplyService replyService;

	//글 등록
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET)
	public String insertBoard(@ModelAttribute BoardCategoryVO vo, HttpSession session, Model model) throws IOException {
		System.out.println("insertBoard GET 구문");		
		if (session.getAttribute("MemberVO2") == null) {
			return "login.jsp";
		} else {	
			// 확인해야될 부분
			BoardVO board = new BoardVO();
			board.setBcId(vo.getId());
			//model.addAttribute("boardCategory", BCService.getBoardCategory(board));
			return "insertBoard.jsp";			
		}
	}
	
	//댓글 등록
	@RequestMapping(value="/insertReply.do", method=RequestMethod.POST)	
	public String insertReply(@ModelAttribute ReplyVO vo) {
		System.out.println("insertReply POST 구문");
		replyService.insertReply(vo);
		System.out.println("--------------성공--------------");
		return "getBoardList.do";
	}
	
	//댓글 수정
	@RequestMapping("/getReply.do")
	public String getReply(@ModelAttribute ReplyVO vo, Model model) {
		replyService.updateReply(vo);
		return "getBoardList.do";
	}
	
	//댓글 삭제
	@RequestMapping("/deleteReply.do")
	public String deleteReply(@ModelAttribute ReplyVO vo) {
		replyService.deleteReply(vo);
		return "getBoard.do?id="+vo.getParentId();
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.POST)	
	public String insertBoard(@ModelAttribute BoardVO vo) {
		System.out.println("insertBoard POST 구문");
		bService.insertBoard(vo);
		System.out.println("--------------성공--------------");
		return "getBoardList.do";
	}
	
	//글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute BoardVO vo, Model model) {
		bService.updateBoard(vo);
		vo.setModify(true);
		BoardVO getBoard = bService.getBoard(vo);
		return "getBoardList.do?bcId="+getBoard.getBcId();	
	}

	//글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(@ModelAttribute BoardVO vo) {
		vo.setModify(true);
		BoardVO getBoard = bService.getBoard(vo);
		replyService.deleteReplyList(vo);
		bService.deleteBoard(vo);
		return "getBoardList.do?bcId="+getBoard.getBcId();	
	}

	//글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(@ModelAttribute BoardVO vo, Model model) {
		List<ReplyVO> list = replyService.list(vo);
	    // 뷰에 전달할 데이터 지정
		model.addAttribute("replylist", list);
		BoardVO board = bService.getBoard(vo);
	    model.addAttribute("board", board);
	    //model.addAttribute("boardCategory", BCService.getBoardCategory(board));
	    if (vo.isModify()) {
	    	return "updateBoard.jsp";
	    }
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardCategory.do")
	public String getBoardCategory(@ModelAttribute BoardVO vo, Model model) {
	    model.addAttribute("boardCategory", BCService.getBoardCategory(vo));
		return "insertBoard.jsp";
	}
	
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}	

	//글 목록 검색
	@SuppressWarnings("unchecked")
	@RequestMapping("/getBoardList.do")
	public String getBoardList(	
			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		Map<String, Object> mapModel = model.asMap();
		Map<String, String> conditionMap = (Map<String, String>)mapModel.get("conditionMap");
		System.out.println("제목 = " + conditionMap.get("제목"));
		System.out.println("내용 = " + conditionMap.get("내용"));
		if(condition != null) {
			vo.setSearchCondition(condition);
			vo.setSearchKeyword(keyword);
		}
		model.addAttribute("boardList", bService.getBoardList(vo)); 
		//model.addAttribute("boardCategory", BCService.getBoardCategory(vo));
		model.addAttribute("pageNumberList", bService.getBoardPageList(vo));
		//로그인했을때 보드에 글쓴이 이름을 넘겨줌
		//model.addAttribute("writer_pp", ((UserVO) session.getAttribute("userVO")).getName());
		return "getBoardList.jsp"; //View 이름 리턴
	}

}
