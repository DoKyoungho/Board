package com.board.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDao;
import com.board.dto.Board;
import com.board.util.CUtil;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class BoardServiceImpl implements BoardService {
	//BoardService는 데이터는 모두 Dao에게 위임
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Board> getList(){
		return boardDao.getList();
	}

	@Override
	public long insert(Map<String, Object> param) {
		boardDao.insert(param);
		
		/*BigInteger bigIntId = (BigInteger)param.get("id");
		long newId = bigIntId.longValue();*/
		return CUtil.getAsLong(param.get("id"));
	}
	
	@Override
	public int getTotalCount() {
	
		return boardDao.getTotalCount();
	}
	
	@Override
	public Board getOne(long id) {
		
		return boardDao.getOne(id);
	}
	
	@Override
	public void modify(Map<String, Object> param) {
		boardDao.modify(param);
	}
	
	@Override
	public void delete(long id) {
		boardDao.delete(id);
	}
	
	@Override
	public void hitUp(long id) {
		boardDao.hitUp(id);
	}
}
