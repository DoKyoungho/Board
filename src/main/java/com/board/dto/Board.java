package com.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board{
	private long id;
	private String regDate;
	private String title;
	private String body;	
	private long hit;
}