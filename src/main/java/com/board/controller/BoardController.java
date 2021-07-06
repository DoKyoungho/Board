package com.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.dto.Board;
import com.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j   //디버깅 용도
public class BoardController {
	@Autowired
	BoardService boardService;		
	//게시물 리스트
	@RequestMapping("/board/list")
	public String showList(Model model) {
		List<Board> list = boardService.getList();
		//개시물 총 개수 조회
		int totalCount = boardService.getTotalCount();
		
		model.addAttribute("list",list);
		model.addAttribute("totalCount",totalCount);
		return "board/list";
	}
	
	//디테일
	@RequestMapping("/board/detail")
	public String showDetail(Model model, long id) {
		Board board = boardService.getOne(id);
		
		boardService.hitUp(id);
		
		model.addAttribute("board", board);
		
		return "board/detail";
	}
	
	//게시물 등록
	@RequestMapping("/board/insert")
	public String showInsert() {
		return "board/insert";
	}	
	@RequestMapping("/board/doInsert")
	@ResponseBody
	public String doInsert(@RequestParam Map<String, Object> param) {
		long newId = boardService.insert(param);
		
		String msg = newId+ "번 게시물이 추가되었습니다.";
		//새객체 생성이아니라 기존 데이터에 더하는 방식을 사용해서 속도 빠르고 부하 적음.
		StringBuilder sb = new StringBuilder();
		
		sb.append("alert('"  + msg + "');");
		sb.append("location.replace('./detail?id=" + newId + "');");
		
		sb.insert(0, "<script>");
		sb.append("</script>");
	
		
		return sb.toString();
	}
	
	@RequestMapping("/board/modify")
	public String showModify(Model model, long id) {
		Board board = boardService.getOne(id);
		
		model.addAttribute("board", board);
		
		return "board/modify";
	}
	
	@RequestMapping("/board/doModify")
	@ResponseBody
	public String doModify(@RequestParam Map<String, Object> param, long id) {
		boardService.modify(param);

		String msg = id + "번 게시물이 수정되었습니다.";

		StringBuilder sb = new StringBuilder();

		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./detail?id=" + id + "');");

		sb.insert(0, "<script>");
		sb.append("</script>");
		
		return sb.toString();
	}
	
	@RequestMapping("/board/doDelete")
	@ResponseBody
	public String doDelete(long id) {
		boardService.delete(id);
		
		String msg = id + "번 게시물이 삭제되었습다.";
		StringBuilder sb = new StringBuilder();
		
		sb.append("alert('" + msg + "');");
		sb.append("location.replace('./list');");
		
		sb.insert(0, "<script>");
		sb.append("</script>");
		
		return sb.toString();
	}
}