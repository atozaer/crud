package com.pnj.crud.service.board;

import com.pnj.crud.dto.board.BoardSaveRequestDto;
import com.pnj.crud.dto.board.BoardsFindAllResponseDto;
import com.pnj.crud.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    List<Board> findAllPost();

    Long saveWrite(BoardSaveRequestDto boardDto);

    Object findById(Long bno);

    Page<Board> findAllPost(Pageable pageable);
}
