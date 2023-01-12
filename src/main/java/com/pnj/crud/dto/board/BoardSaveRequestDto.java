package com.pnj.crud.dto.board;

import com.pnj.crud.entity.Board;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String bTitle;
    private String bContent;
    private String bWriter;
    private Long bRef;
    private int bStep;
    private int bDepth;
    private String delYn = "n";

    public Board toEntity() {
        return Board.builder()
                .bTitle(bTitle)
                .bContent(bContent)
                .bWriter(bWriter)
                .bRef(bRef)
                .bStep(bStep)
                .bDepth(bDepth)
                .delYn(delYn)
                .build();
    }

    @Builder
    public BoardSaveRequestDto(String bContent, String bTitle, String bWriter, Long bRef, int bStep, int bDepth, String delYn) {
        this.bTitle = bTitle;
        this.bContent = bContent;
        this.bWriter = bWriter;
        this.bRef = bRef;
        this.bStep = bStep;
        this.bDepth = bDepth;
        this.delYn = delYn;
    }

    public void setHierarchicalDepth(int bDepth) {
        this.bDepth = bDepth + 1;
    }

}
