package com.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.Board;

@Mapper //이렇게해주면 BoardDao의 구현체를 마이바티스가 대신 구현해준다.
public interface BoardDao {
	public List<Board> getList();

	public void insert(Map<String, Object> param);

	public int getTotalCount();

	public Board getOne(long id);

	public void modify(Map<String, Object> param);

	public void delete(long id);

	public void hitUp(long id);
	
}
