package com.pnj.crud.dto.board;

import com.pnj.crud.entity.Board;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class BoardFindResponseDto {
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


//	public Board toEntity() {
//		return Board.builder()
//				.bNo(bNo)
//				.bTitle(bTitle)
//				.bContent(bContent)
//				.bWriter(bWriter)
//				.bRegDate(bRegDate)
//				.bReadCount(bReadCount)
//				.bRef(bRef)
//				.bStep(bStep)
//				.bDepth(bDepth)
//				.build();
//	}
//	@Builder
//	public BoardFindResponseDto (
//			long bno,
//			String bTitle,
//			String bContent,
//			String bWriter,
//			String bRegDate,
//			int bReadCount,
//			Long bRef,
//			int bStep,
//			int bDepth
//	) {
//		this.bNo = bno;
//		this.bTitle = bTitle;
//		this.bContent = bContent;
//		this.bWriter = bWriter;
//		this.bRegDate = bRegDate;
//		this.bReadCount = bReadCount;
//		this.bRef = bRef;
//		this.bStep = bStep;
//		this.bDepth = bDepth;
//	}
}
