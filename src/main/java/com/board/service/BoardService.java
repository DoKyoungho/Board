package com.board.service;

import java.util.List;
import java.util.Map;

import com.board.dto.Board;

public interface BoardService {
	//Select
	public List<Board> getList();
	//Insert
	public long insert(Map<String, Object> param);
	
	//totalcount
	public int getTotalCount();

	public Board getOne(long id);
	
	public void modify(Map<String, Object> param);
	
	public void delete(long id);
	
	public void hitUp(long id);
	

	
	
}
