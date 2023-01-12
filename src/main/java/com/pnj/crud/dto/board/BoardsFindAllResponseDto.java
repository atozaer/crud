package com.pnj.crud.dto.board;

import com.pnj.crud.entity.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardsFindAllResponseDto {
	private Long bNo;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private String bRegDate;
	private int bReadCount;
	private Long bRef;
	private int bStep;
	private int bDepth;
	private String delYn;
	
	public void converEntityToDto(Board board) {
		this.bNo = board.getBNo();
		this.bTitle = board.getBTitle();
		this.bContent = board.getBContent();
		this.bWriter = board.getBWriter();
		this.bDepth = board.getBDepth();
		this.bRegDate = board.getBRegDate();
		this.bReadCount = board.getBReadCount();
		this.bRef = board.getBRef();
		this.bStep = board.getBStep();
		this.bDepth = board.getBDepth();
		this.delYn = board.getDelYn();
	}
}
